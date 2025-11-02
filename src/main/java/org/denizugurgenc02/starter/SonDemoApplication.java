package org.denizugurgenc02.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.denizugurgenc02")
@ComponentScan(basePackages = "org.denizugurgenc02")
@EnableJpaRepositories(basePackages = "org.denizugurgenc02")
public class SonDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonDemoApplication.class, args);
    }

}
