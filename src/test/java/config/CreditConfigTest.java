package config;

import com.braintree.challenge.config.CreditConfig;
import com.braintree.challenge.facade.CreditFacade;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.service.CreditService;
import com.braintree.challenge.service.CreditValidationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * <code>CreditConfigTest</code> is a unit test for the CreditConfig class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditConfigTest {

    private CreditConfig config;

    @Before
    public void setUp() {
        config = new CreditConfig();
    }

    @Test
    public void testCreditService() {
        assertNotNull(config.creditService());
        assertTrue(config.creditService() instanceof CreditService);
    }

    @Test
    public void testCreditCardRepository() {
        assertNotNull(config.creditCardRepository());
        assertTrue(config.creditCardRepository() instanceof CreditCardRepository);
    }

    @Test
    public void testCreditFacade() {
        assertNotNull(config.creditFacade());
        assertTrue(config.creditFacade() instanceof CreditFacade);
    }

    @Test
    public void testCreditValidationService() {
        assertNotNull(config.creditValidationService());
        assertTrue(config.creditValidationService() instanceof CreditValidationService);
    }
}
