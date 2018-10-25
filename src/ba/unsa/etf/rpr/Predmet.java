package ba.unsa.etf.rpr;



public class Predmet {
    private Student[] niz;
    private String nazivPredmeta;
    private String sifraPredmeta;
    private int maxBrStudenata;

    public Predmet(String naziv, String sifra, int kapacitet) {
        this.nazivPredmeta = naziv;
        this.sifraPredmeta = sifra;
        this.maxBrStudenata = kapacitet;
        niz = new Student[kapacitet];
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public int getMaxBrStudenata() {
        return maxBrStudenata;
    }


    public void upisi(Student s) {
        for (int i = 0; i < maxBrStudenata; i++)
            if (niz[i] == null) {
                niz[i] = new Student(s.getIme(), s.getPrezime(), s.getIndeks());
                break;
            }
    }

    public void ispisi(Student s) {
        for(int i = 0; i < this.getMaxBrStudenata(); i++ ){
            if(niz[i].equals(s)){
                for(int j = i; j + 1 < this.getMaxBrStudenata(); j++)
                {
                    niz[j] = niz[j+1];
                }
                niz[this.getMaxBrStudenata()-1] = null;
                break;
            }
           // if(i == maxBrStudenata -1)System.out.println("Student s tim podacima ne postoji!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Predmet)) return false;

        Predmet predmet = (Predmet) o;

        if (getNazivPredmeta() != null ? !getNazivPredmeta().equals(predmet.getNazivPredmeta()) : predmet.getNazivPredmeta() != null)
            return false;
        return getSifraPredmeta() != null ? getSifraPredmeta().equals(predmet.getSifraPredmeta()) : predmet.getSifraPredmeta() == null;
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i != maxBrStudenata; i++) {

            if (niz[i] == null) break;
            s += i + 1;
            s += ". ";
            s += niz[i].getIme();
            s += " ";
            s += niz[i].getPrezime();
            s += " (";
            s += niz[i].getIndeks();
            s += ")\n";
        }
        return s;

    }

}

