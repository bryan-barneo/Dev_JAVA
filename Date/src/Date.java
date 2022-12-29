import java.util.Scanner;
import java.lang.*;

public class Date {
    private int jour;
    private int mois;
    private int année;
    private static String[] moisLettres = {"janvier", "février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre"};
    public Date(int J, int M, int A){
        this.jour = J;
        this.mois = M;
        this.année = A;
    }
    public String intEnLettres(moisLettres){
        String[] moisLettre = this.moisLettres;
        String Mois = "";
        int Moisint = this.mois;
        for(int i = 0; i <= Moisint-1; i++){
            if(Moisint == i){
                Mois += moisLettres;
            }
        }
        return Mois;
    }
    public String toString() {
        return this.jour + "/" + this.mois + "/" + année;
    }
    public void Affiche(){
        System.out.println("La date rentré est : Le " + this.jour +"/"+ this.mois + "/" + this.année);
    }
}
