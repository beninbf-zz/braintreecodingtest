package com.braintree.challenge.repository.impl;

import com.braintree.challenge.model.CreditCard;
import com.braintree.challenge.repository.CreditCardRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <code>CreditCardRespositoryImpl</code> an interface for the com.braintree.challenge.repository storing our CreditCard.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditCardRespositoryImpl implements CreditCardRepository {

    private final Map<String, CreditCard> creditCardMap;

    /**
     * CreditCardRespositoryImpl constructor.
     */
    public CreditCardRespositoryImpl() {
        this.creditCardMap = new HashMap<>();
    }

    /**
     * add - add account holder to storage.
     * @param creditCard - the object representing our credit card
     */
    public void add(CreditCard creditCard) {
        this.creditCardMap.put(creditCard.getAccountHolder(), creditCard);
    }

    /**
     * findCreditCard - given an account holder find the credit card.
     *
     * @param accountHolder String
     * @return CreditCard
     */
    public CreditCard findCreditCard(String accountHolder) {
        return this.creditCardMap.get(accountHolder);
    }

    /**
     * getSummary - returns a list of credit cards.
     * @return list of credit cards
     */
    public List<CreditCard> getSummary() {
        List<CreditCard> results = new ArrayList<>();
        for (Map.Entry<String, CreditCard> entry : this.creditCardMap.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }
}
