package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeTest {

	@Test
	void equalsTest() {
		// NAMING SCHEME
		// u = unnamed
		// n = named
		
		// two unnamed points
		SegmentNode uu = new SegmentNode(new PointNode(12, -4.32), new PointNode(0.003, Math.PI));
		assertEquals(new SegmentNode(new PointNode(12, -4.32), new PointNode(0.003, Math.PI)), uu);
		
		// named point and unnamed point
		SegmentNode nu = new SegmentNode(new PointNode("__UNNAMED", 12, -4.32), new PointNode(0.003, Math.PI));
		assertEquals(new SegmentNode(new PointNode("__UNNAMED", 12, -4.32), new PointNode(0.003, Math.PI)), nu);
		
		// unnamed point and named point
		SegmentNode un = new SegmentNode(new PointNode(12, -4.32), new PointNode("CookieMonster", 0.003, Math.PI));
		assertEquals(new SegmentNode(new PointNode(12, -4.32), new PointNode("CookieMonster", 0.003, Math.PI)), un);
		
		// two named points
		SegmentNode nn = new SegmentNode(new PointNode("__UNNAMED", 12, -4.32), new PointNode("CookieMonster", 0.003, Math.PI));
		assertEquals(new SegmentNode(new PointNode("__UNNAMED", 12, -4.32), new PointNode("CookieMonster", 0.003, Math.PI)), nn);

		// different order
		PointNode a = new PointNode("A", 1, 2.329);
		PointNode b = new PointNode("B", 231.2, -932.0);

		assertEquals(new SegmentNode(a, b), new SegmentNode(b, a));
	}

	@Test
	void toStringTest() {
		// NAMING SCHEME
		// u = unnamed
		// n = named
		
		// two unnamed points
		SegmentNode uu = new SegmentNode(new PointNode(12, -4.32), new PointNode(0.003, Math.PI));
		assertEquals("[(12, -4.32), (0.003, 3.14159)]", uu.toString());
		
		// named point and unnamed point
		SegmentNode nu = new SegmentNode(new PointNode("__UNNAMED", 12, -4.32), new PointNode(0.003, Math.PI));
		assertEquals("[__UNNAMED(12, -4.32), (0.003, 3.14159)]", nu.toString());
		
		// unnamed point and named point
		SegmentNode un = new SegmentNode(new PointNode(12, -4.32), new PointNode("CookieMonster", 0.003, Math.PI));
		assertEquals("[(12, -4.32), CookieMonster(0.003, 3.14159)]", un.toString());
		
		// two named points
		SegmentNode nn = new SegmentNode(new PointNode("__UNNAMED", 12, -4.32), new PointNode("CookieMonster", 0.003, Math.PI));
		assertEquals("[__UNNAMED(12, -4.32), CookieMonster(0.003, 3.14159)]", nn.toString());
	}
}
