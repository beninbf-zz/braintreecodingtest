package service;

import com.braintree.challenge.model.CreditCard;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.service.CreditService;
import com.braintree.challenge.service.impl.CreditServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>CreditServiceImplTest</code> is a unit test for the CreditServiceImpl class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditServiceImplTest {

    @Mock
    private CreditCardRepository creditCardRepository;

    @InjectMocks
    private CreditService creditService;

    @Before
    public void setUp() {
        creditService = new CreditServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreditCardNumberNull() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn(null);
        when(creditCardRepository.findCreditCard(anyString())).thenReturn(creditCard);

        creditService.credit("test", 100.0d);
        verify(creditCardRepository, times(0)).add(any(CreditCard.class));
    }

    @Test
    public void testCreditCardNumberPresent() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn("41111111111111111");
        when(creditCardRepository.findCreditCard(anyString())).thenReturn(creditCard);

        creditService.credit("test", 100.0d);
        verify(creditCardRepository, times(1)).add(any(CreditCard.class));
    }

    @Test
    public void testChargeCreditCardNumberNull() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn(null);
        when(creditCardRepository.findCreditCard(anyString())).thenReturn(creditCard);

        creditService.charge("test", 100.0d);
        verify(creditCardRepository, times(0)).add(any(CreditCard.class));
    }

    @Test
    public void testChargeCreditCard_underLimit() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn("41111111111111111");
        when(creditCard.getBalance()).thenReturn(900.0d);
        when(creditCard.getLimit()).thenReturn(1000.0d);
        when(creditCardRepository.findCreditCard(anyString())).thenReturn(creditCard);

        creditService.charge("test", 100.0d);
        verify(creditCardRepository, times(1)).add(any(CreditCard.class));
    }

    @Test
    public void testChargeCreditCard_overLimit() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCard.getCreditCardNumber()).thenReturn("41111111111111111");
        when(creditCard.getBalance()).thenReturn(1000.0d);
        when(creditCard.getLimit()).thenReturn(1000.0d);
        when(creditCardRepository.findCreditCard(anyString())).thenReturn(creditCard);

        creditService.charge("test", 100.0d);
        verify(creditCardRepository, times(0)).add(any(CreditCard.class));
    }
}
