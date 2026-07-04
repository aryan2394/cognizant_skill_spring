package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        sabse pale ioc container ko up karo using annotaionBaseConfiguration
//        OrderService order=context.getBean(OrderService.class);
//        order.placeOrder();

//        abhi tak normal flow ki payment service ka bean ban gaya hoga and usko paas kar diya hoga OrderService ke beans mein
//        lekin jaan bujh ke depenedency create karte hai like OrderService depend on OrderService and PaymentService depend on OrderService
//        if you will see the

        OrderService order=context.getBean(OrderService.class);
        order.placeOrder();
//        error is :Is there an unresolvable circular reference or an asynchronous initialization dependency?
    }
}
