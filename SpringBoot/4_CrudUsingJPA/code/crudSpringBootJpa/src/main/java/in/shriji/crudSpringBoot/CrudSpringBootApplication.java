package in.shriji.crudSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication()
public class CrudSpringBootApplication {

	public static void main(String[] args) {

        SpringApplication.run(CrudSpringBootApplication.class, args);
    }

}
