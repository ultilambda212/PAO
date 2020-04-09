package Admitere;

public class Supraveghetor {
    private String nume;
    private String prenume;

    public Supraveghetor(String nume, String prenume){
        this.nume = nume;
        this.prenume = prenume;
    }

    Supraveghetor(Supraveghetor copy_this){
        this.nume = copy_this.nume;
        this.prenume = copy_this.prenume;
    }

    public Supraveghetor getSupraveghetor(){
        return new Supraveghetor(this);
    }

    public void informatii(){
        System.out.printf("[Nume] %s [Prenume] %s \n",
                            nume, prenume);
    }
}
