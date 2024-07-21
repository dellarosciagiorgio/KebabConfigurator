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

package it.unicam.cs.mgc.kebabConfigurator.model.sparql;

/**
 * Lista di query già pronte all'uso. Servono rispettivamente per:
 * <ul>
 *     <li>ALL_KEBABS: restituisce la label di tutti gli individui della classe kbb:Kebab;</li>
 *     <li>KEBAB_LABEL: restituisce la label dell'individuo della classe kbb:Kebab che corrisponde alla stringa passata;</li>
 *     <li>KEBAB_PRICE: restituisce la label dell'individuo della classe kbb:Kebab ed il valore della rispettiva data property kbb:price;</li>
 *     <li>KEBAB_KCAL: restituisce la label dell'individuo della classe kbb:Kebab ed il valore della rispettiva data property kbb:kcal./li>
 * </ul>
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public enum QueryContainer implements DataQuery {
    ALL_KEBABS("SELECT ?label WHERE { ?kebab rdf:type kbb:Kebab . BIND(?kebab AS ?label). }"),
    KEBAB_LABEL("SELECT ?label ?value WHERE { ?kebab rdf:type kbb:Kebab . ?kebab rdfs:label \"%s\"@en . ?kebab kbb:price ?price . BIND(?kebab AS ?label) . BIND(?kebab AS ?value) . }"),
    KEBAB_PRICE("SELECT ?label ?value WHERE { ?kebab rdf:type kbb:Kebab . ?kebab rdfs:label \"%s\"@en . ?kebab kbb:price ?price . BIND(?kebab AS ?label) . BIND(?price AS ?value) . }"),
    KEBAB_KCAL("SELECT ?label ?value WHERE { ?kebab rdf:type kbb:Kebab . ?kebab rdfs:label \"%s\"@en . ?kebab kbb:kcal ?kcal . BIND(?kebab AS ?label) . BIND(?kcal AS ?value) . }");

    private final String sparqlQuery;

    /**
     * Associazione della query passata.
     *
     * @param sparqlQuery nome identificativo della query presente nell'enumerazione.
     */
    QueryContainer(String sparqlQuery) {
        this.sparqlQuery = sparqlQuery;
    };

    /**
     * Metodo getter della query.
     *
     * @return la query.
     */
    @Override
    public String getQuery() {
        return sparqlQuery;
    }

    /**
     * Metodo getter della query con parametri.
     *
     * @return la query formattata in relazione ai parametri.
     */
    @Override
    public String getQuery(Object ... args) {
        return String.format(this.sparqlQuery, args);
    }

    /**
     * Metodo getter della query con l'aggiunta dei prefissi.
     *
     * @return la query anteceduta dai prefissi.
     */
    @Override
    public String getQueryWithPrefixes() {
        return addPrefixes() + this.getQuery();
    }

    /**
     * Metodo getter della query con parametri e l'aggiunta dei prefissi.
     *
     * @return la query anteceduta dai prefissi e formattata in relazione ai parametri.
     */
    @Override
    public String getQueryWithPrefixes(Object ... args) {
        return addPrefixes() + this.getQuery(args);
    }

    /**
     * Restituzione di una stringa contenente i prefissi.
     *
     * @return prefissi relativi all'ontologia in questione.
     */
    public String addPrefixes() {
        return
        """
            PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
            PREFIX owl: <http://www.w3.org/2002/07/owl#>
            PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX kbb: <https://www.unicam.it/giorgiodellaroscia/KebabConfigurator#>
            PREFIX dbo: <http://dbpedia.org/ontology/>
        """;
    }
}