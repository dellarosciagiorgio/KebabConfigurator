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

/**
 * Associa al codice del panino un'etichetta.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class ResultKebabConstructor {
    /**
     * Concatena tre chiamata, che restituisco stringhe relative alla selezione delle restrizioni, per formare l'etichetta del panino.
     *
     * @param kebabCode codice del panino.
     * @return etichetta del panino.
     */
    public String kebabCodeToIndivualName(int[] kebabCode) {
        return kebabIntoleranceCodeToWord(kebabCode) + kebabDietCodeToWord(kebabCode) + kebabReligionCodeToWord(kebabCode);
    }

    /**
     * Associa la cifra del codice del panino relativa alla scelta delle intolleranze ad un'etichetta apposita.
     *
     * @param kebabCode codice del panino.
     * @return stringa relativa alla scelta effettuata sulla restrizione delle intolleranze.
     */
    public String kebabIntoleranceCodeToWord(int[] kebabCode) {
        switch (kebabCode[1]) {
            case 2: return "Lactose";
            case 3: return "Celiac";
            case 4: return "LactoseCeliac";
        }
        return "";
    }

    /**
     * Associa la cifra del codice del panino relativa alla scelta della dieta ad un'etichetta apposita.
     *
     * @param kebabCode codice del panino.
     * @return stringa relativa alla scelta effettuata sulla restrizione della dieta.
     */
    public String kebabDietCodeToWord(int[] kebabCode) {
        switch (kebabCode[0]) {
            case 1: return "Omnivorous";
            case 2: return "Vegetarian";
            case 3: return "Vegan";
        }
        return "";
    }

    /**
     * Associa la cifra del codice del panino relativa alla scelta della religione ad un'etichetta apposita.
     *
     * @param kebabCode codice del panino.
     * @return stringa relativa alla scelta effettuata sulla restrizione della religione.
     */
    public String kebabReligionCodeToWord(int[] kebabCode) {
        switch (kebabCode[2]) {
            case 2: return "Hinduism";
            case 3: return "Islam";
            case 4: return "Judaism";
        }
        return "";
    }
}