package lab2;

public class Leaf {
    private String color = "GREEN";

    public Leaf() {}

    public Leaf(String color) {
        this.color = color;
    }

    public void freez(){
        System.out.println("Лист покрылся инеем...");
    }

    public void changeColor(){
        System.out.println("Лист пожелтел...");
    }

    public void fall(){
        System.out.println("Лист падает...");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
