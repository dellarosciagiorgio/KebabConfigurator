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

import it.unicam.cs.mgc.kebabConfigurator.viewer.ConsistencyChecker;
import it.unicam.cs.mgc.kebabConfigurator.viewer.chooser.ChoicesLauncher;
import it.unicam.cs.mgc.kebabConfigurator.viewer.resulter.ResultKebab;

/**
 * Classe che lancia l'applicazione.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class App {
    /**
     * Metodo principale dell'applicazione. Al suo interno ci sono due rimandi per:
     * <ol>
     *     <li>verificare la consistenza dell'ontologia;</li>
     *     <li>avviare il processo di configurazione del kebab.</li>
     * </ol>
     *
     * @param args eventuali parametri aggiunti all'avvio da terminale.
     */
    public static void main(String[] args) {
        new ConsistencyChecker().getConsistency();
        new ResultKebab().kebabComposing(new ChoicesLauncher().kebabCodeGeneration());
    }
}