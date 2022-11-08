import mvc.models.Operatii;
import mvc.models.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    public void testAdaugare() {

        Polinom polinom1 = new Polinom("5*x^2");
        Polinom polinom2 = new Polinom("6*x^2+5");
        Polinom polinom3 = new Polinom("2*x^4+x^3+3*x^2");
        Polinom polinom4 = new Polinom("5*x^3+2*x");
        Polinom polinom5 = new Polinom("x^6+2*x");
        Polinom polinom6 = new Polinom("-x^6+4*x^3");
        Polinom polinom7 = new Polinom("x^5");
        Polinom polinom8 = new Polinom("-x^5");
        Polinom polinom9 = new Polinom("4*x^3-2*x");
        Polinom polinom10 = new Polinom("-2*x^3");

        Polinom rezultat1 = new Polinom("11*x^2+5");
        Polinom rezultat2 = new Polinom("2*x^4+6*x^3+3*x^2+2*x");
        Polinom rezultat3 = new Polinom("4*x^3+2*x");
        Polinom rezultat4 = new Polinom("0");
        Polinom rezultat5 = new Polinom("2*x^3-2*x");
        Polinom rezultat6 = new Polinom("-x^6+9*x^3+2*x");
        Polinom rezultat7 = new Polinom("x^5+5*x^2");
        Polinom rezultat8 = new Polinom("9*x^3");
        Polinom rezultat9 = new Polinom("x^6-2*x^3+2*x");
        Polinom rezultat10 = new Polinom("-x^5+5*x^2");

        assertEquals(rezultat1, Operatii.adunarePolinoame(polinom1, polinom2));
        assertEquals(rezultat2, Operatii.adunarePolinoame(polinom3, polinom4));
        assertEquals(rezultat3, Operatii.adunarePolinoame(polinom5, polinom6));
        assertEquals(rezultat4, Operatii.adunarePolinoame(polinom7, polinom8));
        assertEquals(rezultat5, Operatii.adunarePolinoame(polinom9, polinom10));
        assertEquals(rezultat6, Operatii.adunarePolinoame(polinom6, polinom4));
        assertEquals(rezultat7, Operatii.adunarePolinoame(polinom7, polinom1));
        assertEquals(rezultat8, Operatii.adunarePolinoame(polinom4, polinom9));
        assertEquals(rezultat9, Operatii.adunarePolinoame(polinom5, polinom10));
        assertEquals(rezultat10, Operatii.adunarePolinoame(polinom1, polinom8));

    }

    @Test
    public void testScadere() {

        Polinom polinom1 = new Polinom("11*x^2+5");
        Polinom polinom2 = new Polinom("6*x^2+5");
        Polinom polinom3 = new Polinom("2*x^4+x^3+3*x^2");
        Polinom polinom4 = new Polinom("5*x^3+2*x");
        Polinom polinom5 = new Polinom("x^6+2*x");
        Polinom polinom6 = new Polinom("-x^6+4*x^3");
        Polinom polinom7 = new Polinom("x^5");
        Polinom polinom8 = new Polinom("-x^5");
        Polinom polinom9 = new Polinom("2*x^3");
        Polinom polinom10 = new Polinom("-2*x^3");

        Polinom rezultat1 = new Polinom("5*x^2");
        Polinom rezultat2 = new Polinom("2*x^4-4*x^3+3*x^2+2*x");
        Polinom rezultat3 = new Polinom("2*x^6+4*x^3+2*x");
        Polinom rezultat4 = new Polinom("2*x^5");
        Polinom rezultat5 = new Polinom("0");
        Polinom rezultat6 = new Polinom("-x^6-x^3+2*x");
        Polinom rezultat7 = new Polinom("x^5+11*x^2+5");
        Polinom rezultat8 = new Polinom("3*x^3+2*x");
        Polinom rezultat9 = new Polinom("x^6-2*x^3+2*x");
        Polinom rezultat10 = new Polinom("-x^5+11*x^2+5");

        assertEquals(rezultat1, Operatii.scaderePolinoame(polinom1, polinom2));
        assertEquals(rezultat2, Operatii.scaderePolinoame(polinom3, polinom4));
        assertEquals(rezultat3, Operatii.scaderePolinoame(polinom5, polinom6));
        assertEquals(rezultat4, Operatii.scaderePolinoame(polinom7, polinom8));
        assertEquals(rezultat5, Operatii.scaderePolinoame(polinom10, polinom10));
        assertEquals(rezultat6, Operatii.scaderePolinoame(polinom6, polinom4));
        assertEquals(rezultat7, Operatii.scaderePolinoame(polinom7, polinom1));
        assertEquals(rezultat8, Operatii.scaderePolinoame(polinom4, polinom9));
        assertEquals(rezultat9, Operatii.scaderePolinoame(polinom5, polinom10));
        assertEquals(rezultat10, Operatii.scaderePolinoame(polinom1, polinom8));

    }

    @Test
    public void testInmultire() {

        Polinom polinom1 = new Polinom("11*x^2+5");
        Polinom polinom2 = new Polinom("6*x^2+5");
        Polinom polinom3 = new Polinom("2*x^4+x^3+3*x^2");
        Polinom polinom4 = new Polinom("5*x^3+2*x");
        Polinom polinom5 = new Polinom("x^6+2*x");
        Polinom polinom6 = new Polinom("-x^6+4*x^3");
        Polinom polinom7 = new Polinom("x^5");
        Polinom polinom8 = new Polinom("-x^5");
        Polinom polinom9 = new Polinom("2*x^3");
        Polinom polinom10 = new Polinom("-2*x^3");

        Polinom rezultat1 = new Polinom("+66*x^4+85*x^2+25");
        Polinom rezultat2 = new Polinom("+10*x^7+5*x^6+19*x^5+2*x^4+6*x^3");
        Polinom rezultat3 = new Polinom("-x^12+4*x^9-2*x^7+8*x^4");
        Polinom rezultat4 = new Polinom("-x^10");
        Polinom rezultat5 = new Polinom("-4*x^6");
        Polinom rezultat6 = new Polinom("-5*x^9-2*x^7+20*x^6+8*x^4");
        Polinom rezultat7 = new Polinom("+11*x^7+5*x^5");
        Polinom rezultat8 = new Polinom("+10*x^6+4*x^4");
        Polinom rezultat9 = new Polinom("-2*x^9-4*x^4");
        Polinom rezultat10 = new Polinom("-11*x^7-5*x^5");

        assertEquals(rezultat1, Operatii.inmultirePolinoame(polinom1, polinom2));
        assertEquals(rezultat2, Operatii.inmultirePolinoame(polinom3, polinom4));
        assertEquals(rezultat3, Operatii.inmultirePolinoame(polinom5, polinom6));
        assertEquals(rezultat4, Operatii.inmultirePolinoame(polinom7, polinom8));
        assertEquals(rezultat5, Operatii.inmultirePolinoame(polinom9, polinom10));
        assertEquals(rezultat6, Operatii.inmultirePolinoame(polinom6, polinom4));
        assertEquals(rezultat7, Operatii.inmultirePolinoame(polinom7, polinom1));
        assertEquals(rezultat8, Operatii.inmultirePolinoame(polinom4, polinom9));
        assertEquals(rezultat9, Operatii.inmultirePolinoame(polinom5, polinom10));
        assertEquals(rezultat10, Operatii.inmultirePolinoame(polinom1, polinom8));

    }

    @Test
    public void testImpartire() {

        Polinom polinom1 = new Polinom("4*x^4+5");
        Polinom polinom2 = new Polinom("2*x^2");
        Polinom polinom3 = new Polinom("2*x^4+x^2+x-3");
        Polinom polinom4 = new Polinom("x^2-4*x");
        Polinom polinom5 = new Polinom("x^3-2*x^2+3*x-1");
        Polinom polinom6 = new Polinom("x^1+2");
        Polinom polinom7 = new Polinom("x^4+4*x^2+3");
        Polinom polinom8 = new Polinom("3*x^4+5*x^3-6*x^2-7*x+2");
        Polinom polinom9 = new Polinom("2*x^4+8");
        Polinom polinom10 = new Polinom("x^2");

        Polinom cat1 = new Polinom("2*x^2");
        Polinom rest1 = new Polinom("5");
        Polinom cat2 = new Polinom("2*x^2-8*x-31");
        Polinom rest2 = new Polinom("-123*x-3");
        Polinom cat3 = new Polinom("x^2-4*x+11");
        Polinom rest3 = new Polinom("-23");
        Polinom cat4 = new Polinom("3");
        Polinom rest4 = new Polinom("5*x^3-18*x^2-7*x-7");
        Polinom cat5 = new Polinom("2*x^2");
        Polinom rest5 = new Polinom("8");

        assertEquals(cat1, Operatii.impartirePolinoame(polinom1, polinom2).get(0));
        assertEquals(rest1, Operatii.impartirePolinoame(polinom1, polinom2).get(1));
        assertEquals(cat2, Operatii.impartirePolinoame(polinom3, polinom4).get(0));
        assertEquals(rest2, Operatii.impartirePolinoame(polinom3, polinom4).get(1));
        assertEquals(cat3, Operatii.impartirePolinoame(polinom5, polinom6).get(0));
        assertEquals(rest3, Operatii.impartirePolinoame(polinom5, polinom6).get(1));
        assertEquals(cat4, Operatii.impartirePolinoame(polinom8, polinom7).get(0));
        assertEquals(rest4, Operatii.impartirePolinoame(polinom8, polinom7).get(1));
        assertEquals(cat5, Operatii.impartirePolinoame(polinom9, polinom10).get(0));
        assertEquals(rest5, Operatii.impartirePolinoame(polinom9, polinom10).get(1));

    }

    @Test
    public void testDerivare() {

        Polinom polinom1 = new Polinom("11*x^2+5");
        Polinom polinom2 = new Polinom("6*x^2+5");
        Polinom polinom3 = new Polinom("2*x^4+x^3+3*x^2");
        Polinom polinom4 = new Polinom("5*x^3+2*x");
        Polinom polinom5 = new Polinom("x^6+2*x");
        Polinom polinom6 = new Polinom("-x^6+4*x^3");
        Polinom polinom7 = new Polinom("x^7");
        Polinom polinom8 = new Polinom("-x^5");
        Polinom polinom9 = new Polinom("2*x^3");
        Polinom polinom10 = new Polinom("x^1");

        Polinom rezultat1 = new Polinom("22*x");
        Polinom rezultat2 = new Polinom("12*x");
        Polinom rezultat3 = new Polinom("8*x^3+3*x^2+6*x");
        Polinom rezultat4 = new Polinom("15*x^2+2");
        Polinom rezultat5 = new Polinom("6*x^5+2");
        Polinom rezultat6 = new Polinom("-6*x^5+12*x^2");
        Polinom rezultat7 = new Polinom("7*x^6");
        Polinom rezultat8 = new Polinom("-5*x^4");
        Polinom rezultat9 = new Polinom("6*x^2");
        Polinom rezultat10 = new Polinom("1");

        assertEquals(rezultat1, Operatii.derivarePolinoame(polinom1));
        assertEquals(rezultat2, Operatii.derivarePolinoame(polinom2));
        assertEquals(rezultat3, Operatii.derivarePolinoame(polinom3));
        assertEquals(rezultat4, Operatii.derivarePolinoame(polinom4));
        assertEquals(rezultat5, Operatii.derivarePolinoame(polinom5));
        assertEquals(rezultat6, Operatii.derivarePolinoame(polinom6));
        assertEquals(rezultat7, Operatii.derivarePolinoame(polinom7));
        assertEquals(rezultat8, Operatii.derivarePolinoame(polinom8));
        assertEquals(rezultat9, Operatii.derivarePolinoame(polinom9));
        assertEquals(rezultat10, Operatii.derivarePolinoame(polinom10));

    }

    @Test
    public void testIntegrare() {

        Polinom polinom1 = new Polinom("15*x^2+5");
        Polinom polinom2 = new Polinom("6*x^2+3");
        Polinom polinom3 = new Polinom("5*x^4+8*x^3+9*x^2");
        Polinom polinom4 = new Polinom("4*x^3+2*x");
        Polinom polinom5 = new Polinom("7*x^6+2*x");
        Polinom polinom6 = new Polinom("-14*x^6+4*x^3");
        Polinom polinom7 = new Polinom("2*x^1");
        Polinom polinom8 = new Polinom("-24*x^5-3*x^2");
        Polinom polinom9 = new Polinom("10*x^4-6*x^2-4*x^1");
        Polinom polinom10 = new Polinom("-5*x^4+12*x^3-6*x^2+8*x^1");

        Polinom rezultat1 = new Polinom("5*x^3+5*x");
        Polinom rezultat2 = new Polinom("2*x^3+3*x");
        Polinom rezultat3 = new Polinom("x^5+2*x^4+3*x^3");
        Polinom rezultat4 = new Polinom("x^4+x^2");
        Polinom rezultat5 = new Polinom("x^7+x^2");
        Polinom rezultat6 = new Polinom("-2*x^7+x^4");
        Polinom rezultat7 = new Polinom("x^2");
        Polinom rezultat8 = new Polinom("-4*x^6-x^3");
        Polinom rezultat9 = new Polinom("2*x^5-2*x^3-2*x^2");
        Polinom rezultat10 = new Polinom("-x^5+3*x^4-2*x^3+4*x^2");

        assertEquals(rezultat1, Operatii.integrarePolinoame(polinom1));
        assertEquals(rezultat2, Operatii.integrarePolinoame(polinom2));
        assertEquals(rezultat3, Operatii.integrarePolinoame(polinom3));
        assertEquals(rezultat4, Operatii.integrarePolinoame(polinom4));
        assertEquals(rezultat5, Operatii.integrarePolinoame(polinom5));
        assertEquals(rezultat6, Operatii.integrarePolinoame(polinom6));
        assertEquals(rezultat7, Operatii.integrarePolinoame(polinom7));
        assertEquals(rezultat8, Operatii.integrarePolinoame(polinom8));
        assertEquals(rezultat9, Operatii.integrarePolinoame(polinom9));
        assertEquals(rezultat10, Operatii.integrarePolinoame(polinom10));

    }

}
