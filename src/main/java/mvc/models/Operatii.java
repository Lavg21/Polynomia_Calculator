package mvc.models;

import java.util.*;

public class Operatii {

    // Metode pentru operatiile corespunzatoare butoanelor
    public static Polinom adunarePolinoame(Polinom polinom1, Polinom polinom2) {

        // Declaram 2 liste de monoame, una corespunzatoare polinomului introdus, iar cealalta polinomului rezultat
        List<Monom> monoame = new ArrayList<>();
        List<Monom> rezultat = new ArrayList<>();

        // Declaram 2 HaspMap-uri pentru cele doua polinoame introduse
        Map<Integer, Double> map1 = new HashMap<>();
        Map<Integer, Double> map2 = new HashMap<>();

        // Parcurgem lista de monoame a primului polinom (for each)
        for (Monom m : polinom1.getMonoame())
            map1.put(m.getExponent(), m.getCoeficient()); // punem in cheie - exponentul, iar in valoare - coeficientul

        // Procedam la fel si pentru polinomul al doilea
        for (Monom m : polinom2.getMonoame())
            map2.put(m.getExponent(), m.getCoeficient());

        // In HashMapu-ul corespunzator rezultatului, punem HashMap-ul corespunzator primului polinom
        Map<Integer, Double> mapRezultat = new HashMap<>(map1);

        // Parcurgem cheile (adica exponentii)
        for (Integer key : map2.keySet()) {

            // Daca map-ul rezultat (adica implicit map1) contine cheia din map2
            if (mapRezultat.containsKey(key)) {

                // In map-ul rezultat, punem peste valoare, adunarea cu valoarea map-ului 2
                mapRezultat.put(key, mapRezultat.get(key) + map2.get(key));

                // Daca o valoare este 0
                if (mapRezultat.get(key) == 0)
                    mapRezultat.remove(key); // o eliminam
            } else
                // Altfel, daca nu contine cheia, valoarea respectiva din map-ul rezultat
                // primeste valoarea corespunzatoare din map2
                mapRezultat.put(key, map2.get(key));

        }

        // Parcurgem cheile din map-ul rezultat
        for (Integer key : mapRezultat.keySet()) {
            double value = mapRezultat.get(key); // retinem valoarea

            monoame.add(new Monom(value, key)); // adugam in lista de monoame cheile si valorile,
            // adica coeficientii si exponentii


        }

        // Daca nu avem niciun monom ramas la final, inseamna ca rezultatul este 0,
        // deci returnam un polinom nou cu expresia "0".
        if (monoame.size() == 0)
            return new Polinom("0");

        // returnam polinomul creat din lista de monoame obtinuta mai sus
        Polinom rez = new Polinom(monoame);
        rez.sortareDupaExponent();
        return rez;
    }

    public static Polinom scaderePolinoame(Polinom polinom1, Polinom polinom2) {

        // Declaram 2 liste de monoame, una corespunzatoare polinomului introdus, iar cealalta polinomului rezultat
        List<Monom> monoame = new ArrayList<>();
        List<Monom> rezultat = new ArrayList<>();

        // Declaram 2 HaspMap-uri pentru cele doua polinoame introduse
        Map<Integer, Double> map1 = new HashMap<>();
        Map<Integer, Double> map2 = new HashMap<>();

        // Parcurgem lista de monoame a primului polinom (for each)
        for (Monom m : polinom1.getMonoame())
            map1.put(m.getExponent(), m.getCoeficient()); // punem in cheie - exponentul, iar in valoare - coeficientul

        // Procedam la fel si pentru polinomul al doilea
        for (Monom m : polinom2.getMonoame())
            map2.put(m.getExponent(), m.getCoeficient());

        // In HashMapu-ul corespunzator rezultatului, punem HashMap-ul corespunzator primului polinom
        Map<Integer, Double> mapRezultat = new HashMap<>(map1);

        // Parcurgem cheile (adica exponentii)
        for (Integer key : map2.keySet()) {

            // Daca map-ul rezultat (adica implicit map1) contine cheia din map2
            if (mapRezultat.containsKey(key)) {

                // In map-ul rezultat, punem peste valoare, scaderea cu valoarea map-ului 2
                mapRezultat.put(key, mapRezultat.get(key) - map2.get(key));

                // Daca o valoare este 0
                if (mapRezultat.get(key) == 0)
                    mapRezultat.remove(key); // o eliminam
            } else
                // Altfel, daca nu contine cheia, valoarea respectiva din map-ul rezultat
                // primeste valoarea corespunzatoare din map2
                mapRezultat.put(key, map2.get(key));

        }

        // Parcurgem cheile din map-ul rezultat
        for (Integer key : mapRezultat.keySet()) {

            double value = mapRezultat.get(key); // retinem valoarea

            monoame.add(new Monom(value, key)); // adugam in lista de monoame cheile si valorile,
            // adica coeficientii si exponentii
        }

        // Daca nu avem niciun monom ramas la final, inseamna ca rezultatul este 0,
        // deci returnam un polinom nou cu expresia "0".
        if (monoame.size() == 0)
            return new Polinom("0");

        // returnam polinomul creat din lista de monoame obtinuta mai sus
        Polinom rez = new Polinom(monoame);
        rez.sortareDupaExponent();
        return rez;

    }

    public static Polinom inmultirePolinoame(Polinom polinom1, Polinom polinom2) {

        if ((polinom1.getMonoame().size() == 1 && polinom1.getMonoame().get(0).getCoeficient() == 0) ||
                polinom2.getMonoame().size() == 1 && polinom2.getMonoame().get(0).getCoeficient() == 0)
            return new Polinom("0");

        // Declaram o lista de monoame
        List<Monom> monoame = new ArrayList<>();

        // Declaram 3 HaspMap-uri pentru cele doua polinoame introduse si una pentru rezultat
        Map<Integer, Double> map1 = new HashMap<>();
        Map<Integer, Double> map2 = new HashMap<>();
        Map<Integer, Double> mapRezultat = new HashMap<>();

        // Parcurgem lista de monoame a primului polinom (for each)
        for (Monom m : polinom1.getMonoame())
            map1.put(m.getExponent(), m.getCoeficient()); // punem in cheie - exponentul, iar in valoare - coeficientul

        // Procedam la fel si pentru polinomul al doilea
        for (Monom m : polinom2.getMonoame())
            map2.put(m.getExponent(), m.getCoeficient());

        // Parcurgem cheile (adica exponentii)
        for (Integer key1 : map1.keySet()) {
            for (Integer key2 : map2.keySet()) {
                int exp = key1 + key2;
                double coef = map1.get(key1) * map2.get(key2);

                if (!mapRezultat.containsKey(exp))
                    mapRezultat.put(exp, coef);

                else
                    mapRezultat.put(exp, coef + mapRezultat.get(exp));
            }
        }

        // Parcurgem cheile din map-ul rezultat
        for (Integer key : mapRezultat.keySet()) {

            double value = mapRezultat.get(key); // retinem valoarea

            monoame.add(new Monom(value, key)); // adugam in lista de monoame cheile si valorile,
            // adica coeficientii si exponentii
        }

        // returnam polinomul creat din lista de monoame obtinuta mai sus
        Polinom rez = new Polinom(monoame);
        rez.sortareDupaExponent();
        return rez;
    }

    public static Monom impartireMonoame(Monom monom1, Monom monom2) {

        // Declaram și intializam atributele polinomului rezultat dupa impartirea a doua monoame
        double coeficient = monom1.getCoeficient() / monom2.getCoeficient();
        int exponent = monom1.getExponent() - monom2.getExponent();

        // returnam monomul rezultat
        return new Monom(coeficient, exponent);
    }

    public static List<Polinom> impartirePolinoame(Polinom deimpartit, Polinom impartitor) {

        // Declararea a doua liste, una a monoamelor polinoameor primite si una pentru polinomul rezultat dupa impartire
        List<Polinom> result = new ArrayList<>();
        List<Monom> monoame = new ArrayList<>();

        // Daca exponentul monomului maxim al deimpartitului este mai mare
        // decat cel al impartitorui, operatia se poate realiza
        while (deimpartit.getMonomMaxim().getExponent() >= impartitor.getMonomMaxim().getExponent()) {

            // Stocam monoamele maxime, dupa care efectuam operatia de impartire a acestora
            Monom md = deimpartit.getMonomMaxim();
            Monom mi = impartitor.getMonomMaxim();
            Monom mc = Operatii.impartireMonoame(md, mi);

            // Adaugam monomul rezultat la lista de monoame
            monoame.add(mc);

            // Continuam sa efectuam operatia conform schemei lui Horner, actualizand variabilele conform acesteia
            Polinom aux = Operatii.inmultirePolinoame(impartitor, new Polinom(List.of(mc)));
            deimpartit = Operatii.scaderePolinoame(deimpartit, aux);
        }

        // Catul primeste valoarea listei de monoame transformata în polinom
        Polinom cat = new Polinom(monoame);

        // Sortam descrescator catul si restul(stocat in variabila deimpartit) dupa exponent
        cat.sortareDupaExponent();
        deimpartit.sortareDupaExponent();

        // Adaugam catul si restul in lista de polinoame, dupa care returnam rezultatul
        result.add(cat);
        result.add(deimpartit);

        return result;
    }

    public static Polinom derivarePolinoame(Polinom polinom) {

        // Declaram o lista de monoame
        List<Monom> monoame = new ArrayList<>();

        // Declaram un HaspMap pentru polinomul introdus
        Map<Integer, Double> map = new HashMap<>();

        // Parcurgem lista de monoame a polinomului (for each)
        for (Monom m : polinom.getMonoame())
            if (m.getExponent() != 0)
                map.put(m.getExponent(), m.getCoeficient()); // punem in cheie - exponentul, iar in valoare - coeficientul

        // Declaram HashMap-ul corespunzator rezultatului
        Map<Integer, Double> mapRezultat = new HashMap<>();

        // Parcurgem cheile (adica exponentii)
        for (Integer key : map.keySet()) {
            mapRezultat.put(key - 1, key * map.get(key));
        }

        // Parcurgem cheile din map-ul rezultat
        for (Integer key : mapRezultat.keySet()) {

            double value = mapRezultat.get(key); // retinem valoarea

            monoame.add(new Monom(value, key)); // adugam in lista de monoame cheile si valorile,
            // adica coeficientii si exponentii
        }

        // Daca nu avem niciun monom ramas la final, inseamna ca rezultatul este 0,
        // deci returnam un polinom nou cu expresia "0".
        if (monoame.size() == 0)
            return new Polinom("0");

        // returnam polinomul creat din lista de monoame obtinuta mai sus
        Polinom rez = new Polinom(monoame);
        rez.sortareDupaExponent();
        return rez;

    }

    public static Polinom integrarePolinoame(Polinom polinom) {

        // Declaram o lista de monoame
        List<Monom> monoame = new ArrayList<>();

        // Declaram un HashMap corespunzator polinomului rezultat
        Map<Integer, Double> mapRezultat = new HashMap<>();

        // Declaram 2 HaspMap-uri pentru cele doua polinoame introduse
        Map<Integer, Double> map = new HashMap<>();

        // Parcurgem lista de monoame a polinomului (for each)
        for (Monom m : polinom.getMonoame())
            map.put(m.getExponent(), m.getCoeficient()); // punem in cheie - exponentul, iar in valoare - coeficientul

        // Parcurgem cheile (adica exponentii)
        for (Integer key : map.keySet()) {
            mapRezultat.put(key + 1, map.get(key) / (key + 1));
        }

        // Parcurgem cheile din map-ul rezultat
        for (Integer key : mapRezultat.keySet()) {

            double value = mapRezultat.get(key); // retinem valoarea

            monoame.add(new Monom(value, key)); // adugam in lista de monoame cheile si valorile,
            // adica coeficientii si exponentii
        }

        // returnam polinomul creat din lista de monoame obtinuta mai sus
        Polinom rez = new Polinom(monoame);
        rez.sortareDupaExponent();
        return rez;

    }

}
