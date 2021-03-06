package examples.chapter8_refactor_test_debug.lambdaTesting830;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    public void testMoveRightBy() throws Exception {
        Point p1 = new Point(5,5);
        Point p2 = p1.moveRightBy(5);

        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    public void testComparingWithLambda() throws Exception {
        Point p1 = new Point(10,15);
        Point p2 = new Point(10,20);

        int result = Point.compareByXAndThenY.compare(p1,p2);
        assertEquals(-1, result);
    }

}
