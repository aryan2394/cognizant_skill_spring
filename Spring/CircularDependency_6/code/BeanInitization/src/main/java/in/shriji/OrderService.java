package in.shriji;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderService {
    public OrderService()
    {
        System.out.println("order object created");
    }

}
