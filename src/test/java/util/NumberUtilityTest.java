package util;

import com.braintree.challenge.util.NumberUtility;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 *
 * <code>NumberUtilityTest</code> is a unit test for the NumberUtility class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class NumberUtilityTest {

    @Test
    public void testNumberUtility() {
        Double result = NumberUtility.getDouble("$1000");
        assertEquals("should be equal", 1000.0d, result.doubleValue(), .0002d);
    }

    @Test
    public void testNumberUtility_MissingDollarSign() {
        Double result = NumberUtility.getDouble("1000");
        assertNull("should be null", result);
    }

    @Test
    public void testNumberUtility_Empty() {
        Double result = NumberUtility.getDouble("");
        assertNull("should be null", result);
    }

    @Test
    public void testNumberUtility_Null() {
        Double result = NumberUtility.getDouble(null);
        assertNull("should be null", result);
    }

    @Test
    public void testNumberUtility_InvalidInput() {
        Double result = NumberUtility.getDouble("test");
        assertNull("should be null", result);
    }
}
