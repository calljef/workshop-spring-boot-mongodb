package br.com.calljef.workshopmongo.config;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {

        driverRepository.deleteAll();

        Driver d1 = new Driver(null, "Jeferson", "123456789");
        Driver d2 = new Driver(null, "Ferreira", "456789123");
        Driver d3 = new Driver(null, "Nascimento", "678912345");

        driverRepository.saveAll(Arrays.asList(d1,d2,d3));
    }
}
