package by.bsu.mmf.frankovski.graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class GreedyPathFinder {
    private List<Node> viseted = new ArrayList<>();
    private Graph graph;

    public GreedyPathFinder(Graph graph) {
        this.graph = graph;

    }

    public void calculate(){
        getPath(graph.getNodes().get(0));
        viseted.forEach(node -> System.out.print(node.getName()+" -> "));
        System.out.println(viseted.get(0).getName());
    }

    public void getPath(Node node){
        viseted.add(node);
        if (viseted.size()==graph.getNodes().size()){return;}
        List<Node> children = GraphUtils.getChildrenOfNode(node);
        children.removeAll(viseted);
        AtomicReference<Node> min = new AtomicReference<>(children.get(0));
        Edge minEdgeC = children.get(0).getEdges().get(0);
        Map<Node, Edge> minimal = new HashMap<>();
        for (Node child: children){
            Edge minEdge = child.getEdges().get(0);
            for (Edge edge: child.getEdges()){if (edge.getWeight()<minEdge.getWeight()){minEdge = edge;}}
            minimal.put(child, minEdge);
        }
        minimal.forEach((node1, edge) -> {
            if (edge.getWeight()<minEdgeC.getWeight()){min.set(node1);}
        });
        getPath(min.get());
    }
}
