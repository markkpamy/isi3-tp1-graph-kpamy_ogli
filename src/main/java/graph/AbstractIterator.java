package graph;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractIterator implements Iterator<Node>{

    private ArrayList<Node> sommetsConsultes = new ArrayList<>();
    private Graph graph;
    protected Node nextNode;

    public AbstractIterator(Graph graph, Node startNode) {
        this.nextNode = startNode;
        this.setGraph(graph);
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

}
