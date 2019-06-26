package repository;

import com.braintree.challenge.model.CreditCard;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.repository.impl.CreditCardRespositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 *
 * <code>CreditCardRepositoryImplTest</code> is a unit test for the CreditCardRepositoryImpl class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditCardRepositoryImplTest {

    @InjectMocks
    private CreditCardRepository creditCardRepository;

    @Before
    public void setUp() {
        creditCardRepository = new CreditCardRespositoryImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreditCardAdd() {
        CreditCard creditCard = mock(CreditCard.class);
        creditCardRepository.add(creditCard);
    }

    @Test
    public void testFindCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setAccountHolder("test");
        creditCard.setCreditCardNumber("5454545454545454");
        creditCard.setBalance(0.0d);
        creditCard.setLimit(1000.0d);

        creditCardRepository.add(creditCard);
        CreditCard result = creditCardRepository.findCreditCard("test");

        assertEquals("account holder should be test", "test", result.getAccountHolder());
        assertEquals("credit card number should be 5454545454545454", "5454545454545454", result.getCreditCardNumber());
        assertEquals("balance should be 0", 0.0d, result.getBalance().doubleValue(), .00002d);
        assertEquals("account holder should be 1000", 1000.0d, result.getLimit().doubleValue(), .00002d);

        CreditCard creditCard1 = new CreditCard();
        creditCard1.setAccountHolder("test1");
        creditCard1.setCreditCardNumber("4111111111111111");
        creditCard1.setBalance(0.0d);
        creditCard1.setLimit(2000.0d);

        creditCardRepository.add(creditCard1);
        CreditCard result1 = creditCardRepository.findCreditCard("test1");

        assertEquals("account holder should be test", "test1", result1.getAccountHolder());
        assertEquals("credit card number should be 4111111111111111", "4111111111111111", result1.getCreditCardNumber());
        assertEquals("balance should be 0", 0.0d, result1.getBalance().doubleValue(), .00002d);
        assertEquals("account holder should be 1000", 2000.0d, result1.getLimit().doubleValue(), .00002d);
    }

    @Test
    public void testFindCreditCard_Null() {
        CreditCard result = creditCardRepository.findCreditCard("credit");
        assertNull("result should be null", result);
    }

    @Test
    public void testGetCreditSummery() {
        CreditCard creditCard = new CreditCard();
        creditCard.setAccountHolder("test");
        creditCard.setCreditCardNumber("5454545454545454");
        creditCard.setBalance(0.0d);
        creditCard.setLimit(1000.0d);

        CreditCard creditCard1 = new CreditCard();
        creditCard1.setAccountHolder("test1");
        creditCard1.setCreditCardNumber("4111111111111111");
        creditCard1.setBalance(0.0d);
        creditCard1.setLimit(1000.0d);

        CreditCard creditCard2 = new CreditCard();
        creditCard2.setAccountHolder("test2");
        creditCard2.setCreditCardNumber(null);
        creditCard2.setBalance(0.0d);
        creditCard2.setLimit(1000.0d);

        creditCardRepository.add(creditCard);
        creditCardRepository.add(creditCard1);
        creditCardRepository.add(creditCard2);

        List<CreditCard> creditCards = creditCardRepository.getSummary();
        assertEquals("size should be 3", 3, creditCards.size());
    }
}