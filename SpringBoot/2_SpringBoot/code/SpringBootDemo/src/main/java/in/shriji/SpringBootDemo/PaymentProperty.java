package in.shriji.SpringBootDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-gateway")
public class PaymentProperty {
    private String type;
    private int retryCount;
    public String getType() {
        return type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public void setType(String type) {
        this.type = type;
    }

}
