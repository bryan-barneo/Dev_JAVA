public class RelationBinaire {
    public boolean[][] matAdj;  // matrice d'adjacence de R
    public EE[] tabSucc;    // tableau des ensembles de successeurs
    private int n;           // n > 0, E = {0,1,2, ..., n-1}
    private int m;           // cardinal de R

    //.........................................................................
    // CONSTRUCTEURS
    //.........................................................................
    //________________________________________________________
    public RelationBinaire(int nb){
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
    }

    //________________________________________________________
    public RelationBinaire(int nb,double p){
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
        double r;
        for (int i=0;i<this.n;i++) {
            for (int j=0;j<this.n;j++){
                r=Math.random();
                if (r<=p){
                    this.matAdj[i][j]=true;
                    this.tabSucc[i].ajoutPratique(j);
                    this.m++;
                }
            }
        }
    }

    //________________________________________________________
    public RelationBinaire(int nb, boolean egal){
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
        if(egal){
            for (int i=0;i<nb ;i++ ) {
                this.matAdj[i][i]=true;
                this.tabSucc[i].ajoutPratique(i);
                this.m++;
            }
        }
        else{
            for (int i=0;i<nb ;i++ ) {
                for (int j=0;j<nb ;j++ ) {
                    if(i<=j){
                        this.matAdj[i][j]=true;
                        this.tabSucc[i].ajoutPratique(j);
                        this.m++;
                    }
                }
            }
        }
    }

    //________________________________________________________
    public RelationBinaire(boolean[][] mat){
        int nb=mat.length;
        this.n=nb;
        this.matAdj=new boolean[nb][nb] ;
        this.m=0;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(nb);
        }
        for (int i=0;i<nb ;i++ ) {
            for (int j=0;j<nb ;j++ ) {
                if(mat[i][j]){
                    this.matAdj[i][j]=true;
                    this.tabSucc[i].ajoutPratique(j);
                    this.m++;
                }
            }
        }
    }

    //________________________________________________________
    public RelationBinaire(EE[] tab){
        this(tab.length);
        int compteur = this.n;
        for (int i = 0; i < compteur; i++) {
            for (int j = 0; j < compteur; j++) {
                if (tab[i].contient(j)) {
                    this.matAdj[i][j] = true;
                    this.tabSucc[i].ajoutPratique(j);
                    this.m++;
                }
            }
        }
    }
    //________________________________________________________
    public RelationBinaire(RelationBinaire r){
        this.n = r.n;
        this.m = r.m;
        int nb=this.n;
        this.matAdj=new boolean[nb][nb] ;
        this.tabSucc=new EE[nb];
        for (int i=0;i<nb ;i++ ) {
            this.tabSucc[i]=new EE(r.tabSucc[i]);
        }
        for (int i=0;i<nb;i++){
            for (int j=0;j<nb;j++){
                this.matAdj[i][j]=r.matAdj[i][j];
            }
        }

    }
    //______________________________________________
    //.........................................................................
    // M??thodes
    //.........................................................................
    public String toString(){
        int nb=this.n;
        String res="";
        for (int i=0;i<nb ;i++ ) {
            res+="{";
            for (int j=0;j<nb ;j++ ) {
                if(this.matAdj[i][j]){
                    if(j==0){
                        res+="1";
                    }
                    else{
                        res+=",1";
                    }
                }
                else{
                    if(j==0){
                        res+="0";
                    }
                    else{
                        res+=",0";
                    }
                }
            }
            res+="}\n";
        }
        res+="\n{";
        boolean premier=true;
        for (int i=0;i<nb ;i++ ) {
            for (int j=0;j<nb ;j++ ){
                if(this.tabSucc[i].contient(j)){
                    if(premier)res+="(";
                    else{
                        res+=",(";
                    }
                    res+=i+","+j+")";
                    premier=false;
                }
            }
        }
        res+="}";
        return res;
    }
    //________________________________________________________

    //.........................................................................
    // A) Logique et calcul matriciel
    //.........................................................................

    //________________________________________________________
    public static boolean[][] opBool(boolean[][] m1, boolean[][] m2, int numConnecteur){
        boolean [][] MatB=new boolean[m1.length][m1.length];
        for (int i=0;i<m1.length ;i++ ) {
            for (int j=0;j<m1.length ;j++ ) {
                if(numConnecteur==1){
                    if(m1[i][j] || m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else if(numConnecteur==2){
                    if(m1[i][j] && m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else if(numConnecteur==3){
                    if(!m1[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else if(numConnecteur==4){
                    if(!m1[i][j] || m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }
                else {
                    if(m1[i][j]==m2[i][j])MatB[i][j]=true;
                    else MatB[i][j]=false;
                }

            }

        }
        return MatB;
    }
    //________________________________________________________
   public static boolean[][] produit(boolean[][] m1, boolean[][] m2) {
        boolean[][] r??sultat = new boolean[m1.length][m1.length];
        boolean valeur=false;
        for (int i=0;i<m1.length ;i++ ) {
            for (int j=0;j<m1.length;j++ ) {
                valeur=false;
                for (int x=0;x<m1[0].length ; x++) {
                    valeur=valeur || (m1[i][x] && m2[x][j]);
                }
                r??sultat[i][j]=valeur;
            }
        }
        return r??sultat;
    }
    //________________________________________________________
    public static boolean[][] transposee(boolean[][] m) {
        boolean[][] r??sultat = new boolean[m.length][m.length];
        for(int i = 0; i <= m.length-1; i ++){
            for(int j = 0; j <= m.length-1; j++){
                r??sultat[j][i] = m[i][j];
            }
        }
        return r??sultat;
    }
    //______________________________________________
    //.........................................................................
    // B) Th??ories des Ensembles
    //.........................................................................
    //______________________________________________
    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est vide
     */
    public boolean estVide() {
        if (this.m==0) return true;
        return false;
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est pleinee (contient tous les couples d'??l??ments de E)
     */
    public boolean estPleine(){
        if(this.m==this.n*this.n) return true;
        return false;
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi (x,y) appartient ?? this
     */
    public boolean appartient(int x, int y) {
        return this.matAdj[x][y];
    }

    //______________________________________________

    /**
     * pr??-requis : 0 <= x < this.n et 0 <= y < this.n
     * r??sultat : ajoute (x,y) ?? this s'il n'y est pas d??j??
     */
    public void ajouteCouple(int x, int y) {
        if(!this.matAdj[x][y]){
            this.matAdj[x][y] = true;
            this.tabSucc[x].ajoutElt(y);
            this.m++;
        }
    }

    //______________________________________________

    /**
     * pr??-requis : 0 <= x < this.n et 0 <= y < this.n
     * r??sultat : enl??ve (x,y) de this s'il y est
     */
    public void enleveCouple(int x, int y) {
        if(this.matAdj[x][y]){
            this.matAdj[x][y] = false;
            this.tabSucc[x].retraitElt(y);
            this.m--;
        }
    }
    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : une nouvelle relation binaire obtenue ?? partir de this en ajoutant
     * les couples de la forme  (x,x) qui n'y sont pas d??j??
     */
    public RelationBinaire avecBoucles(){
        RelationBinaire Boucles = new RelationBinaire(this);
        for (int i=0;i<this.n ;i++ ) {
            if(!this.matAdj[i][i]){
                Boucles.ajouteCouple(i,i);
            }
        }
        return Boucles;
    }
    public RelationBinaire avecBouclesBis(){
        return new RelationBinaire(opBool(new RelationBinaire(this.n,true).matAdj,this.matAdj,1));
    }
    //______________________________________________


    /** pr??-requis : aucun
     r??sultat : une nouvelle relation binaire obtenue ?? partir de this en enl??vant
     les couples de la forme  (x,x) qui y sont
     //DERNIERE MODIF
     */
    public RelationBinaire sansBoucles(){
        RelationBinaire Boucles = new RelationBinaire(this);
        for (int i=0;i<this.n ;i++ ) {
            if(this.matAdj[i][i]){
                Boucles.enleveCouple(i,i);
            }
        }
        return Boucles;
    }
    public RelationBinaire sansBouclesBis(){
        return new RelationBinaire(opBool(opBool(this.matAdj,new RelationBinaire(this.n,true).matAdj, 4),this.matAdj,3));
    }

    //______________________________________________

    /**
     * pr??-requis : this.n = r.n
     * r??sultat : l'union de this et r
     */
    public RelationBinaire union(RelationBinaire r){
        return new RelationBinaire(opBool(this.matAdj,r.matAdj,1));
    }

    //______________________________________________

    /**
     * pr??-requis : this.n = r.n
     * r??sultat : l'intersection de this et r
     */
    public RelationBinaire intersection(RelationBinaire r) {
       return new RelationBinaire(opBool(this.matAdj,r.matAdj, 2));
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : la relation compl??mentaire de this
     */
    public RelationBinaire complementaire(){
        return new RelationBinaire(opBool(this.matAdj,new RelationBinaire(this.n).matAdj,3));
    }

    //______________________________________________

    /**
     * pr??-requis : this.n = r.n
     * r??sultat : la diff??rence de this et r
     */
    public RelationBinaire difference(RelationBinaire r){
        boolean[][] mat1 = new boolean[this.n][this.n];
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                if (this.matAdj[i][j] && !r.matAdj[i][j]) {
                    mat1[i][j] = true;
                }
            }
        }
        return new RelationBinaire(mat1);
    }
    public RelationBinaire differenceBis(RelationBinaire r){
        return this.intersection(r).complementaire().intersection(this);
    }

    //______________________________________________

    /**
     * pr??-requis : this.n = r.n
     * r??sultat : vrai ssi this est incluse dans r
     */
    public boolean estIncluse(RelationBinaire r) {
        return new RelationBinaire(opBool(this.matAdj,r.matAdj, 4)).estPleine();
    }

    //______________________________________________


    // C) Th??orie des graphes orient??s
    //---------------------------------

    /**
     * pr??-requis : this.n = r.n
     * r??sultat : vrai ssi this est ??gale ?? r
     */
    public boolean estEgale(RelationBinaire r) {
        return new RelationBinaire(opBool(this.matAdj,r.matAdj, 5)).estPleine();
    }

    //______________________________________________

    /**
     * pr??-requis : 0 <= x < this.n
     * r??sultat : l'ensemble des successeurs de x dans this, "ind??pendant"
     * (c'est-??-dire dans une autre z??ne m??moire) de l'attribut this.tabSucc
     */
    public EE succ(int x){
        return new EE(this.tabSucc[x]);
    }

    //______________________________________________


    /** pr??-requis : 0 <= x < this.n
     r??sultat : l'ensemble des pr??d??cesseurs de x dans this
     */
    public EE pred(int x){
        EE newE=new EE(this.n);
        for (int i=0;i<this.n ;i++ ) {
            if(this.tabSucc[i].contient(x))newE.ajoutElt(i);
        }
        return newE;
    }
    public EE predBis(int x){
        return new RelationBinaire(transposee(this.matAdj)).succ(x);
    }

    //______________________________________________


    // D) Relation binaire
    //---------------------
    
    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est r??flexive
     */
    public boolean estReflexive() {
        boolean Reflexive=true;
        int i = 0;
        while (i< this.n && Reflexive){
            if (!matAdj[i][i]){
                Reflexive = false;
            }
            i++;
        }
        return Reflexive;
    }
    public boolean estReflexiveBis(){
        return this.estEgale(this.avecBoucles());
    }
    //______________________________________________


    /** pr??-requis : aucun
     r??sultat : vrai ssi this est antir??flexive
     */
    public boolean estAntireflexive() {
        boolean AReflexive=true;
        int i = 0;
        while (i< this.n && AReflexive){
            if (matAdj[i][i]){
                AReflexive = false;
            }
            i++;
        }
        return AReflexive;
    }
    public boolean estAntireflexiveBis(){
        return this.estEgale(this.sansBoucles());
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est sym??trique
     */
    public boolean estSymetrique() {
        boolean Symetrique = true;
        int i = 0;
        int j = 0;
        while (i< this.n && Symetrique){
            while(j< this.n && Symetrique){
                if (this.matAdj[i][j] != this.matAdj[j][i]){
                    Symetrique = false;
                }
                j++;
            }
            i++;
        }
        return Symetrique;
    }
   public boolean estSymetriqueBis() {
        return new RelationBinaire(transposee(this.matAdj)).estEgale(this);
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est antisym??trique
     */
    public boolean estAntisymetrique() {
        boolean ASymetrique = true;
        int i = 0;
        int j = 0;
        while (i< this.n && ASymetrique){
            while(j< this.n && ASymetrique){
                if (this.matAdj[i][j] && this.matAdj[j][i]){
                    ASymetrique = false;
                }
                j++;
            }
            i++;
        }
        return ASymetrique;
    }
    public boolean estAntisymetriqueBis() {
        return new RelationBinaire(opBool(this.matAdj,transposee(this.sansBoucles().matAdj), 2)).estVide();
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est transitive
     */
    public boolean estTransitive() {
        boolean trans=true;
        int i=0;
        EE s;
        while(i<this.n && trans){
            s=this.succ(i);
            int x=0;
            while(x<this.n && trans) {
                if(s.contient(x)){
                    if(!tabSucc[x].estInclus(s)){
                        trans=false;
                    }
                }
                x++;
            }
            i++;
        }
        return trans;
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : vrai ssi this est une relation d'ordre
     */
    public boolean estRelOrdre() {
        return this.estTransitive() && this.estAntisymetrique() && this.estReflexive();
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : la relation binaire assici??e au diagramme de Hasse de this
     */
    public RelationBinaire hasse() {
        throw new RuntimeException("La fonction n'est pas encore impl??ment??e !");
    }
    //______________________________________________

    /**
     * pr??-requis : aucun
     * r??sultat : la fermeture transitive de this
     */
    public RelationBinaire ferTrans() {
        RelationBinaire trans=new RelationBinaire(this);
        EE s;
        EE s2;
        for (int i=0;i<trans.n ;i++ ) {
            for (int x=0;x<trans.n ;x++ ) {
                s=trans.succ(i);
                if(s.contient(x)){
                    s2=trans.succ(x);
                    for (int j=0;j<trans.n ;j++ ) {
                        if(s2.contient(j) && !s.contient(j)){
                            s.ajoutElt(j);
                            trans.tabSucc[i].ajoutElt(j);
                            trans.m++;
                            trans.matAdj[i][j]=true;
                        }
                    }
                }
            }
        }
        return trans;
        
    }

    //______________________________________________

    /**
     * pr??-requis : aucun
     * action : affiche this sous 2 formes (matrice et ensemble de couples), puis affiche ses propri??t??s
     * (r??flexive, ..., relation d'ordre) et les relations binaires suivantes obtenues ?? partir de this :
     * Hasse, fermeture transitive de Hasse et fermeture transitive de Hasse avec boucles (sous 2 formes aussi)
     */
    public void afficheDivers() {
        System.out.println(this);
        if(this.estReflexive()){
            System.out.println("La Relation Binaire est : r??flexive");
        }
        if(this.estAntireflexive()){
            System.out.println("La Relation Binaire est : antir??flexive");
        }
        if(this.estSymetrique()){
            System.out.println("La Relation Binaire est : Sym??trique");
        }
        if(this.estAntisymetrique()){
            System.out.println("La Relation Binaire est : r??flexive");
        }
        if(this.estTransitive()){
            System.out.println("La Relation Binaire est : transitive");
        }
        if(this.estRelOrdre()){
            System.out.println("La Relation Binaire est : Une relation d'ordre");
        }
        System.out.println("La Fermeture transitive de la Relation binaire est : ");
        System.out.println(this.ferTrans());
    }
    public static void main(String[] args) {

        int nb;
        double p;
        do {
            Ut.afficher("\nDonner le cardinal de E (>0) : ");
            nb = Ut.saisirEntier();
        }
        while (nb <= 0);
    }

    //______________________________________________
} // fin RelationBinaire
