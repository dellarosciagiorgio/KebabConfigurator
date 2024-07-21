/*
 * MIT License
 *
 * Copyright (c) 2024 Giorgio Della Roscia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.mgc.kebabConfigurator.model.builder;

import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import java.util.concurrent.CompletableFuture;

/**
 * Costruzione di un modello RDF inferito.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class InferredModelBuilder extends DefaultModelBuilder {
    /**
     * Inferenza di modello standard.
     *
     * @param model modello di riferimento.
     * @param reasoner strumento adoperato per inferire il modello.
     * @return modello inferito.
     */
    public InfModel buildInferredModel(Model model, Reasoner reasoner) {
        reasoner.bindSchema(model);
        return ModelFactory.createInfModel(reasoner, model);
    }

    /**
     * Inferenza di modello standard in modo asincrono.
     *
     * @param model modello di riferimento.
     * @param reasoner strumento adoperato per inferire il modello.
     * @return modello inferito.
     */
    public CompletableFuture<InfModel> buildInferredModelAsync(Model model, Reasoner reasoner) {
        CompletableFuture<InfModel> completableFuture = new CompletableFuture<>();
        var thread = new Thread(() -> {
            try {
                reasoner.bindSchema(model);
                completableFuture.complete(ModelFactory.createInfModel(reasoner, model));
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        });
        thread.start();
        return completableFuture;
    }

    /**
     * Verifica della consistenza del modello inferito.
     *
     * @param model modello inferito di riferimento.
     * @return flag relativo alla consistenza del modello inferito.
     */
    public static boolean isModelConsistent(InfModel model) {
        return model.validate().isValid();
    }

    /**
     * Controllo sulla corretta inferenza del modello.
     *
     * @param subject soggetto della tripla.
     * @param predicate predicato della tripla.
     * @param object oggetto della tripla.
     * @param model modello inferito di riferimento.
     * @return flag di corretta inferenza della tripla.
     */
    public static boolean isCorrectlyInferred(Resource subject, Property predicate, Resource object, InfModel model) {
        return model.contains(subject, predicate, object);
    }
}