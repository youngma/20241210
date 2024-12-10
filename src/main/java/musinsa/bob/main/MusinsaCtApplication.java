package musinsa.bob.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusinsaCtApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusinsaCtApplication.class, args);
    }

}
