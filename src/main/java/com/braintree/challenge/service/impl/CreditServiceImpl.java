package com.braintree.challenge.service.impl;

import com.braintree.challenge.model.CreditCard;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 *
 * <code>CreditServiceImpl</code> implementation for the CreditService interface.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditServiceImpl implements CreditService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditServiceImpl.class);

    @Inject
    private CreditCardRepository creditCardRepository;

    /**
     * credit - credit the account holder.
     * @param accountHolder the account holder to credit
     * @param value the value to credit the account holder
     */
    public void credit(String accountHolder, Double value) {
        CreditCard creditCard = creditCardRepository.findCreditCard(accountHolder);
        if (creditCard.getCreditCardNumber() != null) {
            creditCard.setBalance(creditCard.getBalance() - value);
            creditCardRepository.add(creditCard);
        }
    }

    /**
     * charge - charge the account holder.
     * @param accountHolder the account holder to charge
     * @param value the value to charge
     */
    public void charge(String accountHolder, Double value) {
        CreditCard creditCard = creditCardRepository.findCreditCard(accountHolder);
        if (creditCard.getCreditCardNumber() != null) {
            double presumedNewBalance = creditCard.getBalance() + value;
            if (presumedNewBalance <= creditCard.getLimit()) {
                creditCard.setBalance(presumedNewBalance);
                creditCardRepository.add(creditCard);
            } else {
                LOGGER.info("charge above limit attempted");
            }
        }
    }
}
