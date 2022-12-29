public class MatriceEnDiagonale {
    public static void remplirCetteMatriceEnDiagonale(int[][] n){
        int nbLignes = n.length;
        int nbColonnes = n[0].length;
        for (int i = 0; i < nbLignes; i++){
            for (int j = 0; j < nbColonnes; j++){
                n[i][j] = 0;
            }
        }
    }
    public static int[][] nouvelleMatriceEnDiagonale(int n){
        int[][] tabrangée =new int[n][n];
        remplirCetteMatriceEnDiagonale(tabrangée);
        return tabrangée;
    }
}
