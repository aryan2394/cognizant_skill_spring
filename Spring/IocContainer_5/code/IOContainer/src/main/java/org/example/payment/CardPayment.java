package org.example.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cardPayment")
public class CardPayment implements PaymentService {
    @Override
    public void pay()
    {
        System.out.println("payment done by card");
    }
}
