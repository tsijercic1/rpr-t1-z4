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


    public void upisi(Student s)throws IllegalArgumentException {
        for (int i = 0; i < maxBrStudenata; i++) {
            if (niz[i] == null) {
                niz[i] = new Student(s.getIme(), s.getPrezime(), s.getIndeks());
                break;
            }
            else if(niz[i].equals(s))throw new IllegalArgumentException("Ne možete upisati identičnog studenta!\n");
        }
    }

    public void ispisi(Student s)throws IllegalAccessException {
        for(int i = 0; i < this.getMaxBrStudenata(); i++ ){
            if(niz[i]==null)throw new IllegalAccessException("Student sa tim podacima na ovom predmetu ne postoji!\n");
            if(niz[i].equals(s)){
                for(int j = i; j + 1 < this.getMaxBrStudenata(); j++)
                {
                    niz[j] = niz[j+1];
                }
                niz[this.getMaxBrStudenata()-1] = null;
                break;
            }
           if(i == maxBrStudenata -1)throw new IllegalAccessException("Student sa tim podacima na ovom predmetu ne postoji!\n");
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

