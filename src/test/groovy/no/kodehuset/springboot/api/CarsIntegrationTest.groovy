package no.kodehuset.springboot.api

import groovy.json.JsonSlurper
import no.kodehuset.springboot.Application
import no.kodehuset.springboot.domain.Car
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
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


    @Test
    void listShouldReturnAllCars() {

        String response = restTemplate.getForEntity("http://localhost:" + port + "/cars", String).body

        def json = new JsonSlurper().parseText(response)
        assertEquals(3, json.size())
    }


    @Test
    void postShouldCreateNewCar() {

        String response = restTemplate.postForEntity("http://localhost:" + port + "/cars",
                new Car(brand: "Xray", model: "T4 2016", type: "touring", scale: 10, owned: false), String).body;

        println response

        def json = new JsonSlurper().parseText(response)
        assertEquals(1, json.size())
    }

}
