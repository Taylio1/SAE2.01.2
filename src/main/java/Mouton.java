import java.util.HashMap;
import java.util.Map;

public class Mouton extends Entite {
    private Map<String, Integer> vegetauxManges;

    public Mouton(int x, int y) {
        super("mouton", x, y);
        this.vitesse = 2;
        vegetauxManges = new HashMap<>();
        vegetauxManges.put("herbe", 0);
        vegetauxManges.put("marguerite", 0);
        vegetauxManges.put("cactus", 0);
    }

    public void manger(String typeVegetal) {
        vegetauxManges.put(typeVegetal, vegetauxManges.get(typeVegetal) + 1);
        switch (typeVegetal) {
            case "herbe":
                vitesse = 2;
                break;
            case "marguerite":
                vitesse = 4;
                break;
            case "cactus":
                vitesse = 1;
                break;
        }
    }

    @Override
    public void deplacer(Case[][] labyrinthe) {
        // À implémenter plus tard : logique de déplacement intelligent
    }

    public Map<String, Integer> getVegetauxManges() {
        return vegetauxManges;
    }
}
