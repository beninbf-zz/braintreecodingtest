package com.braintree.challenge;

import com.braintree.challenge.builder.CreditCardBuilder;
import com.braintree.challenge.config.CreditConfig;
import com.braintree.challenge.enums.CommandEnum;
import com.braintree.challenge.facade.CreditFacade;
import com.braintree.challenge.model.CreditCard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * <code>CreditCardProcessor</code> processes each credit transaction.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
@Import(CreditConfig.class)
@Component
public class CreditCardProcessor implements CommandLineRunner {
    private static final String BLANK_SPACE_REGEX = "\\s+";

    @Inject
    private CreditFacade creditFacade;

    @Override
    public void run(String... args) throws Exception {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] arguments = line.split(BLANK_SPACE_REGEX);
                if (arguments != null && arguments.length > 0) {
                    CommandEnum command = CommandEnum.getCommand(arguments[0]);
                    switch (command) {
                        case ADD:
                            if (arguments.length == 4) {
                                CreditCard creditCard = new CreditCardBuilder()
                                    .accountHolder(arguments[1])
                                    .creditCardNumber(arguments[2])
                                    .limit(arguments[3])
                                    .build();
                                creditFacade.add(creditCard);
                            }
                            break;
                        case CHARGE:
                            if (arguments.length == 3) {
                                creditFacade.charge(arguments[1], arguments[2]);
                            }
                            break;
                        case CREDIT:
                            if (arguments.length == 3) {
                                creditFacade.credit(arguments[1], arguments[2]);
                            }
                            break;
                        default:
                            break;
                    }
                    line = bufferedReader.readLine();
                }
            }

            List<String> summary = creditFacade.getCreditAccountsSummary();
            System.out.println("*********************************");
            System.out.println("*          OUTPUT BELOW         *");
            System.out.println("*********************************");
            for (String item: summary) {
                System.out.println(item);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
