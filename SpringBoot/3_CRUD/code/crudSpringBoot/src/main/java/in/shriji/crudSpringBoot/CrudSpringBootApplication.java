package in.shriji.crudSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CrudSpringBootApplication {

	public static void main(String[] args) {

        SpringApplication.run(CrudSpringBootApplication.class, args);
//        System.out.println("shri ji");
//        error is coming:

//        Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
//        application toh chal jaana chahiye tha kya ho gaya bhai
//        dekho humra paas @SoringBootApplication hai jo 3 aur annotaion hai uske paas and one is @EnableAutoConfiguration
//        iske baare mein humne bataya tha ki ye automatically depeenddecies check karta hai and uske hisab se jo compularsary bean hai usko download kar deta hai ussi tarah usne kuch beans banane ki koshsih ki and error aa gaya
//        error hai Datasource ka wo bean banane gaya and error aa gaya ye class jo hai basically iska bean banane ke liye humein usenrame and passowrd of mysql dena hota hai in application.properties jo humne abhi nahi diya isliye ye isko beans bnhia bana paaya and error de diya
//        toh kya karein abhi kuch nahi aap @SpringBootApplication(exclude = exclude = DataSourceAutoConfiguration.class) kar do toh ab ye class ka bean wo nahi banayega

//

    }

}
