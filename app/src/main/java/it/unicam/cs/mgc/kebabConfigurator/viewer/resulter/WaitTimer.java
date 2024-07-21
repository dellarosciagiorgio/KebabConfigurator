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

package it.unicam.cs.mgc.kebabConfigurator.viewer.resulter;

import java.util.concurrent.TimeUnit;

/**
 * Stampa un timer per mostrare l'attesa dovuta alla preparazione del kebab.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class WaitTimer {
    /**
     * Richiama un timer di 5 secondi.
     *
     * @throws RuntimeException
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html">RuntimeException</a>
     */
    public void showWait() {
        try {
            waitFiveSeconds();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stampa un timer di 5 secondi
     *
     * @throws InterruptedException
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/InterruptedException.html">InterruptedException</a>
     */
    public void waitFiveSeconds() throws InterruptedException {
        for (int i = 5; i > 0; --i) {
            System.out.println(i + " seconds remaining...");
            for (int j = 0; j < 10; ++j)
                TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}