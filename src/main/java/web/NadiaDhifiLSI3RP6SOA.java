package web;

import entites.Compte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositries.CompteRepository;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repositries") // Active la configuration des dépôts JPA
@EntityScan(basePackages = "entities") // Active la recherche des entités JPA

public class NadiaDhifiLSI3RP6SOA{

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.run(NadiaDhifiLSI3RP6SOA.class, args).getClass());

    }

    @Bean
    public CommandLineRunner initData(CompteRepository CompteRepository) {
        return args -> {
            // Ajout de données de compte initiales
            Compte compte1 = new Compte();
            compte1.setSolde(1500.0);
            compte1.setDateCreation(new Date());
            compte1.setType(Compte.typeCompte.EPARGNE);
            compte1.setEtat(Compte.etatCompte.BLOQUE);

            Compte compte2 = new Compte();
            compte2.setSolde(2000.0);
            compte2.setDateCreation(new Date());
            compte2.setType(Compte.typeCompte.EPARGNE);
            compte2.setEtat(Compte.etatCompte.ACTIVE);

            Compte compte3 = new Compte();
            compte3.setSolde(3000.0);
            compte3.setDateCreation(new Date());
            compte3.setType(Compte.typeCompte.COURANT);
            compte3.setEtat(Compte.etatCompte.SUSPENDU);
            Compte compte4 = new Compte();
            compte4.setSolde(60000.0);
            compte4.setDateCreation(new Date());
            compte4.setType(Compte.typeCompte.EPARGNE);
            compte4.setEtat(Compte.etatCompte.ACTIVE);

            // Sauvegarde des comptes dans le référentiel
            CompteRepository.save(compte1);
            CompteRepository.save(compte2);
            CompteRepository.save(compte3);

            // Affichage des soldes des comptes enregistrés dans la console
            CompteRepository.findAll().forEach(compte -> System.out.println(" Compte #" + compte.getId() + ": " + "  Type de Compte:  " + compte.getType() + "  Etat de compte:  " + compte.getEtat() + "  Solde du compte :" + compte.getSolde()));

        };
    }}
