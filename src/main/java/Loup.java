public class Loup extends Entite {

    public Loup(int x, int y) {
        super("loup", x, y);
        this.vitesse = 3;
    }

    @Override
    public void deplacer(Case[][] labyrinthe) {
        // À implémenter : poursuite du mouton s’il est visible
    }
}
