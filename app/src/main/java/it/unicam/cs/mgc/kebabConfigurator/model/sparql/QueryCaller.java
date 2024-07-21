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

import it.unicam.cs.mgc.kebabConfigurator.model.controller.Controller;
import it.unicam.cs.mgc.kebabConfigurator.model.parser.ParsedData;

/**
 * Restituisce i dati ottenuti dall'esecuzione di query sull'ontologia.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class QueryCaller {
    private final Controller controller = new Controller();

    /**
     * Richiamo alla query per ottenere la lista di tutti kebab presenti.
     *
     * @return dati da parsare delle labels di tutti i kebab.
     */
    public ParsedData getAllKebabs() {
        return controller.get(QueryContainer.ALL_KEBABS);
    }

    /**
     * Richiamo alla query per ottenere la lista di tutti kebab presenti.
     *
     * @param kebabLabel etichetta del kebab.
     * @return dati da parsare delle labels di tutti i kebab.
     */
    public ParsedData getKebabLabel(String kebabLabel) {
        return controller.get(QueryContainer.KEBAB_LABEL, kebabLabel);
    }

    /**
     * Richiamo alla query per ottenere il valore del costo del kebab richiesto.
     *
     * @param kebabLabel etichetta del kebab.
     * @return dato da parsare del costo del kebab.
     */
    public ParsedData getKebabPrice(String kebabLabel) {
        return controller.get(QueryContainer.KEBAB_PRICE, kebabLabel);
    }

    /**
     * Richiamo alla query per ottenere il valore in kilocalorie del kebab richiesto.
     *
     * @param kebabLabel etichetta del kebab.
     * @return dato da parsare delle kilocalorie del kebab.
     */
    public ParsedData getKebabKcal(String kebabLabel) {
        return controller.get(QueryContainer.KEBAB_KCAL, kebabLabel);
    }
}