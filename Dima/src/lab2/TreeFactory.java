package lab2;

import java.util.Random;

public class TreeFactory {
    private static final int BRANCHES_SEED = 10;
    private static final int LEAVES_MILTIPLYER_SEED = 2;

    public static Tree getTree(){
        Random random = new Random();
        Tree tree = new Tree();
        for (int i = 0; i < random.nextInt(BRANCHES_SEED+1); i++) {
            tree.getBranches().add(new Branch());
        }
        tree.getBranches().forEach(branch -> {
            for (int i = 0; i < random.nextInt(tree.getBranches().size()*LEAVES_MILTIPLYER_SEED+1); i++) {
                branch.getLeaves().add(new Leaf());
            }
        });
        return tree;
    }
}
