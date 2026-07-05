package in.shriji;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService payment;
    public OrderService(PaymentService payment)
    {
        this.payment=payment;
    }
    public void placeOrder()
    {
        payment.pay();
        System.out.println("order placed");
    }
}
