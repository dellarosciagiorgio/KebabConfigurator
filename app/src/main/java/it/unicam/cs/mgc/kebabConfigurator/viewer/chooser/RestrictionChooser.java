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

package it.unicam.cs.mgc.kebabConfigurator.viewer.chooser;

import it.unicam.cs.mgc.kebabConfigurator.viewer.cleaner.CleanTerminal;
import java.util.Scanner;


/**
 * Scelta delle intolleranze.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class RestrictionChooser implements Chooser {
    /**
     * Riceve l'input da terminale della scelta della restrizione.
     *
     * @param restrictionType tipo di restrizione da scegliere.
     * @param optionsNumber numero di opzioni fra cui scegliere.
     * @return valore della scelta.
     */
    @Override
    public int choose(char restrictionType, int optionsNumber) {
        do {
            switch (restrictionType) {
                case 'D': printDietOptions(); break;
                case 'I': printIntoleranceOptions(); break;
                case 'R': printReligionOptions(); break;
            }
            int choice = new Scanner(System.in).nextInt();
            if (choice < 1 || choice > optionsNumber)
                new CleanTerminal().cleanAndShowErrorMessage();
            else return choice;
        } while(true);
    }

    /**
     * Stampa delle opzioni riguardanti la dieta.
     */
    public void printDietOptions() {
        System.out.println("\nWhich diet do you follow?");
        System.out.println("1. Omnivorous");
        System.out.println("2. Vegetarian");
        System.out.println("3. Vegan");
    }

    /**
     * Stampa delle opzioni riguardanti le intolleranze.
     */
    public void printIntoleranceOptions() {
        System.out.println("\nDo you have any of these intolerances?");
        System.out.println("1. No");
        System.out.println("2. Lactose");
        System.out.println("3. Celiac");
        System.out.println("4. Lactose and celiac");
    }

    /**
     * Stampa delle opzioni riguardanti la religione.
     */
    public void printReligionOptions() {
        System.out.println("\nDo you believe in any of these religion?");
        System.out.println("1. No");
        System.out.println("2. Hinduism");
        System.out.println("3. Islam");
        System.out.println("4. Judaism");
    }
}