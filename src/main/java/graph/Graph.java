package graph;

import java.util.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Graph implements IDirectedGraph {

	/**
	 * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
	 */
	private Map<Node,List<Arc>> adjacence; 
	
	public Graph(){
		
		adjacence = new HashMap<Node,List<Arc>>();
		
		
	
	}
	/**
	 * 
	 * @param _n1
	 * @param _n2
	 * @return vrai si graph possede arc de src _n1 et destination _n2
	 */
	public boolean hasArc(Node _n1, Node _n2){
		List<Arc> arretesAdj = adjacence.get(_n1);
		for (Arc _a : arretesAdj){
			if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination()))
				return true;
		}
		return false;
	}
	
	public void addNode(Node _node){
		adjacence.put(_node, new ArrayList<Arc>());

	}
	
	public void addArc(Arc _edge){
	
		if (!hasArc(_edge.getSource(),_edge.getDestination()))
			adjacence.get(_edge.getSource()).add(_edge);
	
	}
	
	public Set<Node> getAllNodes(){
        //@TODO A COMPLETER
        return adjacence.keySet();
	}
	
	public int getNbNodes(){
		//@TODO A COMPLETER
		return adjacence.keySet().size();
	}
	
	/**
	 * 
	 * @param currentNode
	 * @return tous les arcs de source _n
	 */
	public List<Arc> getArc(Node currentNode){
		
		return adjacence.get(currentNode);
	}
	/**
	 * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
	 */
	public List<Node> getAdjNodes(Node currentNode){
		//@TODO A COMPLETER
		return adjacence.get(currentNode)
                .stream()
                .map(Arc::getDestination)
                .collect(toList());
	}
	
	

	@Override
	public String toString() {
        //@TODO A COMPLETER
        StringBuilder graphToString = new StringBuilder();
        graphToString.append("Graph \n");

		adjacence.forEach((node, arcList) -> {
            graphToString.append("[")
                    .append("node=")
                    .append(node.toString())
                    .append(" : ");
            final String arcToString =
                    arcList.stream()
                            .map(arc -> "[" + arc.toString() + "]")
                            .collect(joining(","));
            graphToString.append(arcToString)
                    .append("\n");
        });

		return graphToString.toString();
	}

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return null;
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return null;
    }
}
