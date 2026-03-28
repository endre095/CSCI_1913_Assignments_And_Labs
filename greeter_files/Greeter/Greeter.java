public abstract class Greeter {
    private String name;

    public Greeter(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void greet();
}