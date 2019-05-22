package com.smart.context;

import com.smart.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kqyang on 2019/5/22.
 */
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setColor("红色");
        car.setMaxSpeed(200);
        return car;
    }
}
