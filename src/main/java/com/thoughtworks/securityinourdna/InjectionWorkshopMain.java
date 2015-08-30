package com.thoughtworks.securityinourdna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class InjectionWorkshopMain {

    @Bean
    public UserRepo userRepo() {
        try {
            final ConnectionFactory connectionFactory = new ConnectionFactory();
            final UserRepo userRepo = new UserRepo(connectionFactory.createInMemoryDatabase());

            userRepo.addName("Alice", "Brown", "6b3a55e0261b0304143f805a24924d0c1c44524821305f31d9277843b8a10f4e");
            userRepo.addName("Bob", "Smith", "34c9b6ca63682155572447dbed32a8e6a91990982ec5b36a24c40dfe24595660");
            userRepo.addName("Eve", "Johnson", "e04d080e73c20efea9601b256572f77cf142ec8c32885a8febd57b48fb001fe3");
            userRepo.addName("Mallory", "Jones", "7b143e21a65c40486856fda967552591f8507b4f6a6426cabb97a872256a275a");
            userRepo.addName("Dan", "Williams", "e9b4fcd28f6c2db79a83111d554cacec51517bce70e69a0d6d8b5da3af0a8b1a");
            userRepo.addName("admin", "Almighty", "c16abba613aa32cf83b2b3bf164bc4873acf6ed2560a3563922f58915120e5c6");

            return userRepo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(InjectionWorkshopMain.class);
        app.run(args);
    }
}