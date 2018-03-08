package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator implements Iterator<Node> {

    private ArrayList<Node> sommetsConsultes = new ArrayList<>();
    private Graph graph;
    protected Node nextNode;

    public AbstractIterator(Graph graph, Node startNode) {
        this.nextNode = startNode;
        this.setGraph(graph);
        this.getSommetsConsultes().add(startNode);
    }

    public ArrayList<Node> getSommetsConsultes() {
        return sommetsConsultes;
    }

    public void setSommetsConsultes(ArrayList<Node> sommetsConsultes) {
        this.sommetsConsultes = sommetsConsultes;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public Node next() {
        if (!hasNext())
            throw new NoSuchElementException();
        Node nextNode = getNextNode();
        for (Node neighbor : this.getGraph().getAdjNodes(nextNode)) {
            if (!this.getSommetsConsultes().contains(neighbor)) {
                addNeighbor(neighbor);
                this.getSommetsConsultes().add(neighbor);
            }
        }
        return nextNode;
    }

    @Override
    public boolean hasNext() {
        return hasNextElement();
    }

    //retourne l'element prochain de la file ou la pile
    public abstract Node getNextNode();

    //marque le sommet comme étant visité
    public abstract void addNeighbor(Node n);

    //verifie que le prochain element exite
    public  abstract boolean hasNextElement();

}
