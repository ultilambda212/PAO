package Admitere;

public class SalaExamen {
    public String sala;
    public int etaj;
    private Domeniu domeniu;
    private Supraveghetor supraveghetori[];
    private Candidat candidati[];

    public SalaExamen(String sala, int etaj, Domeniu domeniu, Supraveghetor supraveghetori[], Candidat candidati[]){
        this.sala = sala;
        this.etaj = etaj;
        this.domeniu = new Domeniu(domeniu);
        this.supraveghetori = new Supraveghetor[supraveghetori.length];
        for(int i = 0; i < supraveghetori.length; i++){
            this.supraveghetori[i] = supraveghetori[i];
        }
        this.candidati = new Candidat[candidati.length];
        for(int i = 0; i < candidati.length; i++){
            this.candidati[i] = candidati[i];
        }
    }

    SalaExamen(SalaExamen copy_this){
        this.sala = copy_this.sala;
        this.etaj = copy_this.etaj;
        this.domeniu = new Domeniu(copy_this.domeniu);
        for(int i = 0; i < supraveghetori.length; i++){
            this.supraveghetori[i] = supraveghetori[i];
        }
        for(int i = 0; i < candidati.length; i++){
            this.candidati[i] = candidati[i];
        }
    }

    public void informatii(){
        System.out.printf("[Sala] %s [Etaj] %i [Domeniu] %s \n",
                            sala, etaj, domeniu.getNumeDomeniu());
    }
}
