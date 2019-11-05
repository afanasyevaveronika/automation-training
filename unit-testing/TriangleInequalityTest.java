import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleInequalityTest {

    @Test
    public void equilateralTriangle() {
        Assert.assertTrue(TriangleInequality.ExistanceOfATriangle(5, 5, 5));
    }

    @Test
    public void isoscelesTriangle() {
        Assert.assertTrue(TriangleInequality.ExistanceOfATriangle(5, 5, 6));
    }

    @Test
    public void sumOfTwoEqualToThirdSideTriangle() {
        Assert.assertFalse(TriangleInequality.ExistanceOfATriangle(5, 5, 10));
    }

    @Test
    public void usualTriangle() {
        Assert.assertTrue(TriangleInequality.ExistanceOfATriangle(6, 7, 10));
    }

    @Test
    public void nonexistentTriangle() {
        Assert.assertFalse(TriangleInequality.ExistanceOfATriangle(10, 13, 25));
    }

    @Test
    public void rightTriangle() {
        Assert.assertTrue(TriangleInequality.ExistanceOfATriangle(3, 5, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeSideTriangle() {
        TriangleInequality.ExistanceOfATriangle(2, -7, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneSideZeroTriangle() {
        TriangleInequality.ExistanceOfATriangle(0, 8, 7);
    }

    @Test
    public void positiveInfinitySidesTriangle() {
        assertFalse(TriangleInequality.ExistanceOfATriangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }

    @Test
    public void NaNSidesTriangle() {
        assertFalse(TriangleInequality.ExistanceOfATriangle(Double.NaN, 5, 7));
    }

}