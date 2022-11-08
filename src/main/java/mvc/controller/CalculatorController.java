package mvc.controller;

import mvc.models.Operatii;
import mvc.models.Polinom;
import mvc.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CalculatorController {

    // Declararea campurilor necesare
    private CalculatorView calculatorView;

    // Constructorul care primeste ca parametru un view
    public CalculatorController(CalculatorView calculatorView) {

        this.calculatorView = calculatorView;

        // Punem listeners pe butoane pentru a executa operatia corespunzatoare la apasare
        this.calculatorView.addAdunareListener(new AdunareListener());
        this.calculatorView.addScadereListener(new ScadereListener());
        this.calculatorView.addInmultireListener(new InmultireListener());
        this.calculatorView.addImpartireListener(new ImpartireListener());
        this.calculatorView.addDerivareListener(new DerivareListener());
        this.calculatorView.addIntegrareListener(new IntegrareListener());

    }

    class AdunareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                // Luam valorile din casetele text de pe interfata
                String polString1 = calculatorView.getFirstTextField();
                String polString2 = calculatorView.getSecondTextField();

                if (polString1.equals(""))
                    throw new Exception("Nu s-a introdus nimic in prima caseta!");

                if (polString2.equals(""))
                    throw new Exception("Nu s-a introdus nimic in a doua caseta!");

                // Intializam doua polinoame care primesc datele de pe interfata
                Polinom polinom1 = new Polinom(polString1);
                Polinom polinom2 = new Polinom(polString2);

                // In caseta rezultat, afisam polinomul rezultat
                calculatorView.getRezultatTextField().setText(Operatii.adunarePolinoame(polinom1, polinom2).toString());
                calculatorView.getRestTextField().setText("");

            } catch (NumberFormatException exception) {

                calculatorView.showMessage("Polinom invalid!");
            } catch (Exception exception) {

                // Prindem exceptiile pentru input gresit
                calculatorView.showMessage(exception.getMessage());
                //exception.printStackTrace();
            }
        }
    }

    class ScadereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                // Luam valorile din casetele text de pe interfata
                String polString1 = calculatorView.getFirstTextField();
                String polString2 = calculatorView.getSecondTextField();

                // Intializam doua polinoame care primesc datele de pe interfata
                Polinom polinom1 = new Polinom(polString1);
                Polinom polinom2 = new Polinom(polString2);

                // In caseta rezultat, afisam polinomul rezultat
                calculatorView.getRezultatTextField().setText(Operatii.scaderePolinoame(polinom1, polinom2).toString());

            } catch (Exception exception) {

                // Prindem exceptiile pentru input gresit
                calculatorView.showMessage("Bad Input");
                //exception.printStackTrace();
            }
        }
    }

    class InmultireListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                // Luam valorile din casetele text de pe interfata
                String polString1 = calculatorView.getFirstTextField();
                String polString2 = calculatorView.getSecondTextField();

                // Intializam doua polinoame care primesc datele de pe interfata
                Polinom polinom1 = new Polinom(polString1);
                Polinom polinom2 = new Polinom(polString2);

                // In caseta rezultat, afisam polinomul rezultat
                calculatorView.getRezultatTextField().setText(Operatii.inmultirePolinoame(polinom1, polinom2).toString());

            } catch (Exception exception) {

                // Prindem exceptiile pentru input gresit
                calculatorView.showMessage("Bad Input");
                //exception.printStackTrace();
            }
        }
    }

    class ImpartireListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                // Luam valorile din casetele text de pe interfata
                String polString1 = calculatorView.getFirstTextField();
                String polString2 = calculatorView.getSecondTextField();

                // Intializam doua polinoame care primesc datele de pe interfata
                Polinom polinom1 = new Polinom(polString1);
                Polinom polinom2 = new Polinom(polString2);

                // Stocam rezultatul impartirii(cat si rest) intr-o lista de polinoame
                List<Polinom> list1 = Operatii.impartirePolinoame(polinom1, polinom2);

                // In caseta rezultat, afisam catul impartirii, iar in caseta rest, restul
                calculatorView.getRezultatTextField().setText(list1.get(0).toString());
                calculatorView.getRestTextField().setText(list1.get(1).toString());

            } catch (Exception exception) {

                // Prindem exceptiile pentru input gresit
                calculatorView.showMessage("Bad Input");
                //exception.printStackTrace();
            }

        }
    }

    class DerivareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                // Luam valorile din casetele text de pe interfata
                String polString1 = calculatorView.getFirstTextField();
                String polString2 = calculatorView.getSecondTextField();

                if (polString1.equals("")) {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom2 = new Polinom(polString2);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.derivarePolinoame(polinom2).toString());
                } else {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom1 = new Polinom(polString1);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.derivarePolinoame(polinom1).toString());
                }

                if (polString2.equals("")) {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom1 = new Polinom(polString1);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.derivarePolinoame(polinom1).toString());
                } else {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom2 = new Polinom(polString2);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.derivarePolinoame(polinom2).toString());
                }

            } catch (Exception exception) {

                // Prindem exceptiile pentru input gresit
                calculatorView.showMessage("Bad Input");
                //exception.printStackTrace();
            }
        }
    }

    class IntegrareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                // Luam valorile din casetele text de pe interfata
                String polString1 = calculatorView.getFirstTextField();
                String polString2 = calculatorView.getSecondTextField();

                if (polString1.equals("")) {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom2 = new Polinom(polString2);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.integrarePolinoame(polinom2).toString());
                } else {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom1 = new Polinom(polString1);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText((polinom1).toString());
                }

                if (polString2.equals("")) {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom1 = new Polinom(polString1);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.integrarePolinoame(polinom1).toString());
                } else {
                    // Intializam polinomul care primeste datele de pe interfata
                    Polinom polinom2 = new Polinom(polString2);

                    // In caseta rezultat, afisam polinomul rezultat
                    calculatorView.getRezultatTextField().setText(Operatii.integrarePolinoame(polinom2).toString());
                }

            } catch (Exception exception) {

                // Prindem exceptiile pentru input gresit
                calculatorView.showMessage("Bad Input");
                //exception.printStackTrace();
            }
        }
    }
}
