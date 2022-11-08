package mvc.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    // Declaram o lista de monoame corespunzatoare unui polinom
    private List<Monom> monoame;

    // Constructor care primeste ca parametru o lista de monoame
    public Polinom(List<Monom> monoame) {

        this.monoame = new ArrayList<>(monoame);
    }

    // Constructor care primeste ca parametru o expresie de tipul "x^2+2*x+1"
    public Polinom(String expresie) {

        // Intializam lista de monoame
        this.monoame = new ArrayList<>();

        //int i = 0;

        // Pentru a desparti expresia polinomului se folosteste regex
        // \\*? = sa contina caracterul * de 0 sau 1 dati
        // x = sa contina caracterul x
        // \\^? = sa contina caracterul ^ de 0 sau 1 dati
        Pattern spl = Pattern.compile("([+-]?[^-+]+)");
        Matcher potrivire = spl.matcher(expresie);

        while (potrivire.find()) {
            //i++;
            Monom monom = new Monom(potrivire.group(1));
            this.monoame.add(monom);
            //System.out.println("Monom " + i + ": " + monom);
        }
    }

    // Getter
    public List<Monom> getMonoame() {

        return this.monoame;
    }

    // Metoda pentru determinarea monomului de grad maxim
    public Monom getMonomMaxim() {

        List<Monom> cpy = new ArrayList<>(this.monoame);

        cpy.sort(Comparator.comparing(Monom::getExponent, Comparator.reverseOrder()));

        return cpy.get(0);
    }

    // Sortare inversă după exponent
    public void sortareDupaExponent() {

        this.monoame.sort(Comparator.comparing(Monom::getExponent, Comparator.reverseOrder()));
    }

    // Afisarea polinomului folosind lista de monoame
    @Override
    public String toString() {

        // Initialiam un String gol
        String str = "";

        // Parcurgem lista de monoame (for each)
        for (Monom m : monoame) {
            if (m.getCoeficient() > 0) // daca coeficientul e pozitiv
                str += "+"; // punem '+'

            str += m; // apoi adaugam monomul
        }

        return str; // afisam String-ul corespunzator monomului
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Polinom))
            return false;

        Polinom ot = (Polinom) other;
        this.sortareDupaExponent();
        ot.sortareDupaExponent();

        if (ot.getMonoame().size() != this.monoame.size())
            return false;

        for (int i = 0; i < ot.getMonoame().size(); i++)
            if (!ot.getMonoame().get(i).equals(this.monoame.get(i)))
                return false;

        return true;
    }

}
