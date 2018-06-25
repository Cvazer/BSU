package by.bsu.mmf.frankovski.graph;

import java.util.ArrayList;
import java.util.List;

public class FullSwitchPathFinder {
    private List<Node> viseted = new ArrayList<>();
    private Graph graph;

    public FullSwitchPathFinder(Graph graph) {
        this.graph = graph;
    }

    public void calculate(){
        getPath(graph.getNodes().get(0));
        viseted.forEach(node -> System.out.print(node.getName()+" -> "));
        System.out.println(viseted.get(0).getName());
        viseted.clear();
    }

    private void getPath(Node node) {
        viseted.add(node);
        if (viseted.size()==graph.getNodes().size()){return;}
        List<Node> children = GraphUtils.getChildrenOfNode(node);
        children.removeAll(viseted);
    }
}
