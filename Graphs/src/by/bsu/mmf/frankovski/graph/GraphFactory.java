package by.bsu.mmf.frankovski.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphFactory {
    public static final int MAX_NODES = 4;
    public static final int MAX_EDGE_WEIGHT = 100;
    private static int edge_count = 1;
    private static int node_count = 1;

    public static Graph getGraph(){
        Graph graph = new Graph();

        for (int i = 0; i < MAX_NODES; i++) {
            graph.getNodes().add(new Node("x"+getNextNodeCount()));
        }

        List<Edge> allEdges = new ArrayList<>();
        Random random = new Random();

        graph.getNodes().forEach(node -> {
            graph.getNodes().forEach(otherNode -> {
                if (isEdgeAlreadyExists(node, otherNode, allEdges)){return;}
                if (node.equals(otherNode)){return;}
                Edge edge = new Edge(node, otherNode, random.nextInt(MAX_EDGE_WEIGHT), "e"+getNextEdgeCount());
                allEdges.add(edge);
                node.getEdges().add(edge);
                otherNode.getEdges().add(edge);
            });
        });

        return graph;
    }

    public static boolean isEdgeAlreadyExists(Node n1, Node n2, List<Edge> allEdges){
        Edge resultEdge = null;
        for (Edge edge: allEdges){
            if (edge.getTail().equals(n1) && edge.getHead().equals(n2)){resultEdge = edge; break;}
            if (edge.getTail().equals(n2) && edge.getHead().equals(n1)){resultEdge = edge; break;}
        }
        return (resultEdge==null)?false:true;
    }

    public static int getNextEdgeCount(){
        int next = edge_count;
        edge_count++;
        return next;
    }

    public static int getNextNodeCount(){
        int next = node_count;
        node_count++;
        return next;
    }
}
