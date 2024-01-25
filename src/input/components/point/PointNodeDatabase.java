package input.components.point;

import java.util.*;

public class PointNodeDatabase {
	protected Set<PointNode> _points;
	
	public PointNodeDatabase() {
		_points = new LinkedHashSet<>();
	}
	
	public PointNodeDatabase(List<PointNode> pns) {
		_points = new LinkedHashSet<>(pns);
	}
	
	public void put(PointNode pn) {
		_points.add(pn);
	}
	
	public boolean contains(PointNode pn) {
		return _points.contains(pn);
	}
	
	public boolean contains(double x, double y) {
		return _points.contains(new PointNode(x, y));
	}
	
	public String getName(PointNode pn) {
		for (PointNode _pn: _points) {
			if (_pn.equals(pn)) {
				return _pn.getName();
			}
		}
		
		return null;
	}
	
	public String getName(double x, double y) {
		return getName(new PointNode(x, y));
	}
	
	public PointNode getPoint(PointNode pn) {
		for (PointNode _pn: _points) {
			if (_pn.equals(pn)) {
				return _pn;
			}
		}
		
		return null;
	}
	
	public PointNode getPoint(double x, double y) {
		return getPoint(new PointNode(x, y));
	}
}
