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

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Rappresentazione dei dati parsati in formato accessibile.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class JSONData implements ParsedData {
    Map<String, String> data;

    /**
     * Costruttore che inizializza i dati.
     *
     * @param data dati.
     */
    public JSONData(Map<String, String> data) {
        this.data = data;
    }

    /**
     * Restituisce il valore della proprietà specificata.
     *
     * @param property la proprietà da cercare.
     * @return il valore della proprietà, se presente.
     */
    @Override
    public String getProperty(String property) {
        return this.data.get(property);
    }

    /**
     * Restituisce una collezione di tutti i valori presenti nei dati.
     *
     * @return collezione di stringhe contenente valori.
     */
    @Override
    public Collection<String> getAllValues() {
        return this.data.values();
    }

    /**
     * Restituisce un iteratore sui dati.
     *
     * @return iteratore sui dati.
     */
    public Iterator<Map.Entry<String,String>> getIterator() {
        return this.data.entrySet().iterator();
    }
}