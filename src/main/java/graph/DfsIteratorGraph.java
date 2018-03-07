package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DfsIteratorGraph implements Iterator<Node> {
    private Stack<Iterator<Node>> stack = new Stack<>();
    private ArrayList<Node> sommetsConsultes = new ArrayList<>();
    private Node nextNode;
    private Graph graph;

    public DfsIteratorGraph(Graph graph,Node startNode) {
        this.stack.push(graph.getAdjNodes(startNode).iterator());
        this.nextNode = startNode;
        this.graph=graph;
    }

    @Override
    public boolean hasNext() {

        return this.nextNode != null;
    }

    @Override
    public Node next() {
        if (!hasNext())
            throw new NoSuchElementException();
        try {
            this.sommetsConsultes.add(this.nextNode);
            return this.nextNode;
        } finally {
            this.increment();
        }

    }

    private void increment() {
        Iterator<Node> neighborNodeIterator = this.stack.peek();
        do {
            while (!neighborNodeIterator.hasNext()) {
                this.stack.pop();
                if (this.stack.isEmpty()) {
                    this.nextNode = null;
                    return;
                }
                neighborNodeIterator = this.stack.peek();
            }
            this.nextNode = neighborNodeIterator.next();
        } while (this.sommetsConsultes.contains(this.nextNode));
        this.stack.push(graph.getAdjNodes(this.nextNode).iterator());
    }
}
