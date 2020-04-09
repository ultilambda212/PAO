package Admitere;

public class Domeniu {
    private String numeDomeniu;
    private int nrLocuri;
    private int nrLocuriBuget;
    private int nrLocuriTaxa;
    private float taxa;

    public Domeniu(){
        this.numeDomeniu = "";
        this.nrLocuri = 0;
        this.nrLocuriBuget = 0;
        this.nrLocuriTaxa = 0;
        this.taxa = 0f;
    }

    public Domeniu(String numeDomeniu, int nrLocuri, int nrLocuriBuget, int nrLocuriTaxa, float taxa){
        this.numeDomeniu = numeDomeniu;
        this.nrLocuri = nrLocuri;
        this.nrLocuriBuget = nrLocuriBuget;
        this.nrLocuriTaxa = nrLocuriTaxa;
        this.taxa = taxa;
    }

    Domeniu(Domeniu copy_this){
        this.numeDomeniu = copy_this.numeDomeniu;
        this.nrLocuri = copy_this.nrLocuri;
        this.nrLocuriBuget = copy_this.nrLocuriBuget;
        this.nrLocuriTaxa = copy_this.nrLocuriTaxa;
        this.taxa = copy_this.taxa;
    }

    public void informatii(){
        System.out.printf("[Nume Domeniu] %s [Nr Locuri] %d [Nr Locuri Buget] %d [Nr Locuri Taxa] %d [Costul unui loc la taxa] %f \n",
                            numeDomeniu, nrLocuri, nrLocuriBuget, nrLocuriTaxa, taxa);
    }

    public String getNumeDomeniu(){
        return numeDomeniu;
    }

    public Domeniu getDomeniu(){
        return new Domeniu(this);
    }
}
