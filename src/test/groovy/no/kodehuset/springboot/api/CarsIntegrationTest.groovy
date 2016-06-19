package no.kodehuset.springboot.api

import groovy.json.JsonSlurper
import no.kodehuset.springboot.Application
import no.kodehuset.springboot.domain.Car
import no.kodehuset.springboot.repos.CarsRepository
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(Application)
@WebIntegrationTest(randomPort = true)
class CarsIntegrationTest {

    @Value('${local.server.port}')
    int port

    RestTemplate restTemplate = new TestRestTemplate("jaran", "s3rp3nt")


    @Autowired
    CarsRepository carsRepository

    @After
    public void cleanup() {
        carsRepository.deleteAll();
    }

    @Test
    void listShouldReturnAllCars() {

        carsRepository.save(new Car(brand: "Serpent", model: "Eryx 4", type: "Touring", scale: 10))
        carsRepository.save(new Car(brand: "Serpent", model: "Cobra 811", type: "Buggy", scale: 8))

        String response = restTemplate.getForEntity("http://localhost:" + port + "/cars", String).body

        def json = new JsonSlurper().parseText(response)
        assertEquals(2, json.size())
    }


    @Test
    void postShouldCreateNewCar() {

        String response = restTemplate.postForEntity("http://localhost:" + port + "/cars",
                new Car(brand: "Xray", model: "T4 2016", type: "touring", scale: 10), String).body;

        println response

        def json = new JsonSlurper().parseText(response)
        assertEquals(1, json.size())
    }

}
