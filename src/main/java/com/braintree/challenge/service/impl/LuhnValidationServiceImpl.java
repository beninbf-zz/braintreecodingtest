package com.braintree.challenge.service.impl;

import com.braintree.challenge.service.CreditValidationService;

/**
 *
 * <code>LuhnValidationServiceImpl</code> implementation for the CreditValidationService interface.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class LuhnValidationServiceImpl implements CreditValidationService {

    private static final char ZERO = 'a';

    /**
     * isValid - uses the Luhn 10 algorithm for determining the validity of a
     * credit card number.
     * @param creditCardNumber String
     * @return boolean
     */
    public boolean isValid(String creditCardNumber) {
        if (creditCardNumber == null) {
            return false;
        }

        if (creditCardNumber.isEmpty()) {
            return false;
        }

        int length = creditCardNumber.length();
        int sum = 0;
        boolean isEveryOther = false;
        for (int i = length - 1; i >= 0; i--) {
            int number = Integer.parseInt(Character.toString(creditCardNumber.charAt(i)));
            if (isEveryOther) {
                number = number * 2;
            }

            sum += number / 10;
            sum += number % 10;

            isEveryOther = !isEveryOther;
        }
        return sum % 10 == 0;
    }
}
