package com.braintree.challenge.facade;

import com.braintree.challenge.model.CreditCard;

import java.util.List;

/**
 *
 * <code>CreditFacade</code> an interface defining the behavior of our Credit Facade.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public interface CreditFacade {

    /**
     * add - adds a credit card object to storage.
     * @param creditCard String
     */
    void add(CreditCard creditCard);

    /**
     * charge - applies a charge to a given account holders credit card.
     * @param accountHolder String
     * @param value String
     */
    void charge(String accountHolder, String value);

    /**
     * credit - applies a credit to a given account holders credit card.
     * @param accountHolder String
     * @param value String
     */
    void credit(String accountHolder, String value);

    /**
     * getCreditAccountsSummary - return an array of strings represeting the balances
     * for all credit card customers.
     *
     * @return String[]
     */
    List<String> getCreditAccountsSummary();

}
