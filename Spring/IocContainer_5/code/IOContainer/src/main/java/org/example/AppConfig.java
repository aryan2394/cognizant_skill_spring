package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// dekho ye basically rule book hai for ioc container ko aapko kaun se class ke bean ko create,manage karna hai
//@Configuration matlba ye ek ek class hai jo ki Metadata hai ko store karegi
//@ComponentScan:ismein hum jo bhi package ka naam denge andar usmein jaake @Componnetn ko scan karega
@Configuration

@ComponentScan(".org.example")
public class AppConfig {
    @Bean
    public Student createUser()
    {
        return new Student("shriji",18);
    }
}
