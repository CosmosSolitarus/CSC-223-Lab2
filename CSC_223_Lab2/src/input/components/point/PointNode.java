/**
 * Implements a point as a two-dimensional geometry object 
 * defined by its coordinates x and y, denoted Name(x, y).
 * 
 * @authors Jack, Sage, Della
 * @date 1/21/24
 */

package input.components.point;

import utilities.math.MathUtilities;

/**
 * A 2D Point (x, y).
 */
public class PointNode
{
	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;
	public double getX() { return this._x; }

	protected double _y; 
	public double getY() { return this._y; }

	protected String _name; 
	public String getName() { return _name; }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y)
	{
		_name = ANONYMOUS;
		_x = MathUtilities.removeLessEpsilon(x);
		_y = MathUtilities.removeLessEpsilon(y);
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y)
	{
		// new String(name) is necessary to allow "__UNNAMED"
		// to be passed in as a name for the point.
		_name = new String(name);
		_x = MathUtilities.removeLessEpsilon(x);
		_y = MathUtilities.removeLessEpsilon(y);
	}

	@Override
	public int hashCode()
	{
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof PointNode)) {
			return false;
		}
		
		PointNode that = (PointNode) obj;

		return MathUtilities.doubleEquals(_x, that.getX()) && MathUtilities.doubleEquals(_y, that.getY());
	}

    @Override
    public String toString()
    {
		String outName = _name;
		String outX = _x + "";
		String outY = _y + "";
    	
		// Formatting
		// --------------------------------
		if (outName == ANONYMOUS) {
			outName = "";
		}
		
		if (_x == (int) _x) {
			outX = (int) _x + "";
		}
		
		if (_y == (int) _y) {
			outY = (int) _y + "";
		}
		// --------------------------------
		
    	return outName + "(" + outX + ", " + outY + ")";
	}
}