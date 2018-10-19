package ba.unsa.etf.rpr;

public class Student {
    private String ime;
    private String prezime;
    private int indeks;

    public Student(String ime, String prezime, int indeks) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getIndeks() != student.getIndeks()) return false;
        if (getIme() != null ? !getIme().equals(student.getIme()) : student.getIme() != null) return false;
        return getPrezime() != null ? getPrezime().equals(student.getPrezime()) : student.getPrezime() == null;
    }


    @Override
    public String toString() {
        String s = getIme();
        s += " ";
        s += getPrezime();
        s += " (";
        s += getIndeks();
        s+=")";
        return s;
    }
}