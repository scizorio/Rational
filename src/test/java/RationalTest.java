import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RationalTest {
    Rational r1;
    Rational r2;

    /***
     * This method will be called every time before the other @Test method
     * is called.
     */
    @Before
    public void createRationals() {
        System.out.println("Initializing the two Rational numbers.");
        r1 = new Rational();
        r2 = new Rational();
    }

    /***
     * For this test case, we want to check the add() method
     * by calculating the summation of 1/2 and 1/4.
     * The expected result must be 3/4.
     */
    @Test
    public void testAdd() {
        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 1;
        r2.denominator = 4;
        r1.add(r2);
        Assert.assertEquals(3, r1.numerator);
        Assert.assertEquals(4, r1.denominator);
    }

    // Test for the subtract method
    @Test
    public void testSubtract() {
        try {
            Rational r1 = new Rational(3, 4);
            Rational r2 = new Rational(1, 2);
            r1.subtract(r2);
            // Expected: 3/4 - 1/2 = 1/4
            Assert.assertEquals(1, r1.numerator);
            Assert.assertEquals(4, r1.denominator);
        } catch (Rational.Illegal e) {
            Assert.fail("Exception should not be thrown for valid inputs.");
        }
    }

    // Test for the multiply method
    @Test
    public void testMultiply() {
        try {
            Rational r1 = new Rational(2, 3);
            Rational r2 = new Rational(3, 4);
            r1.multiply(r2);
            // Expected: 2/3 * 3/4 = 6/12, which simplifies to 1/2
            Assert.assertEquals(1, r1.numerator);
            Assert.assertEquals(2, r1.denominator);
        } catch (Rational.Illegal e) {
            Assert.fail("Exception should not be thrown for valid inputs.");
        }
    }

    // Test for the divide method
    @Test
    public void testDivide() {
        try {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(3, 4);
            r1.divide(r2);
            // Expected: (1/2) / (3/4) = 4/6, which simplifies to 2/3
            Assert.assertEquals(2, r1.numerator);
            Assert.assertEquals(3, r1.denominator);
        } catch (Rational.Illegal e) {
            Assert.fail("Exception should not be thrown for valid inputs.");
        }
    }

    // Test for the equals method
    @Test
    public void testEquals() {
        try {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(2, 4); // Simplifies to 1/2
            Rational r3 = new Rational(1, 3);

            Assert.assertTrue("1/2 should be equal to 2/4", r1.equals(r2));
            Assert.assertFalse("1/2 should not be equal to 1/3", r1.equals(r3));
        } catch (Rational.Illegal e) {
            Assert.fail("Exception should not be thrown for valid inputs.");
        }
    }

    // Test for the compareTo method
    @Test
    public void testCompareTo() {
        try {
            Rational r1 = new Rational(1, 2); // 0.5
            Rational r2 = new Rational(3, 4); // 0.75
            Rational r3 = new Rational(2, 4); // 0.5

            Assert.assertEquals(-1, r1.compareTo(r2)); // r1 < r2
            Assert.assertEquals(1, r2.compareTo(r1));  // r2 > r1
            Assert.assertEquals(0, r1.compareTo(r3));   // r1 == r3
        } catch (Rational.Illegal e) {
            Assert.fail("Exception should not be thrown for valid inputs.");
        }
    }

    // Test for the toString method
    @Test
    public void testToString() {
        try {
            Rational r1 = new Rational(-5, 10); // Simplifies to -1/2
            Assert.assertEquals("-1/2", r1.toString());
        } catch (Rational.Illegal e) {
            Assert.fail("Exception should not be thrown for valid inputs.");
        }
    }

    // Test that the constructor throws an exception for a zero denominator
    @Test
    public void testConstructorThrowsExceptionOnZeroDenominator() {
        try {
            new Rational(1, 0);
            Assert.fail("Expected an Illegal exception to be thrown for zero denominator.");
        } catch (Rational.Illegal e) {
            // Test passes if this catch block is reached.
            Assert.assertEquals("Denominator cannot be zero.", e.reason);
        }
    }

    /***
     * This method will be called every time after the other @Test method
     * is called.
     */
    @After
    public void clearUp() {
        System.out.println("Clear up the two Rational numbers.");
        r1 = null;
        r2 = null;
    }
}
