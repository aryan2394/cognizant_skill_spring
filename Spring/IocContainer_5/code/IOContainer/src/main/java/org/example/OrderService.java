package org.example;

import org.example.payment.CardPayment;
import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//matlab ki ab iss class ka OrderService ka object(beans matlab ki aisa object jo ioc cotainer craete karat haia dn manage karta hai )

public class OrderService {


//    private PaymentService p;
//    these is constructor injection
//    public OrderService(Payment p)
//    {
//        this.p=p;
//}

//    these is setter dependency injection matlab we are injecting the depenedency through the setter method lekin
//    except constructor injection humein sab jagah @Autowired daalan jarrori hai warna inject nahi hoga
//    @Autowired
//    public void setP(Payment p) {
//        this.p = p;
//    }

// ab humein inetrafec ke through jab karna hai
    private PaymentService p;
    public OrderService(@Qualifier("cardPayment") PaymentService p)
    {
        this.p=p;
    }
    public void placeOrder()
    {
        p.pay();
        System.out.println("order placed");
    }

}
