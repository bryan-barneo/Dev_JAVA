public class NumérationRomaine {
    /**
     * Donnée : un entier n
     * Résultat :Convertis ce chiffre n en chiffres Romain, avec un espace entre les chiffres
     */
    public static String unités(int n){
        String Carac= "I";
        String ValeursRomains = "";
        for(int i = 0; i < n; i++){
            if(i == 3){
                ValeursRomains = ValeursRomains.replace("III", "IV");
            }
            else if(i == 4){
                ValeursRomains = ValeursRomains.replace("IV", "V");
            }
            else if(i == 8){
                ValeursRomains = ValeursRomains.replace("VIII", "IX");
            }
            else{
                ValeursRomains += Carac;
            }
        }
        return ValeursRomains;
    }
    /**
     * Donnée : une unités entre 1 et 9;
     * Résultat : la même unite ecrit sous forme de chiffres romains.
     */
  public static String dizaines(int n){
      String Carac= "X"; //10
      String ValeursRomains = "";
      for(int i = 0; i < n; i++){
          if(i == 3){
              ValeursRomains = ValeursRomains.replace("XXX", "XL");
          }
          else if(i == 4){
              ValeursRomains = ValeursRomains.replace("XL", "L");
          }
          else if(i == 8){
              ValeursRomains = ValeursRomains.replace("LXXX", "XC");
          }
          else{
              ValeursRomains += Carac;
          }
      }
      return ValeursRomains;
  }
    /**
     * Donnée : un dizaines rentré (uniquement avec comme unités = 0)
     * Résultat : la même dizaines ecrit en chiffres romains
     */
    public static String centaines(int n){
        String Carac= "C"; //100
        String ValeursRomains = "";
        for(int i = 0; i < n; i++){
            if(i == 3){
                ValeursRomains = ValeursRomains.replace("CCC", "CD");
            }
            else if(i == 4){
                ValeursRomains = ValeursRomains.replace("CD", "D");
            }
            else if(i == 8){
                ValeursRomains = ValeursRomains.replace("DCCC", "CM");
            }
            else{
                ValeursRomains += Carac;
            }
        }
        return ValeursRomains;
    }
    /**
     * Donnée : un entier n<=999
     1
     * Résultat : affiche n en chiffres Romain, avec un espace entre les chiffres
     */
    public static void afficher(int n){
    }
}
