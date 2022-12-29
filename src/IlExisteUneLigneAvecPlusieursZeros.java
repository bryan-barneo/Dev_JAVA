public class IlExisteUneLigneAvecPlusieursZeros {
    public static boolean ilExisteUneLigneAvecPlusieursZeros(int[][] M) {
        int nbZeros = 0;
        int a = M.length;
        int b = M[0].length;
        int i = 0;
        int j = 0;
        boolean PlusieursZeros = false;
        while (i < a) {
            if (M[i][j] == 0) {
                nbZeros++;
            }
            if (j < b - 1) {
                j++;
            } else {
                i = i + 1;
                j = 0;
            }
            if (nbZeros > 1) {
                PlusieursZeros = true;
            }
        }
        return PlusieursZeros;
    }
}
