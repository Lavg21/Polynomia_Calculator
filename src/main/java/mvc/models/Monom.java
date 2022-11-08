package mvc.models;

import java.util.List;

public class Monom {

    // Declrarea campurilor din clasa Monom
    private double coeficient;
    private int exponent;

    // Constructorul clasei Monom cu parametrii corespunzatori
    public Monom(double coeficient, int exponent) {

        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    public Monom(String expresie) {

        //System.out.println(expresie);

        // Daca expresia monomului dat nu contine caracterele ^ si x, inseamna ca exponentul lui x este 0.
        if (!expresie.contains("^") && !expresie.contains("x")) {

            this.coeficient = Integer.parseInt(expresie); // covertim valoarea de tipul String a coeficientului in int
            this.exponent = 0;
        }

        // Altfel, exponentul este mai mare sau egal cu 1.
        else {

            // \\*? = sa contina caracterul * de 0 sau 1 dati
            // x = sa contina caracterul x
            // \\^? = sa contina caracterul ^ de 0 sau 1 dati

            // O lista in care retinem pattern-ul pentru despartire
            List<String> list = List.of(expresie.split("\\*?x\\^?"));

            String coeficientString = list.get(0); // retinem coeficientul de tipul String

            // Daca coeficientul de tipul String are semnul -
            if (coeficientString.equals("-"))
                this.coeficient = -1; // punem valoarea -1 in coeficientul de tip int

                // Daca coeficientul de tip String are semnul + sau este gol (nu are coeficient)
            else if (coeficientString.equals("+") || coeficientString.isEmpty())
                this.coeficient = 1; // punem valoarea -1 in coeficientul de tip int

                // Altfel, convertim valoarea coeficientul de tip String la tipul int
            else
                this.coeficient = Integer.parseInt(coeficientString);

            // Daca lista obtinuta in urma split-ului are mai mult de un element, inseamna ca exponentul este mai mare
            // decat 1.
            if (list.size() != 1) {

                String exponentString = list.get(1); // retinem valoarea de tipul String a exponentului
                this.exponent = Integer.parseInt(exponentString); // apoi o convertim la tipul int
            }

            // Altfel, inseamna ca exponentul este 1.
            else
                this.exponent = 1;
        }
    }

    // Getters and setters
    public double getCoeficient() {
        return coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    // Metoda pentru afisare monoamelor unui polinom
    @Override
    public String toString() {

        // Daca coeficientul este 1
        if (this.coeficient == 1) {
            // Daca exponentul este 1 (x^1 = x)
            if (this.exponent == 1)
                return "x"; // afisam doar 'x'

            // Daca exponentul este 0
            if (this.exponent == 0)
                return String.valueOf(this.coeficient); // afisam doar valoarea coeficientului (x^0 = 1)

                // Altfel, se afiseaza "x^"
            else
                return "x^" + this.exponent;
        }

        // Altfel, daca coeficientul este -1
        else if (this.coeficient == -1) {

            // Daca exponentul este 1 (x^1 = x)
            if (this.exponent == 1)
                return "-x";

            // Daca exponentul este 0
            if (this.exponent == 0)
                return String.valueOf(this.coeficient); // afisam valoarea coeficentului (x^0 = 1)

                // Altfel afisam "-x^"
            else
                return "-x^" + this.exponent;
        } else if (this.coeficient == 0) {

            // Daca exponentul este 1 (x^1 = x)
            if (this.exponent >= 1)
                return "";

                // Daca exponentul este 0
            else
                return String.valueOf(this.coeficient); // afisam valoarea coeficentului (x^0 = 1)
        }

        // Altfel, daca coeficientul nu e 1 sau -1
        else {

            // Daca exponentul este 1 (x^1 = x)
            if (this.exponent == 1)
                return this.coeficient + "*x"; // afisam "coefiecient*x"

            // Daca exponenetul este 0 (x^0 = 1)
            if (this.exponent == 0)
                return String.valueOf(this.coeficient); // aifsam doar coeficientul

                // Altfel, daca coeficeintul nu e 1 sau -1
            else
                return this.coeficient + "*x^" + this.exponent; // afisam "coeficient*x^exponent"
        }
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Monom))
            return false;

        Monom ot = (Monom) other;

        return this.exponent == ot.getExponent() && this.coeficient == ot.getCoeficient();
    }

}
