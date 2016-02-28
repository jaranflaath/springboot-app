package no.kodehuset.springboot.config

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    CommandLineRunner startupInfoPrinter() {

        return new CommandLineRunner() {
            @Override
            void run(String... args) throws Exception {
                println "This is our web service - at your service"
            }
        }
    }
}
