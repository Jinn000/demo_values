package ru.zav.demo_values;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoValuesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoValuesApplication.class, args);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Appcontext.xml");

        SolarSystem solarSystem = context.getBean(SolarSystem.class);
        System.out.println(solarSystem);

        context.close();
    }



}
