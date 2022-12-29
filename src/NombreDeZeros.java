public class NombreDeZeros {
    public static int nombreDeZeros(int[][] P) {
        int l = P.length;
        int c = P[0].length;
        int nombreZero = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (P[i][j] == 0) {
                    nombreZero++;
                }
            }
        }
        return nombreZero;
    }
}