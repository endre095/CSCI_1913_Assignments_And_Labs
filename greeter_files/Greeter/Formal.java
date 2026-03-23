public class Formal {
    private String title;

    public Formal(String title, String name) {
        super(name);
        this.title = title;
    }


    @Override 
    public String getName() {
        return this.title + " " + super.getName();
    }

    public void greet() {
        System.out.println("Good day, " + this.getName() + ".");
    }
}
