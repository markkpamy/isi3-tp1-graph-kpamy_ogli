package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BfsIteratorGraph extends AbstractIterator implements Iterator<Node> {
    private LinkedList<Node> file = new LinkedList<>();


    public BfsIteratorGraph(Graph graph,Node startNode) {
        this.file.add(startNode);
        this.getSommetsConsultes().add(startNode);
        super.setGraph(graph);
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
        for (Node neighbor : this.getGraph().getAdjNodes(nextNode)) {
            if (!this.getSommetsConsultes().contains(neighbor)) {
                this.file.add(neighbor);
                this.getSommetsConsultes().add(neighbor);
            }
        }
        return nextNode;
    }
}
