public class Labyrinthe {
    private int largeur, hauteur;
    private Case[][] cases;
    private Mouton mouton;
    private Loup loup;
    private int sortieX, sortieY;

    public Labyrinthe(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cases = new Case[hauteur][largeur];

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                cases[i][j] = new Case("vide");
            }
        }
    }

    public void placerSortie(int x, int y) {
        sortieX = x;
        sortieY = y;
    }

    public void placerMouton(Mouton mouton) {
        this.mouton = mouton;
    }

    public void placerLoup(Loup loup) {
        this.loup = loup;
    }

    public Case[][] getCases() {
        return cases;
    }


}
