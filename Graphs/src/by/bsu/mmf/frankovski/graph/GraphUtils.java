package by.bsu.mmf.frankovski.graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class GraphUtils {

    public static void printGraphMatrix(Graph graph){
        int[][] matrix = graph.getMatrix();
        String[] names = new String[graph.getNodes().size()];
        for (int i = 0; i < graph.getNodes().size(); i++) {
            names[i] = graph.getNodes().get(i).getName();
        }
        System.out.print("   ");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("e"+(i+1)+" ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(((matrix[i][j]<10)?" "+matrix[i][j]: matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static List<Node> getChildrenOfNode(Node node) {
        Set<Node> children = new HashSet<>();
        node.getEdges().forEach(edge -> {
            children.add(edge.getTail());
            children.add(edge.getHead());
        });
        children.remove(node);
        return children.stream().distinct().collect(Collectors.toList());
    }

}
