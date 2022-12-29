public class SontÉgales {
    public static boolean sontÉgales (int[][] P, int[][] Q){
        int nbDifferents = 0;
        int a = P.length;
        int b = P[0].length;
        boolean sontEgales = true;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (P[i][j] != Q[i][j]) {
                    nbDifferents++;
                }
            }
            if (nbDifferents > 0) {
                sontEgales= false;
            }
        }
        return sontEgales;
    }
}
