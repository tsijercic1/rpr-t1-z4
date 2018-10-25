package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
        private static Predmet[] predmeti;
        private static Student[] studenti;
        private static void makeStudent(){
            Scanner citac = new Scanner(System.in);
            System.out.print("Unesite ime i prezime studenta: ");
            String ime = citac.next();
            String prezime = citac.next();
            System.out.print("Unesite indeks studenta: ");
            int indeks = citac.nextInt();
            Student temp = new Student(ime,prezime,indeks);
            for(int i = 0;i<30;i++){
                if (studenti[i] == null){
                    studenti[i] = temp;
                    return ;
                }
                if (studenti[i].equals(temp)){
                    System.out.println("Student vec postoji!");
                    return ;
                }
                if(studenti[i].getIndeks() == temp.getIndeks()) {
                    System.out.println("Nije dozvoljeno imati dva studenta sa istim indeksom!");
                    return ;
                }

            }
            System.out.println("Nema mjesta za novog studenta!");
        }

        private static void makePredmet(){
            Scanner citac = new Scanner(System.in);
            System.out.print("Unesite naziv predmeta: ");
            String nazivPredmeta = citac.next();
            System.out.print("Unesite sifru predmeta: ");
            String sifraPredmeta = citac.next();
            System.out.print("Unesite maksimalni broj studenata: ");
            int maxBrStudenata = citac.nextInt();
            Predmet temp = new Predmet(nazivPredmeta,sifraPredmeta,maxBrStudenata);
            for(int i = 0; i<10;i++) {
                if(predmeti[i] == null)
                {
                    predmeti[i] = temp;
                    return;
                }
                if(predmeti[i].equals(temp)){
                    System.out.println("Student vec postoji!");
                    return ;
                }
                if(temp.getSifraPredmeta().equals(sifraPredmeta))
                {
                    System.out.println("Nije dozvoljeno imati dva predmeta sa istom sifrom!");
                }

            }
            System.out.println("Nema mjesta za novi predmet!");
            //treba staviti da se daje odmah informacija da je popunjeno
        }

        private static void signStudentin()
        {
            System.out.println("Kojeg studenta upisujete?");
            System.out.println("(Ukucajte njegov/njen redni broj)");
            int k;
            int brojStudenata = 0;
            for(int i = 0;i<30;i++) {
                brojStudenata++;
                if(studenti[i]== null)break;
                k=i+1;
                System.out.println(k+". "+studenti[i]);
            }

            Scanner citac = new Scanner(System.in);
            int redniBrojStudenta = citac.nextInt();

            while(redniBrojStudenta >brojStudenata || redniBrojStudenta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojStudenta = citac.nextInt();
            }

            System.out.println("Na koji predmet upisujete studenta?");
            System.out.println("(Ukucajte redni broj predmeta)");
            int brojPredmeta = 0;
            for(int i = 0;i<10;i++) {
                brojPredmeta++;
                if(predmeti[i] == null)break;
                System.out.println(i+1+". "+predmeti[i].getNazivPredmeta());
            }

            int redniBrojPredmeta = citac.nextInt();

            while(redniBrojPredmeta >brojPredmeta || redniBrojPredmeta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojPredmeta = citac.nextInt();
            }

            predmeti[redniBrojPredmeta-1].upisi(studenti[redniBrojStudenta-1]);

        }
        private static void signStudentOut() throws IllegalAccessException {
            System.out.println("Kojeg studenta ispisujete?");
            System.out.println("(Ukucajte njegov/njen redni broj)");

            int brojStudenata = 0;
            for(int i = 0;i<30;i++) {
                brojStudenata++;
                if(studenti[i].getIme() == null)break;

                System.out.println(i+1+". "+studenti[i]);
            }

            Scanner citac = new Scanner(System.in);
            int redniBrojStudenta = citac.nextInt();

            while(redniBrojStudenta >brojStudenata || redniBrojStudenta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojStudenta = citac.nextInt();
            }

            System.out.println("Sa kojeg predmeta ispisujete studenta?");
            System.out.println("(Ukucajte redni broj predmeta)");
            int brojPredmeta = 0;
            for(int i = 0;i<10;i++) {
                brojPredmeta++;
                if(predmeti[i].getNazivPredmeta() == null)break;
                System.out.println(i+1+". "+predmeti[i].getNazivPredmeta());
            }

            int redniBrojPredmeta = citac.nextInt();

            while(redniBrojPredmeta >brojPredmeta || redniBrojPredmeta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojPredmeta = citac.nextInt();
            }

            predmeti[redniBrojPredmeta-1].ispisi(studenti[redniBrojStudenta-1]);
        }

        private static void deleteStudent() throws IllegalAccessException {
            System.out.println("Kojeg studenta brišete?");
            System.out.println("(Ukucajte njegov/njen redni broj)");

            int brojStudenata = 0;
            for(int i = 0;i<30;i++) {
                brojStudenata++;
                if(studenti[i].getIme() == null)break;

                System.out.println(i+1+". "+studenti[i]);
            }

            Scanner citac = new Scanner(System.in);
            int redniBrojStudenta = citac.nextInt();

            while(redniBrojStudenta >brojStudenata || redniBrojStudenta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojStudenta = citac.nextInt();
            }

            for(int i = 0;i<10;i++) predmeti[i].ispisi(studenti[redniBrojStudenta - 1]);


            studenti[redniBrojStudenta-1]=null;
            for(int i = redniBrojStudenta-1;i < 29; i++){
                studenti[i] = studenti[i+1];
            }
            studenti[29]=null;
        }

        private static void deletePredmet(){
            System.out.println("Koji predmet brišete?");
            System.out.println("(Ukucajte redni broj predmeta)");

            int brojPredmeta = 0;
            for(int i = 0;i<30;i++) {
                brojPredmeta++;

                if(predmeti[i].getNazivPredmeta() == null)break;
                System.out.println(i+1+". "+predmeti[i].getNazivPredmeta());
            }

            Scanner citac = new Scanner(System.in);
            int redniBrojPredmeta = citac.nextInt();

            while(redniBrojPredmeta >brojPredmeta || redniBrojPredmeta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojPredmeta = citac.nextInt();
            }

            predmeti[redniBrojPredmeta-1]=null;
            for(int i = redniBrojPredmeta-1;i < 9; i++){
                predmeti[i] = predmeti[i+1];
            }
            predmeti[9]=null;
        }

        private static void writeStudent(){
            System.out.println("Iz kojeg predmeta želite spisak studenata?");
            System.out.println("(Ukucajte redni broj predmeta)");

            int brojPredmeta = 0;
            for(int i = 0;i<30;i++) {
                brojPredmeta++;

                if(predmeti[i] == null)break;
                System.out.println(i+1+". "+predmeti[i].getNazivPredmeta());
            }

            Scanner citac = new Scanner(System.in);
            int redniBrojPredmeta = citac.nextInt();

            while(redniBrojPredmeta >brojPredmeta || redniBrojPredmeta < 1 ){
                System.out.print("Greska! Ponovo unesite redni broj: ");
                redniBrojPredmeta = citac.nextInt();
            }

            System.out.println(predmeti[redniBrojPredmeta-1]);
        }
    public static void main(String[] args) throws IllegalAccessException {
         predmeti = new Predmet[10];
         studenti = new Student[30];
        Scanner citac = new Scanner(System.in);
        int komanda;
        System.out.println("--------Komandna linija--------");
      Meni:for(;;){
            //treba meni napraviti
            System.out.println("Komande:");
            System.out.println("1 : Kreiranje novog predmeta");
            System.out.println("2 : Kreiranje novog studenta");
            System.out.println("3 : Upis studenta na predmet");
            System.out.println("4 : Ispis studenta sa predmeta");
            System.out.println("5 : Brisanje studenta");
            System.out.println("6 : Brisanje predmeta");
            System.out.println("7 : Ispis spiska studenata na predmetu");
            System.out.println("0 : Kraj programa");
            System.out.print("Unesite vašu komandu: ");

            komanda = citac.nextInt();
            switch (komanda){
                case 2 :
                    makeStudent();
                    break;
                case 1 :
                    makePredmet();
                    break;
                case 3 :
                    signStudentin();
                    break;
                case 4 :
                    signStudentOut();
                    break;
                case 5 :
                    deleteStudent();
                    break;
                case 6 :
                    deletePredmet();
                    break;
                case 7 :
                    writeStudent();
                    break;
                default:
                    break Meni;
            }
        }

    }
}
