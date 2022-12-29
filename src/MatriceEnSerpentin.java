public class MatriceEnSerpentin {
    public static void remplirCetteMatriceEnSerpentin(int [][] n){
        int nbLignes = n.length;
        int nbColonnes = n[0].length;
        int x = 1;
        int compteur1 =0;
        int compteur2 =0;
        int compteur3 =0;
        for (int i = 0; i < nbLignes; i++){
            for (int j = 0; j < nbColonnes; j++){
                n[i][j] = 0;
            }
        }
        for (int i = 0; i < nbLignes - 3; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                n[i][j] = x;
                x++;
            }
        }
        for (int i = 1; i < nbLignes -2 ; i++) {
            compteur1 = x+x-2;
            for (int j = 0; j < nbColonnes; j++) {
                n[i][j] = compteur1;
                compteur1--;
            }
        }
        for (int i = 2; i < nbLignes -1 ; i++) {
            compteur2 = x+x-1;
            for (int j = 0; j < nbColonnes; j++) {
                n[i][j] = compteur2;
                compteur2++;
            }
        }
        for (int i = 3; i < nbLignes ; i++) {
            compteur3 = x*3+1;
            for (int j = 0; j < nbColonnes; j++) {
                n[i][j] = compteur3;
                compteur3--;
            }
        }
    }
    public static int[][] nouvelleMatriceEnSerpentin(int n){
        int[][] tabrangée =new int[n][n];
        remplirCetteMatriceEnSerpentin(tabrangée);
        return tabrangée;
    }
    //public static void main(String[] args) {
      //  int[][] n = {{1, 2, 5, 88}, {4, 5, 8, 55}, {7, 10, 9, 45},{11, 14, 56, 54}};
        //MatriceEnSerpentin.remplirCetteMatriceEnSerpentin(n);
        //AfficherMatrice.afficherMatrice(n);
    //}
}
