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

package it.unicam.cs.mgc.kebabConfigurator.model.util;

/**
 * Contenitore dei namespaces utilizzati nel progetto.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public enum URIs {
    XSD("http://www.w3.org/2001/XMLSchema#"),
    OWL("http://www.w3.org/2002/07/owl#"),
    RDF("http://www.w3.org/1999/02/22-rdf-syntax-ns#"),
    RDFS("http://www.w3.org/2000/01/rdf-schema#"),
    KEBAB("https://www.unicam.it/giorgiodellaroscia/KebabConfigurator#"),
    KEBAB_LOCAL("/KebabConfigurator.rdf"),
    ANIMAL("https://dbpedia.org/ontology/Animal"),
    ANIMAL_LOCAL("/Animal.rdf"),
    DISEASE("https://dbpedia.org/ontology/Disease"),
    DISEASE_LOCAL("/Disease.rdf"),
    FOOD("https://dbpedia.org/ontology/Food"),
    FOOD_LOCAL("/Food.rdf");

    private final String URI;

    /**
     * Associa l'URI passato per essere utilizzato.
     *
     * @param URI namespace che fa riferimento all'ontologia su cui lavorare.
     */
    URIs(String URI) {
        this.URI = URI;
    }

    /**
     * Metodo getter dell'URI.
     *
     * @return l'URI utilizzato.
     */
    public String getURI() {
        return URI;
    }
}