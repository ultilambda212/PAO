package Admitere;

public class Candidat extends Persoana {
    private int nrCandidat;
    private String domeniu;
    private String nota;

    public Candidat(){
        super("", "", "", -1);
        nrCandidat = -1;
        domeniu = "";
        nota = "";
    }

    public Candidat(String nume, String prenume, String CNP, int varsta, int nrCandidat, Domeniu domeniu) {
        super(nume, prenume, CNP, varsta);
        this.nrCandidat = nrCandidat;
        this.domeniu = domeniu.getNumeDomeniu();
        this.nota = "Absent";
    }

    Candidat(Candidat copy_this){
        super(copy_this.getPersoana());
        this.nrCandidat = copy_this.nrCandidat;
        this.domeniu = copy_this.domeniu;
        this.nota = copy_this.nota;
    }

    public void setNota(int nota){
        this.nota = String.valueOf(nota);
    }

    public String getNota(){
        return this.nota;
    }

    public Candidat getCandidat(){
        return new Candidat(this);
    }

    @Override
    public Persoana getPersoana(){
        return super.getPersoana();
    }

    @Override
    public void informatii(){
        super.informatii();
        System.out.printf("[Nr Candidat] %d [Domeniu] %s [Nota] %d \n",
                            nrCandidat, domeniu, Integer.parseInt(nota));
    }
}
