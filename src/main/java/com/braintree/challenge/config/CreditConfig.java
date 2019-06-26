package com.braintree.challenge.config;

import com.braintree.challenge.facade.CreditFacade;
import com.braintree.challenge.facade.impl.CreditFacadeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.braintree.challenge.repository.CreditCardRepository;
import com.braintree.challenge.repository.impl.CreditCardRespositoryImpl;
import com.braintree.challenge.service.CreditService;
import com.braintree.challenge.service.CreditValidationService;
import com.braintree.challenge.service.impl.CreditServiceImpl;
import com.braintree.challenge.service.impl.LuhnValidationServiceImpl;


/**
 *
 * <code>CreditConfig</code> the spring configuration class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
@Configuration
@ComponentScan(basePackages = {"com.braintree.challenge.service", "com.braintree.challenge.repository"})
public class CreditConfig {

    /**
     * creditService - return my credit com.braintree.challenge.service bean.
     * @return CreditServiceImpl
     */
    @Bean
    public CreditService creditService() {
        return new CreditServiceImpl();
    }

    /**
     * creditCardRepository - get the credit card com.braintree.challenge.repository bean.
     * @return CreditCardRespositoryImpl
     */
    @Bean
    public CreditCardRepository creditCardRepository() {
        return new CreditCardRespositoryImpl();
    }

    /**
     * creditFacade - get the credit com.braintree.challenge.facade bean.
     * @return CreditFacadeImpl
     */
    @Bean
    public CreditFacade creditFacade() {
        return new CreditFacadeImpl();
    }

    /**
     * creditValidationService - get creditValidationService bean.
     * @return LuhnValidationServiceImpl
     */
    @Bean
    public CreditValidationService creditValidationService() {
        return new LuhnValidationServiceImpl();
    }
}
