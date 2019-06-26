package com.braintree.challenge.service;

/**
 *
 * <code>CreditService</code> interface for defining behavior of a credit com.braintree.challenge.service.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public interface CreditService {

    /**
     * credit - credits an account holders account with a given value.
     *
     * @param accountHolder the account holder to credit
     * @param value the value to credit the account holder
     */
    void credit(String accountHolder, Double value);

    /**
     * charge - charges an account holders account with a given value.
     *
     * @param accountHolder the account holder to charge
     * @param value the value to charge
     */
    void charge(String accountHolder, Double value);
}
