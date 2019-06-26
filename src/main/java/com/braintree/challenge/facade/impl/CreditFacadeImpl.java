package com.braintree.challenge.facade.impl;

import com.braintree.challenge.facade.CreditFacade;
import com.braintree.challenge.model.CreditCard;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.service.CreditService;
import com.braintree.challenge.service.CreditValidationService;
import com.braintree.challenge.util.NumberUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * <code>CreditFacade</code> an implementation for the CreditFacade.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
@Component
public class CreditFacadeImpl implements CreditFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditFacadeImpl.class);

    private static final String ERROR = "error";

    private static final String COLON = ":";

    private static final String BLANK_SPACE = " ";

    private static final String DOLLAR_SIGN = "$";

    @Inject
    private CreditCardRepository creditCardRespository;

    @Inject
    private CreditService creditService;

    @Inject
    private CreditValidationService creditValidationService;

    /**
     * add - adds a credit card object to storage.
     * @param creditCard String
     */
    public void add(CreditCard creditCard) {
        LOGGER.info("adding credit card");
        if (!creditValidationService.isValid(creditCard.getCreditCardNumber())) {
            LOGGER.info("invalid credit card number detected");
            creditCard.setCreditCardNumber(null);
        }
        creditCardRespository.add(creditCard);
    }

    /**
     * charge - applies a charge to a given account holders credit card.
     * @param accountHolder String
     * @param value Double
     */
    public void charge(String accountHolder, String value) {
        LOGGER.info("charging credit card");
        Double amount = NumberUtility.getDouble(value);
        if (amount != null) {
            creditService.charge(accountHolder, amount);
        }
    }

    /**
     * credit - applies a credit to a given account holders credit card.
     * @param accountHolder String
     * @param value Double
     */
    public void credit(String accountHolder, String value) {
        LOGGER.info("crediting credit card");
        Double amount = NumberUtility.getDouble(value);
        if (amount != null) {
            creditService.credit(accountHolder, amount);
        }
    }

    /**
     * getCreditAccountsSummary - return an array of strings represeting the balances
     * for all credit card customers.
     *
     * @return String[]
     */
    public List<String> getCreditAccountsSummary() {
        List<CreditCard> creditCardList = creditCardRespository.getSummary();
        Collections.sort(creditCardList);
        List<String> results = new ArrayList<>();
        for (CreditCard creditCard: creditCardList) {
            StringBuilder sb = new StringBuilder();
            sb.append(creditCard.getAccountHolder());
            sb.append(COLON);
            sb.append(BLANK_SPACE);
            if (creditCard.getCreditCardNumber() != null) {
                sb.append(DOLLAR_SIGN);
                sb.append(creditCard.getBalance());
            } else {
                sb.append(ERROR);
            }
            results.add(sb.toString());
        }
        return results;
    }
}
