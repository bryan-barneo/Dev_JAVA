import java.util.*;
import java.lang.*;

public class MasterMindBase {
    //Fait par Bryan
    public static void afficherTableau(int[] T) {
        for(int i = 0; i < T.length; i++){
            System.out.println(T[i]);
        }
    }
    //Fait par Bryan
    public static int[] initTab(int nb, int val){
        assert nb >= 0;
        int[] tab = new int [nb];
        for (int i=0;i<nb;i++){
            tab[i]=val;
        }
        return tab;
    }
    //______________________________________________
    //Fait par Bryan
    public static int[] copieTab(int[] tab){
        int[] Copietab = new int[tab.length];
        for(int i = 0; i < tab.length; i++){
            Copietab[i]=tab[i];
        }
        return Copietab;
    }
    //______________________________________________
    //Fait par Bryan
    public static String listElem(char[] t){
        String Carac="";
        int lignes = t.length;
        for (int i = 0; i < lignes; i++) {
            if(i==0){
                Carac+="(";
                Carac+=t[i];
            }
            else{
                Carac+=",(";
                Carac+=t[i];
            }
            Carac+=")";
        }
        return Carac;
    }
    //______________________________________________
    //Fait par Bryan
    public static int plusGrandIndice(char[] t, char c){
        int lignes = t.length;
        int Indice = -1;
        for (int i = 0; i < lignes; i++) {
            if(t[i] == c){
                Indice=i;
            }
        }
        return Indice;
    }
    //______________________________________________
    //Fait par Bryan
    public static boolean estPresent(char[] t, char c){
        Boolean Present = false;
        int Indice = -1;
        if(Indice != plusGrandIndice(t,c)){
            Present = true;
        }
        return Present;
    }
    //______________________________________________
    //Fait par Bryan
    public static boolean elemDiff(char[] t){
        int lignes = t.length;
        Boolean Differents = true;
        for(int i = 0; i < lignes; i++){
            if(plusGrandIndice(t,t[i]) != i){
                Differents = false;
            }
        }
        return Differents;
    }
    //______________________________________________
    //Fait par Bryan
    public static boolean sontEgaux(int[] t1, int[] t2) {
        boolean Sontégaux= true;
        int Lignes1 = 0;
        int Lignes2 = 0;
        for (int i = 0; i < t1.length; i++) {
            Lignes1 += t1[i];
            Lignes2 += t2[i];
            if(Lignes1 != Lignes2){
                Sontégaux = false;
            }
        }
        return Sontégaux;
    }
    //______________________________________________
    //Fait par Bryan
    public static int[] codeAleat(int lgCode, int nbCouleurs){
        int n = 0;
        int [] codeAleat = new int[lgCode];
        for(int i = 0; i < lgCode; i++){
            n = (int)(Math.random() * nbCouleurs-1);
            codeAleat[i]= n;
        }
        return codeAleat;
    }
    //____________________________________________________________
    //Fait par Bryan
    public static boolean codeCorrect(String codMot, int lgCode, char[] tabCouleurs){
        Boolean estCorrect = true;
        int nbCodMot= codMot.length();
        if(nbCodMot>lgCode){
            System.out.println("Erreur: Trop de Valeurs dans codMot");
            estCorrect = false;
        }
        for(int i = 0; i < nbCodMot; i++){
            char c = codMot.charAt(i);
            Boolean existeDans = true;
            if(existeDans != estPresent(tabCouleurs,c)){
                System.out.println("Erreur: Valeurs inexistante dans le tableau couleurs");
                estCorrect = false;
            }
        }
        return estCorrect;
    }
    //____________________________________________________________
    //Fait par Bryan
    public static int[] motVersEntiers(String codMot, char[] tabCouleurs){
        int[] tab = new int [codMot.length()];
        for(int i = 0; i < codMot.length(); i++){
            char c = codMot.charAt(i);
            tab[i]=plusGrandIndice(tabCouleurs, c);
        }
        return tab;
    }
    //____________________________________________________________
    //Fait par Bryan
    public static int[] propositionCodeHumain(int nbCoups, int lgCode, char[] tabCouleurs){
        Scanner scanner = new Scanner(System.in);
        String PropCode="";
        Boolean Estcorrect = false;
        nbCoups++;
        while(Estcorrect == false){
            System.out.println("Vous en êtes au " + nbCoups + " Nombre de coups.");
            PropCode = scanner.nextLine();
            if(codeCorrect(PropCode,lgCode,tabCouleurs)== true){
                Estcorrect = true;
            }
        }
        return motVersEntiers(PropCode, tabCouleurs);
    }
    //____________________________________________________________
    //Fait par Bryan
    public static int nbBienPlaces(int[] cod1,int[] cod2){
        int lignescod1 = cod1.length;
        int bienPlaces = 0;
        if(cod1.length == cod2.length){
            for (int i = 0; i < cod1.length; i++) {
                if(cod1[i] == cod2[i]){
                    bienPlaces=bienPlaces+1;
                }
            }
        }
        else {
            System.out.println("Erreur: la longueur de cod1 est différentes de cod2");
        }
        return bienPlaces;
    }
    //____________________________________________________________
    //Fait par Bryan
    public static int[] tabFrequence(int[] cod, int nbCouleurs){
        int[] tab = new int[nbCouleurs];
        for(int i = 0; i < cod.length; i++){
            tab[cod[i]]+=1;
            if(cod.length > nbCouleurs-1){
                System.out.println("Erreur: Valeur trop grande dans cod."+ cod + "\n");
            }
        }
        return tab;
    }
    //____________________________________________________________
    //Fait par Bryan
    public static int nbCommuns(int[] cod1, int[] cod2, int nbCouleurs) {
        int Communs = 0;
        int[] tabcod1 = tabFrequence(cod1, nbCouleurs);
        int[] tabcod2 = tabFrequence(cod2, nbCouleurs);

        for(int i = 0; i < nbCouleurs; ++i){
            if (tabcod1[i] == tabcod2[i]){
                Communs += tabcod1[i];
            } else if (tabcod1[i] < tabcod2[i]){
                Communs += tabcod1[i];
            } else{
                Communs += tabcod2[i];
            }
        }

        return Communs;
    }

    //____________________________________________________________
    //Fait par Bryan
    public static int[] nbBienMalPlaces(int[] cod1,int[] cod2, int nbCouleurs){
        int Communs=nbBienPlaces(cod1,cod2);
        int NonCommuns = cod1.length-Communs;
        int[] tab = new int[2];
        tab[0] += Communs;
        tab[1] += NonCommuns;
        return tab;
    }

    //____________________________________________________________
    //.........................................................................
    // MANCHEHUMAIN
    //.........................................................................
    //Fait par Bryan
    public static int mancheHumain(int lgCode, char[] tabCouleurs, int numManche, int nbEssaisMax){
        int nbCouleurs = tabCouleurs.length;
        int[] codordi = codeAleat(lgCode,nbCouleurs-1);
        int[] codhumain = new int[lgCode];
        int[] codverif = new int[lgCode];
        int nbCoupsJoué = 0;
        int Resultat = 0;
        boolean Reponsetrouvé = false;
        while (nbCoupsJoué < nbEssaisMax && Reponsetrouvé == false){
            codhumain=propositionCodeHumain(nbCoupsJoué,lgCode,tabCouleurs);
            System.out.println("Le nombre de couleurs communes est de : "+nbCommuns(codordi,codhumain,nbCouleurs)+"\n");
            codverif=codhumain;
            System.out.println("La première valeur est la valeur de couleurs bien placée et la deuxième ceux mal placées.");
            codverif=nbBienMalPlaces(codordi,codhumain,nbCouleurs);
            afficherTableau(codverif);
            System.out.println("//////////////////////////////////////////////////////////////////////////////");
            if(codverif[0]==lgCode){
                Reponsetrouvé = true;
            }
            else {
                nbCoupsJoué++;
            }
        }
        int nbMalplacés = codverif[1];
        if(Reponsetrouvé == false){
            int malus = nbMalplacés + 2 * (lgCode- codverif[0]+nbMalplacés);
            Resultat = malus;
            System.out.println("Vous avez perdu, vous avez "+ Resultat+" points de malus.");
        }else{
            System.out.println("Bravo vous avez trouvé en "+nbCoupsJoué+" coups bien joué !!");
            Resultat = nbCoupsJoué;
        }
        return Resultat;
    }

    //____________________________________________________________

    //...................................................................
    // FONCTIONS COMPLÉMENTAIRES SUR LES CODES POUR LA MANCHE ORDINATEUR
    //...................................................................
    //Fait par Bryan
    public static String entiersVersMot(int[] cod, char[] tabCouleurs){
        String Mot = "";
        for (int i = 0; i < cod.length; i++) {
            Mot += tabCouleurs[cod[i]];
        }
        return Mot;
    }
    //___________________________________________________________________
    //Fait par Bryan
    public static boolean repCorrecte(int[] rep, int lgCode){
        boolean Correcte = false;
        int Valeurun = rep[0];
        int Valeurdeux = rep[1];
        if((Valeurun>=0) && (Valeurdeux>=0) && ((Valeurun+Valeurdeux) <= lgCode)){
            Correcte = true;
        }
        return Correcte;
    }
    //___________________________________________________________________
    //Fait par Bryan
    public static int[] reponseHumain(int lgCode){
        Scanner entrée = new Scanner(System.in);
        int Bienplacés = 0;
        int Malplacés = 0;
        boolean reponse = false;
        int[] tab = new int[2];
        while(reponse == false) {
            System.out.println("Combien de nombres sont bien placés ?");
            Bienplacés = entrée.nextInt();
            System.out.println("Combien de nombres sont Mal placés ?");
            Malplacés = entrée.nextInt();
            if ((Bienplacés + Malplacés) > lgCode) {
                System.out.println("Erreur nombre rentée");
                reponse = false;
            }
            else {
                reponse = true;
            }
        }
        System.out.println("\n");
        tab[0] += Bienplacés;
        tab[1] += Malplacés;
        return tab;
    }
    //___________________________________________________________________
    //Fait par Bryan
    public static boolean passeCodeSuivantLexico(int[] cod1, int  nbCouleurs){
        int Variablea = cod1.length -1;
        while (Variablea >= 0 && cod1[Variablea] == nbCouleurs-1){
            Variablea--;
        }
        if (Variablea < 0) {
            for(int i = 0; i < cod1.length; ++i) {
                cod1[i] = 0;
            }

            return false;
        } else {
            int Variableb = cod1[Variablea]++;
            ++Variablea;

            while (Variablea < cod1.length){
                cod1[Variablea] = 0;
                Variablea++;
            }

            return true;
        }
    }
    //___________________________________________________________________
    //Fait par Bryan
    public static boolean estCompat(int[] cod1, int[][] cod, int[][] rep, int nbCoups, int nbCouleurs) {
        boolean compatibles = true;

        for(int i = 0; i < nbCoups; ++i) {
            if (sontEgaux(nbBienMalPlaces(cod1, cod[i], nbCouleurs), rep[i]) == false|| sontEgaux(cod1, cod[i]) == true) {
                compatibles = false;
            }
        }

        return compatibles;
    }

    //___________________________________________________________________
    //Fait par Bryan
    public static boolean passeCodeSuivantLexicoCompat(int [] cod1, int [][] cod,int [][] rep, int nbCoups, int  nbCouleurs){
        int[] cod2 = new int[cod1.length];
        passeCodeSuivantLexico(cod1, nbCouleurs);

        while(!estCompat(cod1, cod, rep, nbCoups, nbCouleurs) && !sontEgaux(cod1, cod2)) {
            passeCodeSuivantLexico(cod1, nbCouleurs);
        }

        return !sontEgaux(cod1, cod2);
    }
    //___________________________________________________________________
    // manche Ordinateur
    public static int mancheOrdinateur(int lgCode,char[] tabCouleurs, int numManche, int nbEssaisMax) {
        int[] Tab1 = new int[lgCode];
        int[][] TabEssaiMax = new int[nbEssaisMax][lgCode];
        int nbCoups = 0;
        int nbCouleur = tabCouleurs.length;
        boolean ExisteSuivant = true;
        int[] RepHumain = new int[2];
        int[][] ReponseOrdi = new int[nbEssaisMax][2];
        int[] gagné = new int[]{lgCode, 0};
        System.out.println("Crée un code couleurs de mémoire de taille " + lgCode + " avec les couleurs que vous avez énnumérées précédement.");
        while (sontEgaux(RepHumain, gagné) == false && ExisteSuivant == true && nbCoups < nbEssaisMax) {
            System.out.println("//////////////////////////////////////////////////////////////////////////////");
            System.out.println("proposition ordinateur n°" + (nbCoups + 1) + ": " + entiersVersMot(Tab1, tabCouleurs));
            System.out.println("//////////////////////////////////////////////////////////////////////////////");
            RepHumain = reponseHumain(lgCode);
            if (sontEgaux(RepHumain, gagné) == false) {
                ExisteSuivant = passeCodeSuivantLexicoCompat(Tab1, TabEssaiMax, ReponseOrdi, nbCoups, nbCouleur);
            }
            nbCoups++;
            System.out.println("//////////////////////////////////////////////////////////////////////////////");
        }
        if (ExisteSuivant == false) {
            System.out.println("Erreur: Saisie des réponses bien et mal placés car aucun code n'a été trouvé");
            return 0;
        } else if (nbCoups == nbEssaisMax && sontEgaux(ReponseOrdi[ReponseOrdi.length - 1], gagné) == false) {
            System.out.println("l'ordinateur n'a pas trouvé en moins de " + nbEssaisMax + " coups.");
            return ReponseOrdi[nbCoups - 1][1] + 2 * (lgCode - (ReponseOrdi[nbCoups - 1][0] + ReponseOrdi[nbCoups - 1][1]));
        } else {
            System.out.println("l'ordinateur a trouvé en " + nbCoups + " coups.");
            return nbCoups;
        }
    }
    //___________________________________________________________________
    //.........................................................................
    // FONCTIONS DE SAISIE POUR LE PROGRAMME PRINCIPAL
    //.........................................................................
    //Fait par Bryan
    public static int saisirEntierPositif(){
        Scanner SaisirPositif = new Scanner(System.in);
        int nbPositif = SaisirPositif.nextInt();
        while(nbPositif < 0){
            nbPositif=SaisirPositif.nextInt();
        }
        return nbPositif;
    }
    //___________________________________________________________________
    //Fait par Bryan
    public static int saisirEntierPairPositif(){
        System.out.println("Saisir un entier pair.");
        int entierPair=saisirEntierPositif();
        while(entierPair % 2 != 0){
            System.out.println("Saisir un entier pair.");
            entierPair=saisirEntierPositif();
        }
        return entierPair;
    }
    //___________________________________________________________________
    //Fait par Bryan
    public static char[] saisirCouleurs(){
        Scanner SaisirCouleurs = new Scanner(System.in);
        int nbCouleurs = saisirEntierPositif();
        char[] TabCouleurs = new char[nbCouleurs];
        for(int i = 0; i < nbCouleurs; i++){
            String Couleur = SaisirCouleurs.nextLine();
            char PropCouleur = Couleur.charAt(0);
            boolean Present=estPresent(TabCouleurs,PropCouleur);
            while(Present == true){
                System.out.println("Erreur initiale déjà présent.");
                Couleur = SaisirCouleurs.nextLine();
                PropCouleur = Couleur.charAt(0);
                Present=estPresent(TabCouleurs,PropCouleur);

            }
            TabCouleurs[i] = PropCouleur;
        }

        return TabCouleurs;
    }
    //___________________________________________________________________
    //.........................................................................
    // PROGRAMME PRINCIPAL
    //.........................................................................
    public static void main (String[] args){
        int PointHumain = 0;
        int PointOrdi = 0;
        System.out.print("Ecrivez la longueur du code ");
        int lgCode = saisirEntierPositif();
        System.out.println("Saisir le nombre de couleurs puis les couleurs que vous voulez : ");
        char[] tabCouleurs = saisirCouleurs();
        System.out.print("Saisir le nombre d'essai maximum ");
        int nbEssaisMax = saisirEntierPositif();
        System.out.print("Saisir le nombre de manches ");
        int nbMancheTotal = saisirEntierPairPositif();
        for(int nbManche = 0; nbManche < nbMancheTotal; nbManche += 2) {
            System.out.println("Manche "+ nbMancheTotal + " Vous devez trouver le code");
            PointOrdi += mancheHumain(lgCode, tabCouleurs, nbManche + 1, nbEssaisMax);
            System.out.println("//////////////////////////////////////////////////////////////////////////////");
            System.out.println("Manche "+ nbMancheTotal + " Vous devez inventer un code");
            PointHumain += mancheOrdinateur(lgCode, tabCouleurs, nbManche + 2, nbEssaisMax);
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////////");
        if (PointOrdi > PointHumain) {
            System.out.println("Vous avez gagné avec " + PointHumain + " points pour Vous et " + PointOrdi + " points pour l'Ordi.");
        } else if (PointOrdi == PointHumain) {
            System.out.println("égalité entre vous et l'Ordi avec " + PointOrdi + " points");
        } else {
            System.out.println("L'ordinateur a gagné avec " + PointOrdi + " points pour l'ordi et " + PointHumain + " points pour vous.");
        }
    } // fin main
} // fin MasterMindBase