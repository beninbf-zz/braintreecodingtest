package com.braintree.challenge.model;

import java.io.Serializable;

/**
 *
 * <code>CreditCard</code> a com.braintree.challenge.model class for representing a credit card.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class CreditCard implements Serializable, Comparable<CreditCard> {

    private static final long serialVersionUID = -8010198041701203260L;

    private String accountHolder;

    private String creditCardNumber;

    private Double limit;

    private Double balance;

    /**
     * CreditCard constructor.
     */
    public CreditCard() {}

    /**
     * getAccountHolder - return accountHolder.
     * @return String
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * setAccountHolder - sets the account holder.
     * @param accountHolder String
     */
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    /**
     * getCreditCardNumber - gets the credit card number.
     * @return creditCardNumber
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * setCreditCardNumber - sets the credit number.
     * @param creditCardNumber String
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * getLimit - gets the limit.
     * @return limit
     */
    public Double getLimit() {
        return limit;
    }

    /**
     * setLimit - set the limit.
     * @param limit Double
     */
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    /**
     * getBalance - gets the balance.
     * @return balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     * @param balance Double
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * compareTo - sets the natural ordering for credit cards.
     *
     * @param creditCard object
     * @return int
     */
    public int compareTo(CreditCard creditCard) {
        return this.accountHolder.compareTo(creditCard.getAccountHolder());
    }

    @Override
    public String toString() {
        return String.format("CreditCard{accountHolder=%s, creditCardNumber=%s, limit=%s, balance=%s}",
           this.accountHolder, this.creditCardNumber, this.limit, this.balance);
    }
}
