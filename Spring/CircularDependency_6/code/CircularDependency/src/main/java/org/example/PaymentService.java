package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
//    @Autowired
//    private OrderService orderService;
//    solution suing the filed or stter method
    public void pay()
    {
        System.out.println("payment done");
//        orderService.getDetails();
    }
}
