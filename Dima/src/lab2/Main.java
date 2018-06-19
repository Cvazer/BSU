package lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree tree = TreeFactory.getTree();
        System.out.println("У дерева "+tree.getBranches().size()+" веток");
        for (int i = 0; i < tree.getBranches().size(); i++) {
            System.out.println("На ветке "+(i+1)+": "+tree.getBranches().get(i).getLeaves().size()+" листев.");
        }
        tree.getBranches().forEach(Branch::blossom);
        tree.getBranches().forEach(branch -> branch.getLeaves().forEach(Leaf::changeColor));
        tree.getBranches().forEach(branch -> branch.getLeaves().forEach(Leaf::freez));
        tree.getBranches().forEach(branch -> branch.getLeaves().forEach(Leaf::fall));
    }
}
