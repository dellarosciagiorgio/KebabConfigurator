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

package it.unicam.cs.mgc.kebabConfigurator.model.parser;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;
import java.util.HashMap;
import java.util.Map;

/**
 * Traduzione dei dati ottenuti dalle query in formato accessibile.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class JSONParser implements DataParser {
    private final Map<String, String> data = new HashMap<>();

    /**
     * Metodo che esegue la traduzione dei dati provenienti dalla query SPARQL.
     *
     * @param queryExecution l'oggetto di esecuzione della query.
     * @return un oggetto contenente i dati tradotti.
     */
    @Override
    public ParsedData parse(QueryExecution queryExecution) {
        ResultSet resultSet = queryExecution.execSelect();
        while(resultSet.hasNext()) {
            QuerySolution resultNode = resultSet.nextSolution();
            String label = this.parseNodeToString(resultNode.get("label"));
            String value = this.parseNodeToString(resultNode.get("value"));
            if (data.containsKey(label))
                data.put(label, data.get(label) + ", " + value);
            else data.put(label, value);
        }
        return new JSONData(data);
    }

    /**
     * Convertitore di un nodo RDF in una stringa.
     *
     * @param node il nodo RDF da convertire.
     * @return la stringa rappresentante il nodo RDF.
     */
    private String parseNodeToString(RDFNode node) {
        if (node == null)
            return "";
        if (node.isResource())
            return this.getNodeLabel(node.asResource());
        return node.asLiteral().getString();
    }

    /**
     * Getter dell'etichetta di una risorsa RDF.
     *
     * @param resource la risorsa RDF da cui recuperare l'etichetta.
     * @return l'etichetta della risorsa RDF.
     */
    private String getNodeLabel(Resource resource) {
        if (resource.getProperty(RDFS.label) == null)
            return removeUriPrefix(resource.getURI());
        return resource.getProperty(RDFS.label).getString();
    }

    /**
     * Rimuove il prefisso URI da una stringa.
     *
     * @param uri la stringa URI da cui rimuovere il prefisso.
     * @return la stringa senza prefisso URI.
     */
    public static String removeUriPrefix(String uri) {
        if (uri != null) {
            int index = uri.indexOf('#');
            if (index != -1)
                return uri.substring(index + 1);
            return uri;
        }
        return null;
    }
}