public class TesteurPourIlExisteUneLigneAvecPlusieursZeros {
    public static void main(String[] args){
        int[][] P={{1,2},{3,4}};
        boolean a=IlExisteUneLigneAvecPlusieursZeros.ilExisteUneLigneAvecPlusieursZeros(P);

        int[][] Q={{1,2,3},{4,0,0},{7,8,9}};
        boolean b=IlExisteUneLigneAvecPlusieursZeros.ilExisteUneLigneAvecPlusieursZeros(Q);

        int[][] R={{1,0,3},{4,0,2}};
        boolean r=IlExisteUneLigneAvecPlusieursZeros.ilExisteUneLigneAvecPlusieursZeros(R);

        if (!a && b && !r)
            System.exit(0);// OK
        else
            System.exit(1);// ÉCHEC
    }
}
