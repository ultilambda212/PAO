package Admitere;

public class Persoana {
    private String nume;
    private String prenume;
    private String CNP;
    private int varsta;

    public Persoana(String nume, String prenume, String CNP, int varsta){
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.varsta = varsta;
    }

    Persoana(Persoana copy_this){
        this.nume = copy_this.nume;
        this.prenume = copy_this.prenume;
        this.CNP = copy_this.CNP;
        this.varsta = copy_this.varsta;
    }

    public String getNume(){
        return this.nume;
    }

    public String getPrenume(){
        return this.prenume;
    }

    public Persoana getPersoana(){
        return new Persoana(this);
    }

    public void informatii(){
        System.out.printf("[Nume] %s [Prenume] %s [Varsta] %d \n",
                            nume, prenume, varsta);
    }
}
