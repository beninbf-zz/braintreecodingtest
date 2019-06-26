package com.braintree.challenge.builder;

import com.braintree.challenge.model.CreditCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.braintree.challenge.util.NumberUtility.getDouble;

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
public class CreditCardBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardBuilder.class);

    private String accountHolder;

    private String creditCardNumber;

    private String limit;

    private Double balance;

    /**
     * Set the account holder.
     * @param accountHolder account holder
     * @return CreditCardBuilder
     */
    public CreditCardBuilder accountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
        return this;
    }

    /**
     * Set the creditCardNumber.
     * @param creditCardNumber credit card number
     * @return CreditCardBuilder
     */
    public CreditCardBuilder creditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    /**
     * Set the limit.
     * @param limit String
     * @return CreditCardBuilder
     */
    public CreditCardBuilder limit(String limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Set the balance.
     * @param balance Double
     * @return CreditCardBuilder
     */
    public CreditCardBuilder balance(Double balance) {
        this.balance = balance;
        return this;
    }

    /**
     * build - builds a credit card object.
     * @return CreditCard
     */
    public CreditCard build() {
        if (this.accountHolder != null && this.creditCardNumber != null && this.limit != null) {
            CreditCard creditCard = new CreditCard();
            creditCard.setAccountHolder(this.accountHolder);
            creditCard.setCreditCardNumber(this.creditCardNumber);
            creditCard.setLimit(getDouble(limit));
            if (this.balance == null) {
                creditCard.setBalance(0.0d);
            }
            return creditCard;
        } else {
            LOGGER.error("all necessary params are not set");
            throw new IllegalArgumentException("Account holder, credit card number, and limit must be present to create a credit card");
        }
    }
}
