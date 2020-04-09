package Admitere;

public class Citiri {
    public static Candidat[] loadCandidati(Domeniu domeniu){
        Candidat candidat1;
        candidat1 = new Candidat("Marcel", "Mihailescu", "71263719823", 19, 0, domeniu);
        Candidat candidat2;
        candidat2 = new Candidat("Gigel", "Mihai", "18672371923", 19, 1, domeniu);
        Candidat candidat3;
        candidat3 = new Candidat("Ionel", "Andrei Gabriel", "817236123", 19, 2, domeniu);
        Candidat candidat4;
        candidat4 = new Candidat("Dorel", "Ionescu", "7812639123", 19, 3, domeniu);
        Candidat candidat5;
        candidat5 = new Candidat("Costel", "Adrian", "78126389123", 19, 4, domeniu);

        Candidat candidati[] = new Candidat[5];
        candidati[0] = candidat1;
        candidati[1] = candidat2;
        candidati[2] = candidat3;
        candidati[3] = candidat4;
        candidati[4] = candidat5;

        return candidati;
    }

    public static Domeniu[] loadDomenii(){
        Domeniu domeniu1 = new Domeniu("Mate", 300, 240, 60, 270f);
        Domeniu domeniu2 = new Domeniu("Info", 200, 150, 50, 300f);
        Domeniu domeniu3 = new Domeniu("CTI", 100, 75, 25, 330f);

        Domeniu domenii[] = new Domeniu[3];
        domenii[0] = domeniu1;
        domenii[1] = domeniu2;
        domenii[2] = domeniu3;

        return domenii;
    }

    public static Supraveghetor[] loadSupraveghetori(){
        Supraveghetor supraveghetor1 = new Supraveghetor("Cornel", "Andrei");
        Supraveghetor supraveghetor2 = new Supraveghetor("Mihai", "Georgian");
        Supraveghetor supraveghetor3 = new Supraveghetor("Alexandru", "Ricardo");

        Supraveghetor supraveghetori[] = new Supraveghetor[3];
        supraveghetori[0] = supraveghetor1;
        supraveghetori[1] = supraveghetor2;
        supraveghetori[2] = supraveghetor3;

        return supraveghetori;
    }

    public static SalaExamen loadSaliExamen(Domeniu domeniu, Supraveghetor supraveghetori[], Candidat candidati[]){
        SalaExamen sala = new SalaExamen("221C", 2, domeniu, supraveghetori, candidati);
        return sala;
    }
}
