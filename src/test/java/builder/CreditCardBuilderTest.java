package builder;

import com.braintree.challenge.builder.CreditCardBuilder;
import com.braintree.challenge.model.CreditCard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * <code>CreditCardBuilderTest</code> is a unit test for the CreditCardBuilder class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditCardBuilderTest {

    @Test
    public void testCreditCardBuilder() {
        CreditCard creditCard = new CreditCardBuilder().creditCardNumber("5454545454545454").accountHolder("Bob").limit("$1000").build();
        assertEquals("credit card number should be 5454545454545454", "5454545454545454", creditCard.getCreditCardNumber());
        assertEquals("account holder should be Bob", "Bob", creditCard.getAccountHolder());
        assertEquals("account holder should be 1000", 1000.0d, creditCard.getLimit().doubleValue(), 0002.d);
        assertEquals("account holder should be 0", 0.0d, creditCard.getBalance().doubleValue(), .0002d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardBuilder_exception() {
        new CreditCardBuilder().accountHolder("Bob").limit("$1000").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardBuilder_exception1() {
        new CreditCardBuilder().creditCardNumber("5454545454545454").limit("$1000").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardBuilder_exceptio2() {
        new CreditCardBuilder().accountHolder("Bob").creditCardNumber("5454545454545454").build();
    }
}
