package graph;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractIterator implements Iterator<Node>{

    private ArrayList<Node> sommetsConsultes = new ArrayList<>();
    private Graph graph;

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
