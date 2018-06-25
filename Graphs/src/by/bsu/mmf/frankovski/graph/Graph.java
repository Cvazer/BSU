package by.bsu.mmf.frankovski.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graph {
    private List<Node> nodes = new ArrayList<>();

    public List<Edge> getAllEdges(){
        Set<Edge> edges = new HashSet<>();
        for (Node node: nodes){edges.addAll(node.getEdges());}
        return edges.stream().distinct().sorted(Comparator.comparing(Edge::getName)).collect(Collectors.toList());
    }

    public int[][] getMatrix(){
        List<Edge> edges = getAllEdges();
        List<Node> nodes = this.nodes.stream().sorted(Comparator.comparing(Node::getName)).collect(Collectors.toList());
        int[][] matrix = new int[edges.size()][nodes.size()];
        for (int i = 0; i < matrix.length; i++) {
            int[] nodeIndexes = new int[nodes.size()];
            Edge edge = edges.get(i);
            for (int j = 0; j < nodeIndexes.length; j++) {
                if (nodes.get(j).getEdges().contains(edge)){
                    nodeIndexes[j] = edge.getWeight();
                } else {
                    nodeIndexes[j] = 0;
                }
            }
            matrix[i] = nodeIndexes;
        }
        return matrix;
    }
}
