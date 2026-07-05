package in.shriji.SpringBootDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {
//    @Value("${payment-gateway.type}")
//    private String type;
//    @Value("${payment-gateway.retry-count:1}")
//    private int retryCount;
//
//    // Getter for type
//    public String getType() {
//        return type;
//    }
//
//    // Setter for type
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    // Getter for retryCount
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    // Setter for retryCount
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;

//    these is for @Value
//    ab @ConfiguationProperty
    private PaymentProperty paymentProperty;
    public PaymentGateway(PaymentProperty paymentProperty)
    {
        this.paymentProperty=paymentProperty;
    }
    public String getType()
    {
        return paymentProperty.getType();
    }
    public int getRetryCount()
    {
        return paymentProperty.getRetryCount();
    }


    }

