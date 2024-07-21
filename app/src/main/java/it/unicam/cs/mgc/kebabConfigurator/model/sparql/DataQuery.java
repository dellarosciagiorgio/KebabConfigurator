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
 * Metodi getters relativi a query.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public interface DataQuery {
    /**
     * Ottiene la query.
     *
     * @return query come stringa.
     */
    String getQuery();

    /**
     * Ottiene la query.
     *
     * @param args parametri aggiuntivi di specifica.
     * @return query come stringa.
     */
    String getQuery(Object ... args);

    /**
     * Ottiene la query completa di prefissi.
     *
     * @return query completa di prefissi come stringa.
     */
    String getQueryWithPrefixes();

    /**
     * Ottiene la query completa di prefissi.
     *
     * @param args parametri aggiuntivi di specifica.
     * @return query completa di prefissi come stringa.
     */
    String getQueryWithPrefixes(Object ... args);
}