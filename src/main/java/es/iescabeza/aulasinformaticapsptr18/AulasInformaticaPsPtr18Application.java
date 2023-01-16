package es.iescabeza.aulasinformaticapsptr18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class AulasInformaticaPsPtr18Application {

    public static void main(String[] args) {
        SpringApplication.run(AulasInformaticaPsPtr18Application.class, args);
    }

}
