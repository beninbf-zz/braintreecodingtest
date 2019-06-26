package service;

import com.braintree.challenge.service.impl.LuhnValidationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 *
 * <code>LuhnValidationServiceImplTest</code> a unit test for the LuhnValidationServiceImpl class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class LuhnValidationServiceImplTest {

    private LuhnValidationServiceImpl luhnValidationService;

    @Before
    public void setUp() {
        luhnValidationService = new LuhnValidationServiceImpl();
    }

    @Test
    public void testLuhnValidationService() {
        assertFalse("should be false", luhnValidationService.isValid(null));
    }

    @Test
    public void testLuhnValidationService1() {
        assertFalse("should be false", luhnValidationService.isValid(""));
    }

    @Test
    public void testLuhnValidationService2() {
        assertTrue("should be true", luhnValidationService.isValid("4111111111111111"));
    }

    @Test
    public void testLuhnValidationService3() {
        assertTrue("should be true", luhnValidationService.isValid("5454545454545454"));
    }

    @Test
    public void testLuhnValidationService4() {
        assertFalse("should be false", luhnValidationService.isValid("1234567890123456"));
    }

    @Test
    public void testLuhnValidationService5() {
        assertTrue("should be true", luhnValidationService.isValid("4756899678633135"));
    }

    @Test
    public void testLuhnValidationService6() {
        assertFalse("should be true", luhnValidationService.isValid("4256899678633135"));
    }
}
