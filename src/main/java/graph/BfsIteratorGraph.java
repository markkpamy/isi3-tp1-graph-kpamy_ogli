package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BfsIteratorGraph implements Iterator<Node> {
    private LinkedList<Node> file = new LinkedList<>();
    private ArrayList<Node> sommetsConsultes = new ArrayList<>();
    private Graph graph;

    public BfsIteratorGraph(Graph graph,Node startNode) {
        this.file.add(startNode);
        this.sommetsConsultes.add(startNode);
        this.graph=graph;
    }

    @Override
    public boolean hasNext() {

        return !this.file.isEmpty();
    }

    @Override
    public Node next() {
        if (!hasNext())
            throw new NoSuchElementException();
        Node nextNode = file.remove();
        for (Node neighbor : graph.getAdjNodes(nextNode)) {
            if (!this.sommetsConsultes.contains(neighbor)) {
                this.file.add(neighbor);
                this.sommetsConsultes.add(neighbor);
            }
        }
        return nextNode;
    }
}
