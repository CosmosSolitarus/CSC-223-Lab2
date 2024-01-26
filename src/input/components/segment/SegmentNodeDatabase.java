package input.components.segment;

import java.util.*;
import input.components.point.PointNode;

public class SegmentNodeDatabase {
	protected Map<PointNode, Set<PointNode>> _adjLists;
	
	public SegmentNodeDatabase() {
		_adjLists = new HashMap<>();
	}
	
	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> map) {
		_adjLists = new HashMap<>(map);
	}
	
	public int numUndirectedEdges() {
		int count = 0;
		
		for (Set<PointNode> adjList : _adjLists.values()) {
			count += adjList.size();
		}
		
		// adjacencies are entered twice (A -> B and B -> A)
		// so divide by two to count total number of edges.
		return count / 2;
	}
	
	private void addDirectedEdge(PointNode point1, PointNode point2) {
		if (!_adjLists.containsKey(point1) ) {
			_adjLists.put(point1, new HashSet<PointNode>());
		}
		_adjLists.get(point1).add(point2);
	}
	
	public void addUndirectedEdge(PointNode point1, PointNode point2) {
		addDirectedEdge(point1, point2);
		addDirectedEdge(point2, point1);
	}
	
	public void addAdjacencyList(PointNode point, List<PointNode> adjacencyList) {
		_adjLists.put(point, new HashSet<PointNode> (adjacencyList));
	}
	
	public List<SegmentNode> asSegmentList() {
		List<SegmentNode> snList = new ArrayList<SegmentNode>();

		for (PointNode pn1 : _adjLists.keySet()) {
			for (PointNode pn2 : _adjLists.get(pn1)) {
				snList.add(new SegmentNode(pn1, pn2));
			}
		}

		return snList;
	}
	//brycen consulted here
	public List<SegmentNode> asUniqueSegmentList() {
		List<SegmentNode> snList = new ArrayList<SegmentNode>();

		for (SegmentNode node: asSegmentList()) {
			if (!snList.contains(node)) {
				snList.add(node);
			}
		}

		return snList;
	}
}
