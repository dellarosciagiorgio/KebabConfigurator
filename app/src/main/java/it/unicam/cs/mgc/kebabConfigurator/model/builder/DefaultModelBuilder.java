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

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import java.util.Objects;

/**
 * Permette di costruire modelli di default.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class DefaultModelBuilder implements ModelBuilder {
    private final FileManager fileManager = FileManager.getInternal();

    /**
     * Costruzione di un modello basilare.
     *
     * @return il modello costruito.
     */
    @Override
    public Model buildDefaultModel() {
        return ModelFactory.createDefaultModel();
    }

    /**
     * Costruzione di un modello a partire da file di input.
     *
     * @param filenames file di input.
     * @return il modello costruito.
     */
    @Override
    public Model buildDefaultModel(String ... filenames) {
        Model model = ModelFactory.createDefaultModel();
        for (String filename : filenames)
            model.read(fileManager.open(Objects.requireNonNull(getClass().getResource(filename)).toString()), null);
        return model;
    }

    /**
     * Costruzione di un modello a partire da relative specifiche.
     *
     * @param modelSpecification specifiche.
     * @return il modello costruito.
     */
    @Override
    public Model buildOntologyModel(OntModelSpec modelSpecification) {
        return ModelFactory.createOntologyModel(modelSpecification);
    }

    /**
     * Costruzione di un modello a partire da relative specifiche e file di input.
     *
     * @param modelSpecification specifiche.
     * @param filenames file di input.
     * @return il modello costruito.
     */
    @Override
    public Model buildOntologyModel(OntModelSpec modelSpecification, String ... filenames) {
        Model model = ModelFactory.createOntologyModel(modelSpecification);
        for (String filename : filenames)
            model.read(fileManager.open(Objects.requireNonNull(getClass().getResource(filename)).toString()), null);
        return model;
    }
}