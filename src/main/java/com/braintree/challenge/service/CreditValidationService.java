package com.braintree.challenge.service;

/**
 *
 * <code>CreditValidationService</code> interface for defining behavior of a credit card validation com.braintree.challenge.service.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public interface CreditValidationService {

    /**
     * isValid - determines if the supplied number is a valid credit card number.
     * @param creditCardNumber String
     * @return boolean
     */
    boolean isValid(String creditCardNumber);
}
