import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

public class CircleTest {
    private Point2D.Double p_0_0, p_1_1, p_null, p_50_300, p_neg;
    private double r_0, r_1, r_50, r_200, negr;
    private Circle c;

    @Before
    public void setUp() {
        p_0_0 = new Point2D.Double();
        p_1_1 = new Point2D.Double(1,1);
        p_50_300 = new Point2D.Double(50, 300);
        p_neg = new Point2D.Double(-1,-1);
        r_0 = 0;
        r_1 = 1;
        r_50 = 50;
        r_200 = 200;
        negr = -1;
        p_null = null;
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Circle_nullp_throws_IllegalArgumentException() {
        c = new Circle(p_null, r_0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Circle_negatievep_throws_IllegalArgumentException() {
        c = new Circle(p_neg, r_0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Circle_negatiever_throws_IllegalArgumentException() {
        c = new Circle(p_0_0, negr);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Circle_teBigr_throws_IllegalArgumentException() {
        c = new Circle(p_1_1, r_200);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Circle_teBigr_metp_0_0_throws_IllegalArgumentException() {
        c = new Circle(p_0_0, r_1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Circle_rGroterDan1p_throws_IllegalArgumentException() {
        c = new Circle(p_50_300, r_200);
    }

    @Test
    public void test_Circle_geldigeCircle() {
        c = new Circle(p_1_1, r_1);
        Assert.assertEquals(c.getMiddlePoint().x,1, 0.01);
        Assert.assertEquals(c.getMiddlePoint().y,1, 0.01);
        Assert.assertEquals(c.getRadius(), 1, 0.01);

        c = new Circle(p_50_300, r_50);
        Assert.assertEquals(c.getMiddlePoint().x, 50, 0.01);
        Assert.assertEquals(c.getMiddlePoint().y, 300, 0.01);
        Assert.assertEquals(c.getRadius(), 50, 0.01);
    }

    @Test
    public void test_area() {
        c = new Circle(p_0_0, r_0);
        Assert.assertEquals(c.area(), 0, 0.01);

        c = new Circle(p_1_1, r_1);
        Assert.assertEquals(c.area(), Math.PI, 0.01);

        c = new Circle(p_50_300, r_50);
        Assert.assertEquals(c.area(), Math.PI*Math.pow(50, 2), 0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_isInside_nullp_throws_IllegalArgumentException() {
        c = new Circle(p_1_1, r_1);
        c.isInside(null);
    }

    @Test
    public void test_isInside_onMiddlePoint() {
        c = new Circle(p_1_1, r_1);
        Assert.assertTrue(c.isInside(p_1_1));
    }

    @Test
    public void test_isInside_onCircle() {
        c = new Circle(p_1_1, r_1);
        Assert.assertTrue(c.isInside(new Point2D.Double(1, 0))); //left
        Assert.assertTrue(c.isInside(new Point2D.Double(0, 1))); //up
        Assert.assertTrue(c.isInside(new Point2D.Double(2, 1))); //right
        Assert.assertTrue(c.isInside(new Point2D.Double(1, 2))); //down
    }

    @Test
    public void test_isInside_outside() {
        c = new Circle(p_1_1, r_1);
        Assert.assertFalse(c.isInside(p_50_300));
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_increaseRadius_zeroFactor_throws_IllegalArgumentException() {
        c = new Circle(p_1_1, r_1);
        c.increaseRadius(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_increaseRadius_negFactor_throws_IllegalArgumentException() {
        c = new Circle(p_1_1, r_1);
        c.increaseRadius(-2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_increaseRadius_TooLargeFactor_throws_IllegalArgumentException() {
        c = new Circle(p_1_1, r_1);
        c.increaseRadius(2);
    }

    @Test
    public void test_increaseRadius_validFactor_radiusCorrect() {
        c = new Circle(p_50_300, r_1);
        c.increaseRadius(2);
    }
}