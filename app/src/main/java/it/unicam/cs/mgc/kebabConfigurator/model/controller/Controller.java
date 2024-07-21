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

package it.unicam.cs.mgc.kebabConfigurator.model.controller;

import it.unicam.cs.mgc.kebabConfigurator.model.parser.ParsedData;
import it.unicam.cs.mgc.kebabConfigurator.model.parser.JSONParser;
import it.unicam.cs.mgc.kebabConfigurator.model.builder.InferredModelBuilder;
import it.unicam.cs.mgc.kebabConfigurator.model.sparql.QueryExecutor;
import it.unicam.cs.mgc.kebabConfigurator.model.sparql.QueryContainer;
import it.unicam.cs.mgc.kebabConfigurator.model.util.URIs;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;

/**
 * Controller dell'ontologia. Gestisce il modello dell'ontologia verificandone la consistenza e rimandando al lancio delle query
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class Controller {
    private Model model;
    private final InferredModelBuilder inferredModelBuilder = new InferredModelBuilder();
    private final QueryExecutor queryExecutor = new QueryExecutor();


    /**
     * Costruttore che inizializza il controller con un nuovo modello dell'ontologia.
     */
    public Controller() {
        this.model = inferredModelBuilder.buildOntologyModel(OntModelSpec.OWL_DL_MEM, URIs.KEBAB_LOCAL.getURI());
        this.startInference();
    }

    /**
     * Avvia l'inferenza sul modello dell'ontologia.
     */
    public void startInference() {
        this.model = inferredModelBuilder.buildInferredModel(model, PelletReasonerFactory.THE_SPEC.getReasoner());
    }

    /**
     * Esegue una query sul modello dell'ontologia e restituisce.
     *
     * @param query la query da eseguire.
     * @return i risultati della query in formato accessibile.
     */
    public ParsedData get(QueryContainer query) {
        return new JSONParser().parse(queryExecutor.perform(query, this.model));
    }

    /**
     * Esegue una query sul modello dell'ontologia e restituisce.
     *
     * @param query la query da eseguire.
     * @param args parametri aggiuntivi di specifica.
     * @return i risultati della query in formato accessibile.
     */
    public ParsedData get(QueryContainer query, Object ... args) {
        return new JSONParser().parse(queryExecutor.perform(query, this.model, args));
    }

    /**
     * Verifica della consistenza dell'ontologia.
     *
     * @return flag booleano relativo alla consistenza dell'ontologia.
     */
    public boolean isConsistent() {
        if (this.model instanceof InfModel)
            return InferredModelBuilder.isModelConsistent((InfModel) model);
        return false;
    }
}