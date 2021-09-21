package com.example.my_welt;

import DAO.MenuRepository;
import DAO.WarenkorbRepository;
import Entity.Menu;
import Entity.Warenkorb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
//si on ne met pas tout dans un meme package, il faudra specifier ou se trouve les elements
//scanBAsePackages permet de scanner les autres packages, on doit y renseigner tous les packages
@SpringBootApplication (scanBasePackages = {"RestController","Entity","DAO"})
//indiquer le dossier des Daos
@EnableJpaRepositories("DAO")
//indiquer le package des ENtity
@EntityScan("Entity")
public class MyWeltApplication implements CommandLineRunner {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    WarenkorbRepository warenkorbRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyWeltApplication.class, args);
        System.out.println("Das System ist Up");
    }

    @Override
    public void run(String... args) throws Exception {
        if (menuRepository.findAll().isEmpty()) {
            Menu menu1 = new Menu(null, "Laptop", new ArrayList<>());
            Menu menu2 = new Menu(null, "Laptop", new ArrayList<>());
            Menu menu3 = new Menu(null, "Laptop", new ArrayList<>());

            menuRepository.save(menu1);
            menuRepository.save(menu2);
            menuRepository.save(menu3);


            Warenkorb warenkorb1 = new Warenkorb(null, new ArrayList<>());
            Warenkorb warenkorb2 = new Warenkorb(null, new ArrayList<>());

            warenkorbRepository.save(warenkorb1);
            warenkorbRepository.save(warenkorb2);


            warenkorb1.addMenu(menu1);
            warenkorb1.addMenu(menu2);

            warenkorb2.addMenu(menu3);
            warenkorb2.addMenu(menu2);

            warenkorbRepository.save(warenkorb1);
            warenkorbRepository.save(warenkorb2);
        }




    }
}
