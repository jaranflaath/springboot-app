package no.kodehuset.springboot.config

import no.kodehuset.springboot.domain.Car
import no.kodehuset.springboot.repos.CarsRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    CommandLineRunner initialDataSetup(CarsRepository carsRepository) {

        return new CommandLineRunner() {

            @Override
            void run(String... args) throws Exception {
                carsRepository.save(new Car(brand: "Serpent", model: "Eryx 4", type: "Touring", scale: 10))
                carsRepository.save(new Car(brand: "Serpent", model: "Cobra 811", type: "Buggy", scale: 8))

                println "Listing saved cars for verification:"
                carsRepository.findAll().forEach({ car -> println "$car.brand $car.model" })
            }
        }
    }
}
