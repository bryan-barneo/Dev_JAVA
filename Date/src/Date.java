import java.util.Scanner;
import java.lang.*;

public class Date {
    private int jour;
    private int mois;
    private int année;
    private static String[] moisLettres = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "décembre"};
    private String MoisLettre = "";
    public Date(int J, int M, int A){
        this.jour = J;
        this.mois = M;
        this.année = A;
    }
    public String intEnLettres(){
        String[] moisLettre = this.moisLettres;
        String Mois = "";
        int Moisint = this.mois;
        for(int i = 0; i <= Moisint-1; i++){
            if(Moisint-1 == i){
                Mois += moisLettre[i];
                this.MoisLettre = Mois;
            }

        }
        return Mois;
    }
    public String toString() {
        intEnLettres();
        return this.jour + " " + this.MoisLettre + " " + année;
    }
    public void Affiche(){
        System.out.println("La date rentré est : Le " + this.jour +" "+ this.mois + " " + this.année);
    }
}
