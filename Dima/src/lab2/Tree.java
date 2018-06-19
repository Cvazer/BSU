package lab2;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Branch> branches;

    public Tree() {
        branches = new ArrayList<>();
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
