package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getIme() {
        Student a = new Student("Tarik", "Sijerčić", 18252);
        Student b = new Student("Samra", "Pušina", 18145);
        assertEquals("Samra", b.getIme());
        assertEquals("Sijerčić",a.getPrezime());
        assertEquals(18252,a.getIndeks());
    }

    @Test
    void setIme() {
        Student a = new Student("Tarik", "Sijerčić", 18252);
        Student b = new Student("Samra", "Pušina", 18145);

        a.setIme("Samra");
        a.setPrezime("Pušina");
        a.setIndeks(18145);
        assertEquals(true,a.equals(b));
        assertEquals("Samra Pušina (18145)",a.toString());
    }

    @Test
    void getPrezime() {
    }

    @Test
    void setPrezime() {
    }

    @Test
    void getIndeks() {
    }

    @Test
    void setIndeks() {
    }

    @Test
    void equals() {
    }

    //@Test
    //void toString() {
    //}
}