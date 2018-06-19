package lab2;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private List<Leaf> leaves;

    public Branch() {
        leaves = new ArrayList<>();
    }

    public void blossom(){
        System.out.println("Ветка цветет...");
    }

    public List<Leaf> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leaf> leaves) {
        this.leaves = leaves;
    }
}
