package be.technocite.ecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class EcarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcarApplication.class, args);
    }


// @SpringBootApplication contient @Configuration donc la classe EcarApplication est une  classe de configuration
// on peut supprimer la classe ServletInitializer de configuration crée automatiquement et faire ceci :
// Donc on met directement le Bean dans notre EcarApplication

    // On peut même supprimer ce Bean car est déjà existant, ici c'est une redéclaration car EcarApplication est
    // @SpringBootApplication
    /*@Bean
    public EcarApplication anEcarApplication() {
        return new EcarApplication();
    }*/
}