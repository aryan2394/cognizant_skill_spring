package in.shriji.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

        ApplicationContext context=SpringApplication.run(SpringBootDemoApplication.class, args);
        PaymentGateway paymentGateway=context.getBean(PaymentGateway.class);
//        paymentGateway.setType("razorPay");
        System.out.println(paymentGateway.getType());
        System.out.println(paymentGateway.getRetryCount());
	}

}
