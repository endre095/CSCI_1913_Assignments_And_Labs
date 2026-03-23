public abstract class Greeter {
    private string name;

    public Greeter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void greet();
}