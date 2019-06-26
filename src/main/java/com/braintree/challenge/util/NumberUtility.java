package com.braintree.challenge.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * <code>NumberUtility</code> a utility class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
public class NumberUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtility.class);

    private static final char DOLLAR_SIGN = '$';

    private NumberUtility(){}

    /**
     * getDouble - Given a string such as "$1000" return the double
     * 1000.0d
     * @param value String
     * @return Double
     */
    public static Double getDouble(String value) {
        if (value == null) {
            return null;
        }

        if (value.isEmpty()) {
            return null;
        }

        if (value.charAt(0) == DOLLAR_SIGN) {
            try {
                return Double.valueOf(value.substring(1));
            } catch (NumberFormatException nfe) {
                LOGGER.error("Limit is not a numerical value");
            }
        } else {
            return null;
        }
        return null;
    }
}
