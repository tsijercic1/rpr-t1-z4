package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void getNazivPredmeta() {
        Predmet a = new Predmet("Matematika", "PGM1",100);

        assertEquals("Matematika", a.getNazivPredmeta());
        assertEquals(100, a.getMaxBrStudenata());
        assertEquals("PGM1", a.getSifraPredmeta());
    }

    @Test
    void setNazivPredmeta() {
        Predmet b = new Predmet("Informatika","PGI2",100);
        b.setNazivPredmeta("Programiranje");
        assertEquals("Programiranje", b.getNazivPredmeta());
        b.setSifraPredmeta("PGP2");
        assertEquals("PGP2",b.getSifraPredmeta());
    }

    @Test
    void getSifraPredmeta() {
    }

    @Test
    void setSifraPredmeta() {
    }

    @Test
    void getMaxBrStudenata() {
    }

    @Test
    void upisi() {
        Predmet a = new Predmet("Fizika", "PGF3", 100);
        Student b = new Student("Tarik", "Sijerčić", 18252);
        a.upisi(b);
        Student c = new Student("Rijad", "Fejzić", 11111);
        a.upisi(c);
        assertEquals("1. Tarik Sijerčić (18252)\n2. Rijad Fejzić (11111)\n",a.toString());
        a.ispisi(b);
        assertEquals("1. Rijad Fejzić (11111)\n", a.toString());
    }

    @Test
    void ispisi() {

    }

    @Test
    void equals() {
    }

    //@Test
    //void toString() {
    //}
}