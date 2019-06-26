import com.braintree.challenge.CreditCardProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * <code>Main</code> entry point for command line application.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 25, 2019   Braintree Code Challenge.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 25, 2019
 */
@SpringBootApplication(scanBasePackages={"com.braintree.challenge"})
public class Main {

    /**
     * main - entry point.
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(CreditCardProcessor.class, args);
    }
}
