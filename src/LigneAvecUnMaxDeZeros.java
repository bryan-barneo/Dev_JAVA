public class LigneAvecUnMaxDeZeros {
    public static int ligneAvecUnMaxDeZeros(int[][] M) {
        int ligne = 0;
        int maxZeros = 0;
        int nbZeros = 0;
        int a = M.length;
        int b = M[0].length;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (M[i][j] == 0) {
                    nbZeros++;
                }
            }
            if (nbZeros > maxZeros) {
                maxZeros = nbZeros;
                ligne = i;
            }
        }
        return ligne;
    }
}