package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BfsIteratorGraph extends AbstractIterator {
    private LinkedList<Node> file = new LinkedList<>();

    public BfsIteratorGraph(Graph graph,Node startNode) {
        super(graph, startNode);
        this.file.add(startNode);
    }

    @Override
    public Node getNextNode() {
        return this.file.pop();
    }

    @Override
    public void addNeighbor(Node n) {
        this.file.add(n);
    }

    @Override
    public boolean hasNextElement() {
        return !this.file.isEmpty();
    }
}
