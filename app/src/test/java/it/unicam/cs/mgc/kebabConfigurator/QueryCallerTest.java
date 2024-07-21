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

package it.unicam.cs.mgc.kebabConfigurator;

import it.unicam.cs.mgc.kebabConfigurator.model.controller.Controller;
import it.unicam.cs.mgc.kebabConfigurator.model.sparql.QueryCaller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe di test che fa riferimento a {@link QueryCaller}.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class QueryCallerTest {
    private QueryCaller queryCaller = new QueryCaller();
    private final String kebabLabel = "LactoseVeganJudaism";

    /**
     * Verifica della produzione di output dalla chiamata della query per ottenere tutti i kebab.
     */
    @Test
    void testGetAllKebabs() {
        assertNotNull(queryCaller.getAllKebabs());
    }

    /**
     * Verifica della produzione di output dalla chiamata della query per ottenere la label di un kebab.
     */
    @Test
    void testGetKebabLabel() {
        assertNotNull(queryCaller.getKebabLabel(kebabLabel));
    }

    /**
     * Verifica della produzione di output dalla chiamata della query per ottenere il costo di un kebab.
     */
    @Test
    void testGetKebabPrice() {
        assertNotNull(queryCaller.getKebabPrice(kebabLabel));
    }

    /**
     * Verifica della produzione di output dalla chiamata della query per ottenere le kilocalorie di un kebab.
     */
    @Test
    void testGetKebabKcal() {
        assertNotNull(queryCaller.getKebabKcal(kebabLabel));
    }
}