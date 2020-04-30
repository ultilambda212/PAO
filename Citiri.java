package Admitere;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Citiri {
    private static Citiri single_instance = null;

    Citiri(){ }

    public static Citiri getInstance(){
        if(single_instance == null)
            single_instance = new Citiri();
        return single_instance;
    }

    public static Domeniu getDomeniuFromString(Domeniu[] domenii, String domeniu_cautat){
        for(int i = 0; i < domenii.length; i++){
            if(domenii[i].getNumeDomeniu().equals(domeniu_cautat))
                return domenii[i];
        }
        System.out.println("WARNING: Domeniul cautat nu exista!");
        return new Domeniu();
    }

    public static Candidat[] loadCandidati(Domeniu[] domenii, String filePath) {
        File file = new File(filePath);
        Candidat candidati[] = new Candidat[5];
        try {
            int nr = 0;
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");

                Candidat candidat = new Candidat(info[0], info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]), getDomeniuFromString(domenii, info[5]));
                candidati[nr] = new Candidat(candidat);
                nr++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return candidati;
    }

    public static Domeniu[] loadDomenii(String filePath){
        File file = new File(filePath);
        Domeniu domenii[] = new Domeniu[3];
        try {
            int nr = 0;
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");
                Domeniu domeniu = new Domeniu(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]), Float.parseFloat(info[4]));
                domenii[nr] = new Domeniu(domeniu);
                nr++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return domenii;
    }

    public static Supraveghetor[] loadSupraveghetori(String filePath){
        File file = new File(filePath);
        Supraveghetor supraveghetori[] = new Supraveghetor[3];
        try {
            int nr = 0;
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");
                Supraveghetor supraveghetor = new Supraveghetor(info[0], info[1]);
                supraveghetori[nr] = new Supraveghetor(supraveghetor);
                nr++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Supraveghetorii au fost incarcati!");
        return supraveghetori;
    }

    public static SalaExamen loadSaliExamen(Domeniu domeniu, Supraveghetor supraveghetori[], Candidat candidati[], String filePath){
        File file = new File(filePath);
        SalaExamen sala = null;
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");
                sala = new SalaExamen(info[0], Integer.parseInt(info[1]), domeniu, supraveghetori, candidati);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sala;
    }

    public static void writeSaliExamen(SalaExamen[] sala, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sala.length; i++){
                sb.append(sala[i].sala);
                sb.append(",");
                sb.append(sala[i].etaj);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeDomenii(Domeniu[] domenii, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < domenii.length; i++){
                sb.append(domenii[i].getNumeDomeniu());
                sb.append(",");
                sb.append(domenii[i].nrLocuri);
                sb.append(",");
                sb.append(domenii[i].nrLocuriBuget);
                sb.append(",");
                sb.append(domenii[i].nrLocuriTaxa);
                sb.append(",");
                sb.append(domenii[i].taxa);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeCandidati(Candidat[] candidati, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < candidati.length; i++){
                sb.append(candidati[i].nrCandidat);
                sb.append(",");
                sb.append(candidati[i].domeniu);
                sb.append(",");
                sb.append(candidati[i].nota);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeSupraveghetori(Supraveghetor[] supraveghetori, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < supraveghetori.length; i++){
                sb.append(supraveghetori[i].nume);
                sb.append(",");
                sb.append(supraveghetori[i].prenume);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
