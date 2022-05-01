public abstract class Animal {
    private String animalName;
    private String type;

    public Animal(String name, String type) {
        this.animalName = name;
        this.type = type;
    }

    public String getName() {
        return animalName;
    }

    public String getType() {
        return type;
    }
}
