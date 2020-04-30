package Admitere;

import java.util.*;

import static Admitere.Citiri.*;

public class Main {

    public static void evalueazaCandidati(Candidat candidati[], int oficiu){
        Random rand = new Random();
        for(int i = 0; i < candidati.length; i++) {
            candidati[i].setNota(rand.nextInt(100 - oficiu + 1) + oficiu);
        }
    }

    public static void interogari(Facultate facultate){
        Scanner in = new Scanner(System.in);
        int interogare;

        facultate.printDescription();
        Interogari:
        while(true) {
            interogare = in.nextInt();
            switch (interogare) {
                case 0:
                    facultate.printAdresa();
                    break;
                case 1:
                    facultate.showCandidati();
                    System.out.printf("\n");
                    break;
                case 2:
                    facultate.showAdmisi();
                    System.out.printf("\n");
                    break;
                default:
                    break Interogari;
            }
        }
    }

    public static void main(String[] args) {
        Citiri CSV = Citiri.getInstance();
        Set<Facultate> Facultati = new HashSet<Facultate>();
        Facultate FMI;
        Vector<Adresa> adreseFacultate = new Vector();
        Adresa adr = new Adresa("Bucuresti", "Str. Academiei", 14, 1, "010014");
        adreseFacultate.add(adr);

        Domeniu domenii[] = CSV.loadDomenii("data/Domenii.csv");
        CSV.writeDomenii(domenii, "data/WrittenDomenii.csv");
        Candidat candidati[] = CSV.loadCandidati(domenii, "data/Candidati.csv");
        CSV.writeCandidati(candidati, "data/WrittenCandidati.csv");
        Supraveghetor supraveghetori[] = CSV.loadSupraveghetori("data/Supraveghetori.csv");
        CSV.writeSupraveghetori(supraveghetori, "data/WrittenSupraveghetori.csv");


        SalaExamen saliExamen[] = new SalaExamen[2];

        Supraveghetor supraveghetorSala1[] = new Supraveghetor[2];
        Supraveghetor supraveghetorSala2[] = new Supraveghetor[2];
        supraveghetorSala1[0] = supraveghetori[0];
        supraveghetorSala1[1] = supraveghetori[1];
        supraveghetorSala2[0] = supraveghetori[1];
        supraveghetorSala2[1] = supraveghetori[2];


        saliExamen[0] = CSV.loadSaliExamen(domenii[0], supraveghetorSala1, candidati, "data/SaliExamen.csv");
        saliExamen[1] = CSV.loadSaliExamen(domenii[0], supraveghetorSala2, candidati, "data/SaliExamen.csv");
        CSV.writeSaliExamen(saliExamen, "data/WrittenSaliExamen.csv");

        FMI = new Facultate(adreseFacultate.get(0), domenii, saliExamen, supraveghetori, candidati);
        FMI.setDescription("Facultatea de Matematica si Informatica din Bucuresti");
        Facultati.add(FMI);
        System.out.println("Introduceti un numar din urmatoarele:");
        System.out.println("0. Afiseaza adresa facultatii");
        System.out.println("1. Afiseaza candidatii examenului de admitere");
        System.out.println("2. Afiseaza persoanele admise");
        System.out.println("Orice alt numar va conduce la interogarea urmatoarei facultati\n");
        for(Facultate i : Facultati){
            evalueazaCandidati(i.candidati, 10);
            i.admite(i.candidati, 50);
            i.sorteazaCandidati();
            interogari(i);
        }
    }
}
