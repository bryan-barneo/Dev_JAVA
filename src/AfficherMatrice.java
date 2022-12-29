public class AfficherMatrice {
    public static void afficherMatrice(int[][] M){
        for (int i=0;i<M.length;i++){ /* i représente le nombre de ligne */
            for (int j=0;j<M[0].length;j++){ /* J représente le nombre de colonne */
                System.out.print(M[i][j]+" "); /* Affiche le tableau avec i nombre de lignes et J nombre de colone*/
            }
            System.out.println(); /* Permet de sauter la ligne entre la 2 et la 3 valeurs.*/
        }
    }
}
