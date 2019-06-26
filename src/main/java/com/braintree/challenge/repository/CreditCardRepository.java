package com.braintree.challenge.repository;

import com.braintree.challenge.model.CreditCard;

import java.util.List;

/**
 *
 * <code>CreditCardRepository</code> an interface for the com.braintree.challenge.repository storing our CreditCard.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public interface CreditCardRepository {

    /**
     * add - adds a new account holder and their credit card to storage.
     *
     * @param creditCard - the object representing our credit card
     */
    void add(CreditCard creditCard);

    CreditCard findCreditCard(String accountHolder);

    /**
     * getSummary - returns a list of credit cards and their balances.
     *
     * @return List of Credit Card
     */
    List<CreditCard> getSummary();
}
