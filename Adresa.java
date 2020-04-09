package Admitere;

public class Adresa {
    String oras;
    String strada;
    int numarul;
    int sector;
    String codPostal;

    public Adresa(String oras, String strada, int numarul, int sector, String codPostal){
        this.oras = oras;
        this.strada = strada;
        this.numarul = numarul;
        this.sector = sector;
        this.codPostal = codPostal;
    }

    Adresa(Adresa copy_this){
        this.oras = copy_this.oras;
        this.strada = copy_this.strada;
        this.numarul = copy_this.numarul;
        this.sector = copy_this.sector;
        this.codPostal = copy_this.codPostal;
    }

    public Adresa getAdresa(){
        return new Adresa(this);
    }

    public void informatii(){
        if(sector == 0)
            System.out.printf("[Oras] %s [Strada] %s [Numarul] %d [Cod Postal] %s",
                                oras, strada, numarul, codPostal);
        if(sector == 1)
            System.out.printf("[Oras] %s [Strada] %s [Numarul] %d [Sector] %d [Cod Postal] %s \n",
                                oras, strada, numarul, sector, codPostal);
    }
}
