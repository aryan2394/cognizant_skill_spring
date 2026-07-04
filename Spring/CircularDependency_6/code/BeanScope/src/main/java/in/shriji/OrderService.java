package in.shriji;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OrderService {
    public OrderService()
    {
        System.out.println("new order object created");
    }
    public void placeOrder()
    {
        System.out.println("order placed");
    }

}
