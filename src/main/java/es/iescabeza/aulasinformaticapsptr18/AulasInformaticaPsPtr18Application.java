package es.iescabeza.aulasinformaticapsptr18;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase encargada de hacer funcionar los endpoints y la base de datos
 */
@SpringBootApplication
public class AulasInformaticaPsPtr18Application implements CommandLineRunner {

    /**
     * Main encargado de lanzar el servicio Rest con los endpoints
     * @param args argumentos
     */
    public static void main(String[] args) {
        SpringApplication.run(AulasInformaticaPsPtr18Application.class, args);
    }

    /**
     * Run encargado de hacer funcionar la base de datos
     * @param args argumentos
     * @throws Exception excepcion general
     */
    @Transactional(readOnly = false)
    @Override
    public void run(String... args) throws Exception {

    }

}
