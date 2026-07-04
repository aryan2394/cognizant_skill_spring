package in.shriji;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order1=context.getBean(OrderService.class);
        OrderService order2=context.getBean(OrderService.class);
        OrderService order3=context.getBean(OrderService.class);

//        output is :
//        new order object created
//        matlab sirf ek baar object bana agar teen object bante toh teen baar new order placed print hota matlab ki
//        ioc container ne kya kiya hai order1,order2,order3 ko ek hi object ko point kar diya hai iska exmaple you can see
        System.out.println(order1==order2);
//        matlab if order1 address=order2 matlab dono objects same ko hi point kar rahe hai
//        Output is:true

//        aur agar aap multiple class jaise class A and B sab mein inject bhi karoge oth same hi object(bean) inject hoga sabmein kyonki bana hi ek hai toh jayega bhi toh ek hi


    }
}
