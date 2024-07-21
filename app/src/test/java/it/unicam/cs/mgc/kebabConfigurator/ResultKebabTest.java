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
import it.unicam.cs.mgc.kebabConfigurator.viewer.resulter.ResultKebab;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe di test che fa riferimento a {@link ResultKebab}.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class ResultKebabTest {
    private ResultKebab resultKebab = new ResultKebab();
    private QueryCaller queryCaller = new QueryCaller();
    private final String kebabLabel = "LactoseVeganJudaism";
    private final double kebabPrice = 3.4;
    private final int kebabKcal = 500;

    /**
     * Verifica della consistenza dei dati impostati e quelli presenti nell'ontologia.
     */
    @Test
    void testShowResultKebabInfo() {
        int[] kebabCode = {1, 2, 3};
        assertEquals(kebabLabel, queryCaller.getKebabLabel(kebabLabel).getAllValues().stream().findFirst().get());
        assertEquals(kebabPrice, Double.parseDouble(queryCaller.getKebabPrice(kebabLabel).getAllValues().stream().findFirst().get()));
        assertEquals(kebabKcal, Integer.parseInt(queryCaller.getKebabKcal(kebabLabel).getAllValues().stream().findFirst().get()));
        resultKebab.showResultKebabInfo(kebabCode);
    }

    /**
     * Verifica consistenza delle etichette fra i dati impostati e quella presente nell'ontologia.
     */
    @Test
    void testGetKebabLabelResult() {
        assertEquals(kebabLabel, resultKebab.getKebabLabelResult(kebabLabel));
    }

    /**
     * Verifica consistenza dei costi fra i dati impostati e quelli presenti nell'ontologia.
     */
    @Test
    void testGetKebabPriceResult() {
        assertEquals(kebabPrice, Double.parseDouble(resultKebab.getKebabPriceResult(kebabLabel)));
    }

    /**
     * Verifica consistenza delle kilocalorie fra i dati impostati e quelle presenti nell'ontologia.
     */
    @Test
    void testGetKebabKcalResult() {
        assertEquals(kebabKcal, Integer.parseInt(resultKebab.getKebabKcalResult(kebabLabel)));
    }
}