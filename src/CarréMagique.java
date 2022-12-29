public class CarréMagique {
    public static void remplirEnCarréMagique(int[][] M) {
        int c=0;
        int nbLignes=M.length;
        int nbLignes2=nbLignes*nbLignes;
        int l=(nbLignes-1)/2;
        for(int i=0;i<nbLignes;i++){
            for(int j=0;j<nbLignes;j++){
                M[i][j]=0;
            }
        }
        for(int i=0;i<nbLignes2;i++){
            if(M[c][l]==0){
                M[c][l] = i + 1;
            }
            else{
                if(c-1<0){
                    c=nbLignes-1;

                }
                else{
                    c=c-1;
                }

                if(l-1<0){
                    l=nbLignes-1;
                }
                else{
                    l = l - 1;
                }
                M[c][l] = i + 1;
            }

            if(l+1>=nbLignes){
                l=0;
            }
            else{
                l=l+1;
            }

            if(c-1<0){
                c=nbLignes-1;

            }
            else{
                c=c-1;
            }
        }
    }

    public static int constanteMagiqueDe(int[][] CM) {
        int ConstantMag = 0;
        int nbColonnes = CM[0].length;
        for (int j = 0; j < nbColonnes; j++) {
            ConstantMag += CM[1][j];
        }
        return ConstantMag;
    }

    public static boolean cEstUnCarréMagique(int[][] T) {
        boolean UncarréMagique = true;
        int nbLignes = T.length;
        int nbColonnes = T[0].length;
        int rtlignes1 = 0;
        int rtlignes2 = 0;
        int rtlignes3 = 0;
        int rtColonnes1 = 0;
        int rtColonnes2 = 0;
        int rtColonnes3 = 0;
        int rtDiagonale =0;
        for (int j = 0; j < nbColonnes; j++) {
            rtlignes1 += T[0][j];
        }
        for (int j = 0; j < nbColonnes; j++) {
            rtlignes2 += T[1][j];
        }
        for (int j = 0; j < nbColonnes; j++) {
            rtlignes3 += T[2][j];
        }
        if (rtlignes1 != rtlignes2) {
            UncarréMagique = false;
        }
        if (rtlignes2 != rtlignes3) {
            UncarréMagique = false;
        }
        if (rtlignes1 != rtlignes3) {
            UncarréMagique = false;
        }
        for (int i = 0; i < nbLignes; i++) {
            rtColonnes1 += T[i][0];
        }
        for (int i = 0; i < nbLignes; i++) {
            rtColonnes2 += T[i][1];
        }
        for (int i = 0; i < nbLignes; i++) {
            rtColonnes3 += T[i][2];
        }
        if (rtColonnes1 != rtColonnes2) {
            UncarréMagique = false;
        }
        if (rtColonnes2 != rtColonnes3) {
            UncarréMagique = false;
        }
        if (rtColonnes1 != rtColonnes3) {
            UncarréMagique = false;
        }
        for(int i = 0; i < nbLignes; i++){
            rtDiagonale+=T[i][i];
        }
        if (rtlignes1 != rtColonnes1){
            if(rtColonnes1 != rtDiagonale){
                UncarréMagique = false;
            }
        }
        return UncarréMagique;
    }

    public static void afficherCarré(int[][] carré) {
        for (int i = 0; i < carré.length; i++) {
            for (int j = 0; j < carré[0].length; j++) {
                System.out.print(carré[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] M = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        int résultat=CarréMagique.constanteMagiqueDe(M);
        System.out.println(résultat);
        System.out.println(CarréMagique.cEstUnCarréMagique(M));
        CarréMagique.remplirEnCarréMagique(M);
        CarréMagique.afficherCarré(M);
    }

}
