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
		// TODO
	}
	
	public void addUndirectedEdge(PointNode point1, PointNode point2) {
		addDirectedEdge(point1, point2);
		addDirectedEdge(point2, point1);
	}
	
	public void addAdjacencyList(PointNode point, List<PointNode> adjacencyList) {
		// TODO
	}
	
	public List<SegmentNode> asSegmentList() {
		// TODO
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		// TODO
	}
}
