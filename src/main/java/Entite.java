public abstract class Entite {
    protected String nom;
    protected int x, y;
    protected int vitesse;
    protected int vision = 5; // Manhattan

    public Entite(String nom, int x, int y) {
        this.nom = nom;
        this.x = x;
        this.y = y;
    }

    public abstract void deplacer(Case[][] labyrinthe);

    public int distance(Entite autre) {
        return Math.abs(x - autre.x) + Math.abs(y - autre.y);
    }

    // Getters et setters...
}
