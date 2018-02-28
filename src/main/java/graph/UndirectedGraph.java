package graph;

import java.util.List;
import java.util.Set;

public class UndirectedGraph implements IUndirectedGraph {

    private Graph graph;

    @Override
    public void addEdge(Node _node1, Node _node2) {

    }

    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return false;
    }

    @Override
    public void addNode(Node _node) {
        graph.addNode(_node);
    }

    @Override
    public Set<Node> getAllNodes() {
        return graph.getAllNodes();
    }

    @Override
    public int getNbNodes() {
        return graph.getNbNodes();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        return graph.getAdjNodes(_n);
    }
}
