package Admitere;

import java.util.Comparator;

public class SorteazaAlfabetic implements Comparator<Candidat> {
    public int compare(Candidat a, Candidat b){
        if(Integer.parseInt(a.getNota()) < Integer.parseInt(b.getNota()))
            return 1;
        else if (Integer.parseInt(a.getNota()) > Integer.parseInt(b.getNota()))
            return -1;
        else if(Integer.parseInt(a.getNota()) == Integer.parseInt(b.getNota())){
            Persoana a1 = a.getPersoana();
            Persoana b1 = b.getPersoana();

            int nume = a1.getNume().compareTo(b1.getNume());
            if(nume < 0)
                return -1;
            else if(nume > 0)
                return 1;
            else if(nume == 0){
                int prenume = a1.getPrenume().compareTo(b1.getPrenume());
                if(prenume < 0)
                    return -1;
                else if(prenume > 0)
                    return 1;
            }
        }
        return 0;
    }
}
