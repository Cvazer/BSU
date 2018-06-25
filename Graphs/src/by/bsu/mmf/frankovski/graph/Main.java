package by.bsu.mmf.frankovski.graph;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Graph graph = GraphFactory.getGraph();
        GraphUtils.printGraphMatrix(graph);
        System.out.println();
        GreedyPathFinder pathFinder = new GreedyPathFinder(graph);
        pathFinder.calculate();
//        System.out.println();
//        GraphUtils.getPathByFullLookup(graph);
    }
}
