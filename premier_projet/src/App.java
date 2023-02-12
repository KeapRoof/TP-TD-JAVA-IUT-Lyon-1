class App {
    public static void main(String[] args) throws Exception {
        System.out.println("L'imposition est de " + impot(57000) + " euros");
        exo3('a');
    }


    public static void exo1(){
        int Somme = 0;
        for (int i = 1; i <= 100; i++) {
            Somme = Somme + i;
        }
        System.out.println(Somme);
    }
    
    public static double impot (double revenu){
        double resultat = 0;
        if (revenu <= 20000){
            resultat = revenu * 0.05;
            return resultat;
        }
        else if(revenu <= 40000){
            resultat = (revenu - 20000) * 0.1 + 1000;
            return resultat;
        }
        else if(revenu <= 60000){
            resultat = (revenu - 40000) * 0.15 + 3000;
            return resultat;
        }
        else{
            resultat = (revenu - 60000) * 0.3 + 1000;
            return resultat;
        }
    }

    public static void exo3(char c){
            // cas (normal) minuscule --> majuscule
            if (c >= 'a' && c <= 'z') {
                char majuscule = (char)(c - 32);
                System.out.println("Le caractère majuscule correspondant à " + c + " est " + majuscule);
            }
            // Cas (normal) majuscule --> minuscule
            else if (c >= 'A' && c <= 'Z'){
                char minuscule = (char)(c + 32);
                System.out.println("Le caractère minuscule correspondant à " + c + " est " + minuscule);
            }
            // cas (special) majuscule --> minuscule
            else if (c >= '\u00E0' && c <= '\u00FF'){
                int decalage = 'A' - 'a';
                char majuscule = (char)(c + decalage);
                System.out.println("Le caractère minuscule correspondant à " + c + " est " + majuscule);
            }
            // cas (special) minuscule --> majuscule
            else if (c >= '\u00C0' && c <= '\u00FF'){
                int decalage = 'a' - 'A';
                char minuscule = (char)(c + decalage);
                System.out.println("Le caractère minuscule correspondant à " + c + " est " + minuscule);
            }
            // cas ou ce n'est pas un caractère
            else{
                System.out.println(c + " n'est pas une lettre");
            }
    }
}
