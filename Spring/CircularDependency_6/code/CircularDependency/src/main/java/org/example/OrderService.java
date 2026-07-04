package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private PaymentService payment;
//    public OrderService(PaymentService payment)
//    {
//        this.payment=payment;
//    }
    public void placeOrder()
    {
        payment.pay();
        getDetails();
        System.out.println("order placed");
    }
    public void getDetails()
    {
        System.out.println("order details");
    }
}
