public class Informal extends Greeter{
    
    public Informal(String name) {
        super(name);
    }

    public String toString() {
        return "What's up, " + getName() + "?";
    }

    public void greet() {
        System.out.println(this.toString());
    }
}


