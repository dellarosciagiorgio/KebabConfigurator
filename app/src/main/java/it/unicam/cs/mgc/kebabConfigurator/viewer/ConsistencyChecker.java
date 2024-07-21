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

package it.unicam.cs.mgc.kebabConfigurator.viewer;

import it.unicam.cs.mgc.kebabConfigurator.model.controller.Controller;
import it.unicam.cs.mgc.kebabConfigurator.viewer.cleaner.CleanTerminal;

/**
 * Per stampare la consistenza dell'ontologia.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class ConsistencyChecker {
    /**
     * Richiede la verifica di consistenza dell'ontologia e ne stampa il risultato.
     *
     * @return flag booleano che indica la consistenza, o inconsistenza, dell'ontologia.
     */
    public boolean getConsistency() {
        boolean consistent = new Controller().isConsistent();
        new CleanTerminal().clean();
        System.out.println("KEBAB CONFIGURATOR");
        if (consistent) {
            System.out.println("Consistent ontology");
            return true;
        }
        System.out.println("Inconsistent ontology");
        return false;
    }
}