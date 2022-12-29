import java.util.Scanner;
import java.lang.*;

public class Fraction {
    private int numerateur;
    private int denominateur; // Invariant : different de 0
    public Fraction (int num, int denom) {
        /*  Action : constructeur a partir de deux entiers.
         *  Pre-requis : denom est different de 0 !
         */
        this.numerateur = num;
        this.denominateur = denom;
    }
    public Fraction (Fraction frac) { // constructeur par recopie frac --> this
        this.numerateur = frac.numerateur;
        this.denominateur = frac.denominateur;
        // Rmq : peut s'écrire en faisant appel au constructeur precedent : this(frac.numerateur, frac.denominateur);
    }
    public Fraction (String strFrac) {
	/* Action : constructeur a partir d'une chaine de caracteres.
	   Pre-requis : strFrac est une chaine de caracteres correspondant a une fraction, par exemple "13/26"

	   Remarque pedagogique : parseInt est une methode de classe (Integer) ;
	   split est une methode d'instance (strFrac)
	*/
        String str[];   // declaration d'un tableau de chaines de caracteres
        str = strFrac.split("/");  // Appel de la methode 'split' d'un objet de classe String : eclatement de strFrac en plusieurs sous-chaines separees par des '/' et rangees
        // dans str. Exemple : si strFrac=="13/26", alors str[0] vaut "13" et str[1] vaut "26".
        this.numerateur = Integer.parseInt(str[0]);    // La methode de la classe Integer permet de traduire la chaine en argument en Integer...
        // Java sait automatiquement transformer (on dit "caster" ou "faire un cast" - anglicisme) une valeur Integer vers int.
        this.denominateur = Integer.parseInt(str[1]);
    }
    public String toString() {
        return this.numerateur + "/" + this.denominateur;
    }
    public void affiche() {
        	System.out.println("Fraction = " + this.numerateur + " / " + this.denominateur);
         }
    /* A COMPLETER A PARTIR D'ICI !! */
    public void reduire(){
        int NumModif = this.numerateur;
        int DenomModif = this.denominateur;
        int pgcd = 0;
        while(denominateur == 0){
            System.out.println("Erreur dénominateur == 0");
        }
        pgcd = Ut.pgcd(NumModif,DenomModif);
        numerateur /= pgcd;
        denominateur /= pgcd;
    }
    public Fraction fractionReduite(){
        Fraction f = new Fraction(this.numerateur,this.denominateur);
        f.reduire();
        return f;
    }
    public Fraction plus(Fraction F1){
        int denom = this.denominateur;
        int num = this.numerateur;
        int numf1 = F1.numerateur;
        int denomf1 = F1.denominateur;
        if(this.denominateur != F1.denominateur){
            num = num * denomf1;
            denomf1 = denomf1 * denom;
            numf1 = numf1 * denom;
            denom = denomf1;
        }
        num = num + numf1;
        Fraction résultat = new Fraction(num,denom);
        return résultat;
    }
    public Fraction fois(Fraction F2){
        int num = this.numerateur * F2.numerateur;
        int denom = this.denominateur * F2.denominateur;
        Fraction résultat = new Fraction(num,denom);
        return résultat;
    }
    public Fraction puissance(int puissance){
        int num = this.numerateur;
        int denom = this.denominateur;
        Fraction résultat = new Fraction(num,denom);
        Fraction fraction0 = new Fraction(num,denom);
        for (int i = 0; i <= puissance; i++){
            résultat = fraction0.fois(fraction0);
        }
        return résultat;
    }
    public boolean égale(Fraction F2){
        boolean estégale = false;
        int numF1 = this.numerateur;
        int denomF1 = this.denominateur;
        if(numF1 == F2.numerateur && denomF1 == F2.denominateur){
            estégale = true;
        }
        return estégale;
    }
    public boolean estIrréductible(){
        boolean Irréductible = false;
        int numF1 = this.numerateur;
        int denomF1 = this.denominateur;
        if(Ut.pgcd(numF1, denomF1) > 1 ){
            Irréductible = true;
        }
        return Irréductible;
    }
}