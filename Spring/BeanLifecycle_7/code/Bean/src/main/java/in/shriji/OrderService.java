package in.shriji;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService payment;
    public OrderService()
    {
        System.out.println("order object created");
    }
    public void setPayment(PaymentService payment)
    {
        this.payment=payment;
    }
}
