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

import it.unicam.cs.mgc.kebabConfigurator.viewer.cleaner.CleanTerminal;
import it.unicam.cs.mgc.kebabConfigurator.model.sparql.QueryCaller;

/**
 * Stampa del risultato ottenuto dalla configurazione effettuata.
 *
 * @author Giorgio Della Roscia giorgio.dellaroscia@studenti.unicam.it
 */
public class ResultKebab {
    /**
     * Stampa del codice e rimando al risultato finale.
     *
     * @param kebabCode codice del panino.
     */
    public void kebabComposing(int[] kebabCode) {
        new CleanTerminal().clean();
        System.out.print("\nOk, your kebab with code \'");
        for (int i = 0; i < 3; ++i)
            System.out.print(kebabCode[i]);
        System.out.print("\' will be ready soon!\n");
        new WaitTimer().showWait();
        showResultKebabInfo(kebabCode);
    }

    /**
     * Stampa del panino selezionato coi relativi dati annessi.
     *
     * @param kebabCode codice del panino.
     */
    public void showResultKebabInfo(int[] kebabCode) {
        String kebabLabel = new ResultKebabConstructor().kebabCodeToIndivualName(kebabCode),
        kbbLabel = getKebabLabelResult(kebabLabel),
        kbbPrice = getKebabPriceResult(kebabLabel),
        kbbKcal = getKebabKcalResult(kebabLabel);
        new CleanTerminal().clean();
        System.out.println("YOUR KEBAB IS READY!");
        System.out.print("label: " + kbbLabel + ", price: " + kbbPrice + "€, " + kbbKcal + " kcal");
    }

    /**
     * Richiamo alla query per verificare l'esistenza dell'etichetta nell'ontologia.
     *
     * @param kebabLabel etichetta del panino.
     * @return etichetta del panino.
     */
    public String getKebabLabelResult(String kebabLabel) {
        return new QueryCaller().getKebabLabel(kebabLabel).getAllValues().stream().findFirst().get();
    }

    /**
     * Richiamo alla query per l'ottenimento del prezzo del panino.
     *
     * @param kebabLabel etichetta del panino.
     * @return costo relativo al panino selezionato.
     */
    public String getKebabPriceResult(String kebabLabel) {
        return new QueryCaller().getKebabPrice(kebabLabel).getAllValues().stream().findFirst().get();
    }

    /**
     * Richiamo alla query per l'ottenimento delle kcal del panino.
     *
     * @param kebabLabel etichetta del panino.
     * @return kilocalorie relative al panino selezionato.
     */
    public String getKebabKcalResult(String kebabLabel) {
        return new QueryCaller().getKebabKcal(kebabLabel).getAllValues().stream().findFirst().get();
    }
}