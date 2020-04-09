package Admitere;

import java.util.Arrays;

public class Facultate {
    public String description;
    private Adresa adresa;
    private Domeniu domenii[];
    private SalaExamen saliExamen[];
    private Supraveghetor supraveghetori[];
    protected Candidat candidati[];
    protected Candidat admisi[];
    private int notaMinima;

    public Facultate(Adresa adresa, Domeniu domenii[], SalaExamen saliExamen[], Supraveghetor supraveghetori[], Candidat candidati[]){
        this.adresa = adresa;

        this.domenii = new Domeniu[domenii.length];
        for(int i = 0; i < domenii.length; i++){
            this.domenii[i] = domenii[i];
        }

        this.saliExamen = new SalaExamen[saliExamen.length];
        for(int i = 0; i < saliExamen.length; i++){
            this.saliExamen[i] = saliExamen[i];
        }

        this.supraveghetori = new Supraveghetor[supraveghetori.length];
        for(int i = 0; i < supraveghetori.length; i++){
            this.supraveghetori[i] = supraveghetori[i];
        }

        this.candidati = new Candidat[candidati.length];
        for(int i = 0; i < candidati.length; i++){
            this.candidati[i] = candidati[i];
        }
    }

    Facultate(Facultate copy_this){
        this.adresa = copy_this.adresa;

        this.domenii = new Domeniu[copy_this.domenii.length];
        for(int i = 0; i < copy_this.domenii.length; i++){
            this.domenii[i] = copy_this.domenii[i];
        }

        this.saliExamen = new SalaExamen[copy_this.saliExamen.length];
        for(int i = 0; i < copy_this.saliExamen.length; i++){
            this.saliExamen[i] = copy_this.saliExamen[i];
        }

        this.supraveghetori = new Supraveghetor[copy_this.supraveghetori.length];
        for(int i = 0; i < copy_this.supraveghetori.length; i++){
            this.saliExamen[i] = copy_this.saliExamen[i];
        }

        this.candidati = new Candidat[copy_this.candidati.length];
        for(int i = 0; i < copy_this.candidati.length; i++){
            this.candidati[i] = copy_this.candidati[i];
        }

        this.admisi = new Candidat[copy_this.admisi.length];
        for(int i = 0; i < copy_this.admisi.length; i++){
            this.admisi[i] = copy_this.admisi[i];
        }
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void printDescription(){
        System.out.println(description);
    }

    public void printAdresa(){
        adresa.informatii();
    }

    public void admite(Candidat candidati[], int notaMinima){
        int nrAdmisi = 0;
        this.notaMinima = notaMinima;
        for(int i = 0; i < candidati.length; i++) {
            if (!"Absent".equals(candidati[i].getNota())) {
                if (Integer.parseInt(candidati[i].getNota()) >= notaMinima) {
                    nrAdmisi++;
                }
            }
        }

        this.admisi = new Candidat[nrAdmisi];
        int idx = 0;
        for(int i = 0; i < candidati.length; i++) {
            if (!"Absent".equals(candidati[i].getNota())) {
                if (Integer.parseInt(candidati[i].getNota()) >= notaMinima) {
                    this.admisi[idx] = candidati[i];
                    idx++;
                }
            }
        }
    }

    public void sorteazaCandidati(){
        Arrays.sort(candidati, new SorteazaAlfabetic());
    }

    public void showCandidati(){
        System.out.printf("Candidatii care au participat sunt:\n");
        for(int i = 0; i < candidati.length; i++){
            candidati[i].informatii();
            System.out.printf("\n");
        }
    }

    public void showAdmisi(){
        if(admisi.length == 0){
            System.out.printf("Nu a reusit nici un candidat sa fie admis la aceasta facultate \n");
            return;
        }
        else {
            System.out.printf("Candidatii care au reusit sa obtina minim %d de puncte sunt: \n", notaMinima);
        }
        for(int i = 0; i < admisi.length; i++){
            if(Integer.parseInt(admisi[i].getNota()) >= notaMinima) {
                admisi[i].informatii();
                System.out.printf("\n");
            }
        }
    }
}
