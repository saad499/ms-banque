package com.example.msbanque;

import com.example.msbanque.entities.Client;
import com.example.msbanque.entities.Compte;
import com.example.msbanque.entities.TypeCompte;
import com.example.msbanque.repositories.ClientRepository;
import com.example.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration,
                            ClientRepository clientRepository){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Compte.class);
            Client c1 = clientRepository.save(new Client(null,"saad",null));
            Client c2 = clientRepository.save(new Client(null,"badr",null));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random()*91000, new Date(), TypeCompte.COURANT, c2));
            compteRepository.save(new Compte(null, Math.random()*92300, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.findAll().forEach(c ->{
                System.out.println(c.getSolde());
            });
        };
    }
}
