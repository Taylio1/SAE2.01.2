public class Case {
    private String type;

    public Case(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean estObstacle() {
        return type.equals("rocher");
    }

    public boolean estVegetal() {
        return type.equals("herbe") || type.equals("marguerite") || type.equals("cactus");
    }
}
