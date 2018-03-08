package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DfsIteratorGraph extends AbstractIterator {
    private Stack<Node> stack = new Stack<>();

    public DfsIteratorGraph(Graph graph, Node startNode) {
        super(graph, startNode);
        this.stack.push(startNode);
    }

    @Override
    public Node getNextNode() {
        return this.stack.pop();
    }

    @Override
    public void addNeighbor(Node n) {
        this.stack.push(n);
    }

    @Override
    public boolean hasNextElement() {
        return !this.stack.isEmpty();
    }


}
