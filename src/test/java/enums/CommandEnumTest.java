package enums;

import com.braintree.challenge.enums.CommandEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * <code>CommandEnumTest</code> is a unit test for the CommandEnum class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CommandEnumTest {

    @Test
    public void testCommandEnum() {
        assertEquals("should be Add", "Add", CommandEnum.ADD.getCommand());
        assertEquals("should be Credit", "Credit", CommandEnum.CREDIT.getCommand());
        assertEquals("should be Charge", "Charge", CommandEnum.CHARGE.getCommand());
    }

    @Test
    public void testGetCommandEnum() {
        assertEquals("should be Add", CommandEnum.ADD, CommandEnum.getCommand("Add"));
        assertEquals("should be Credit", CommandEnum.CREDIT, CommandEnum.getCommand("Credit"));
        assertEquals("should be Charge", CommandEnum.CHARGE, CommandEnum.getCommand("Charge"));
    }

    @Test
    public void testGetCommandEnum_Null() {
        assertNull("should be null", CommandEnum.getCommand(""));
        assertNull("should be null", CommandEnum.getCommand(null));
    }
}
