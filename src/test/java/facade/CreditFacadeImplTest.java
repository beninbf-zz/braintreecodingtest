package facade;

import com.braintree.challenge.facade.CreditFacade;
import com.braintree.challenge.facade.impl.CreditFacadeImpl;
import com.braintree.challenge.model.CreditCard;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.service.CreditService;
import com.braintree.challenge.service.CreditValidationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * <code>CreditFacadeImplTest</code> is a unit test for the CreditFacadeImpl class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditFacadeImplTest {

    @Mock
    private CreditCardRepository creditCardRespository;

    @Mock
    private CreditService creditService;

    @Mock
    private CreditValidationService creditValidationService;

    @InjectMocks
    private CreditFacade creditFacade;

    @Before
    public void setUp() {
        creditFacade = new CreditFacadeImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreditCardAdd_NotValidCreditCardNumber() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn("1234567890123456");
        when(creditValidationService.isValid("1234567890123456")).thenReturn(false);
        creditFacade.add(creditCard);
    }

    @Test
    public void testCreditCardAdd_ValidCreditCardNumber() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn("5454545454545454");
        when(creditValidationService.isValid("5454545454545454")).thenReturn(true);
        creditFacade.add(creditCard);
    }

    @Test
    public void testCharge() {
        creditFacade.charge("test", "$1000");
    }

    @Test
    public void testCharge_InvalidAmount() {
        creditFacade.charge("test", "1000");
    }

    @Test
    public void testCredit_ValidAmount() {
        creditFacade.charge("test", "$1000");
    }

    @Test
    public void testCredit_InvalidAmount() {
        creditFacade.charge("test", "1000");
    }

    @Test
    public void testGetSummary() {
        CreditCard creditCard = new CreditCard();
        creditCard.setAccountHolder("Lisa");
        creditCard.setCreditCardNumber("5454545454545454");
        creditCard.setBalance(-93.0d);
        creditCard.setLimit(1000.0d);

        CreditCard creditCard1 = new CreditCard();
        creditCard1.setAccountHolder("Tom");
        creditCard1.setCreditCardNumber("4111111111111111");
        creditCard1.setBalance(500.0d);
        creditCard1.setLimit(1000.0d);

        CreditCard creditCard2 = new CreditCard();
        creditCard2.setAccountHolder("Quincy");
        creditCard2.setCreditCardNumber(null);
        creditCard2.setBalance(0.0d);
        creditCard2.setLimit(1000.0d);

        when(creditCardRespository.getSummary()).thenReturn(Arrays.asList(creditCard, creditCard1, creditCard2));
        List<String> results = creditFacade.getCreditAccountsSummary();
        System.out.println(results);

        assertEquals("should be 3", 3, results.size());
    }
}
