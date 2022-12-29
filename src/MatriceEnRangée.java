public class MatriceEnRangée {
    public static void remplirCetteMatriceEnRangée(int[][] n){
        int nbLignes = n.length;
        int nbColonnes = n[0].length;
        for (int i = 0; i < nbLignes; i++){
            for (int j = 0; j < nbColonnes; j++){
                n[i][j] = 0;
            }
        }
        int x = 1;
        for (int i = 0; i < nbLignes; i++){
            for (int j = 0; j < nbColonnes; j++){
                n[i][j] = x;
                x++;
            }
        }
    }
    public static int[][] nouvelleMatriceEnRangée(int n){
        int x=1;
        int[][] tabrangée =new int[n][n];
        remplirCetteMatriceEnRangée(tabrangée);
        return tabrangée;
    }
   // public static void main(String[] args) {
     //   int[][] n = {{1, 2, 5}, {4, 5, 8}, {7, 10, 9}};
       // MatriceEnRangée.remplirCetteMatriceEnRangée(n);
        //AfficherMatrice.afficherMatrice(n);

    //}
}
