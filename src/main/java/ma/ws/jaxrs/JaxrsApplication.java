package ma.ws.jaxrs;

import ma.ws.jaxrs.entities.Compte;
import ma.ws.jaxrs.entities.TypeCompte;
import ma.ws.jaxrs.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JaxrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaxrsApplication.class, args);
    }

    // Méthode d'initialisation appelée au démarrage de l'application
    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            // Création de 3 comptes aléatoires
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));

            // Affichage dans la console pour vérification
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
