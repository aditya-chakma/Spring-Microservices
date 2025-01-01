package aditya.tuorials.spring.spring_recap;

import aditya.tuorials.spring.spring_recap.runner.GameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringRecapApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringRecapApplication.class, args);
        System.out.println("Hello world");

        GameRunner gameRunner = applicationContext.getBean("gameRunner", GameRunner.class);
        gameRunner.run();
    }

}
