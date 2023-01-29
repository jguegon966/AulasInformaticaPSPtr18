package es.iescabeza.aulasinformaticapsptr18;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AulasInformaticaPsPtr18Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AulasInformaticaPsPtr18Application.class, args);
    }

    @Transactional(readOnly = false)
    @Override
    public void run(String... args) throws Exception {

    }

}
