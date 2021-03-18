package br.com.calljef.workshopmongo.config;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.domain.Fine;
import br.com.calljef.workshopmongo.dto.DriverDTO;
import br.com.calljef.workshopmongo.dto.PilotDTO;
import br.com.calljef.workshopmongo.dto.VehicleDTO;
import br.com.calljef.workshopmongo.repositories.DriverRepository;
import br.com.calljef.workshopmongo.repositories.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private FineRepository fineRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        driverRepository.deleteAll();
        fineRepository.deleteAll();

        Driver d1 = new Driver(null, "Jeferson", "123456789");
        Driver d2 = new Driver(null, "Ferreira", "456789123");
        Driver d3 = new Driver(null, "Nascimento", "678912345");


        Fine f1 = new Fine(null, sdf.parse("10/03/2021"),"BR116", "speed up the allowed",new PilotDTO(d1));
        Fine f2 = new Fine(null, sdf.parse("05/01/2021"),"Avenida Manoel RIbas", "irregular parking",new PilotDTO(d1));

        driverRepository.saveAll(Arrays.asList(d1,d2,d3));

        VehicleDTO v1 = new VehicleDTO("Ford k", "AABB1234", new PilotDTO(d1));
        VehicleDTO v2 = new VehicleDTO("Fiat Punto", "BBCC4567", new PilotDTO(d2));
        VehicleDTO v3 = new VehicleDTO("Fiat Palio", "DDFF4567", new PilotDTO(d3));


        f1.getVehicle().addAll(Arrays.asList(v1));
        f2.getVehicle().addAll(Arrays.asList(v3));

        fineRepository.saveAll(Arrays.asList(f1, f2));

        d1.getFines().addAll(Arrays.asList(f1, f2));
        driverRepository.save(d1);
    }
}
