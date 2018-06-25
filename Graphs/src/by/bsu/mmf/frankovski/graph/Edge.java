package by.bsu.mmf.frankovski.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"head", "tail", "weight"})
public class Edge {
    private Node head;
    private Node tail;
    private int weight;
    private String name;
}
