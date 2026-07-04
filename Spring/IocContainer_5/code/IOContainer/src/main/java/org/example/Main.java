package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        matlab ki ioc container ko start karo using annotion bases configuration
//        ab sab kuch ho gaya hoga matlab ki objects ban gaye honge buss humein uske function ko normzlly run karna hai humein objects banan nahi hai
//        buss ek kaam kar lena abhi OrderService class mein PaymentServie ki cheezein hata do because wo abhi aage dekhenge
//        OrderService order=context.getBean(OrderService.class);
//        order.placeOrder();
//
//        Payment p=context.getBean(Payment.class);
//        p.pay();

//        Output is :
//        order placed
//        payment done

//        ab inn lines ka matlab samjaho ab tak saare ioc container mein saare class ke beans (objects bana gaye ho lekin aapko chahiye kya and kya karrna hai wo toh bataoge
//         pahle kya karte hum ki jaise humein order place karna hai
//        OrderService order=new OrderService();
//        aise karte the lkein humne toh ioc container ko bol hi diya hai beans banane ke liye toh wo bana chuka hoga buss humein uss object ko use karrna hai

//        OrderService order=context.getBean(OrderService.class);
//        order.placeOrder();

//        ab yaha pe humne autowired kar diya hai matlab ki humne wiring bhi kar di hai matlab jisko jo class chahaiye wo sab kar di hai

//        AB HUM DEKH RAHE Hai jab component fails then kya hoga
            Student s=context.getBean(Student.class);
            System.out.println(s.getName());
//            error is:No qualifying bean of type 'org.example.Student' available
//        when humne @Bean use nahi kiya hai then
    }
}
