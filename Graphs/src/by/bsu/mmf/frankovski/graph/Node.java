package by.bsu.mmf.frankovski.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"edges"})
public class Node {
    private List<Edge> edges = new ArrayList<>();
    private String name;

    public Node(String name) {
        this.name = name;
    }
}
