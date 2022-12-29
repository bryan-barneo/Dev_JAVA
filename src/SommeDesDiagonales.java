public class SommeDesDiagonales {
    public static int sommeDesDiagonales(int[][] P){
        int lignes= P.length;
        int rt = 0;
        int a = P.length-1;
        for(int i = 0; i < lignes; i++){
            rt+=P[i][i];
        }
        for(int i = 0;i < lignes; i++){
            rt+=P[a][i];
            a--;
        }
        if(lignes % 2 == 1){
            rt-=P[lignes/2][lignes/2];
        }
        return rt;
    }
}
