public class Additionner {
    public static int[][] additionner(int P[][], int[][] Q) {
        int a=P.length; /* récupère le nombre de colonnes de P est le met dans la variable a */
        int b=P[0].length; /* récupère le nombre de ligne de P est le met dans la variable b */
        int [][] tab=new int [a][b];
        for (int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                tab[i][j]=P[i][j]+Q[i][j];
            }
        }
        return tab;
    }
}

