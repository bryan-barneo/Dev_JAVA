import java.sql.SQLOutput;

public class MainFraction {
    public static void main(String args[]){

        Fraction f1, f2, f3, f4, f5, f6, f7, f8, f9; // declaration de 4 variables/instances de type/classe Fraction

        f1 = new Fraction(-4,5); // fabrication d'une instance de la classe Fraction à l'aide du constructeur a deux arguments entiers

        f2 = new Fraction(13,26); // fabrication d'une instance de la classe Fraction à l'aide du constructeur a deux arguments entiers

        f3 = new Fraction("24/36"); // fabrication d'une instance de la classe Fraction à partir d'une chaîne de caractères

        f4 = new Fraction(f2); // fabrication d'une instance de la classe Fraction par recopie de l'instance f2

        f8 = new Fraction(13, 26);
        f9 = new Fraction(2, 3);

        System.out.print ("f1 = "); System.out.println (f1.toString());
        System.out.println ("f2 = " + f2.toString());
        System.out.println ("f3 = " + f3.toString());
        System.out.println ("f4 = " + f4); // f4 n'etant pas de type String, f4.toString() est invoquee automatiquement : le resultat est concatene a la chaine precedente ("f4 = ")

        /* A COMPLETER A PARTIR D'ICI !! */
        f5 = f2.plus(f1);
        System.out.println("f5 = "+f5);
        System.out.println("f5 réduit = " + f5.fractionReduite());
        f6 = f2.fois(f1);
        System.out.println("f6 = " + f6 );
        System.out.println("f6 réduit =" +f6.fractionReduite());
        f7 = f2.fois(f2);
        System.out.println("f7 = " + f7 );
        System.out.println("f7 réduit =" +f7.fractionReduite());
        System.out.println(f2.égale(f3));
        System.out.println(f2.égale(f8));
        System.out.println(f9.estIrréductible());
        System.out.println(f2.estIrréductible());
    }
}