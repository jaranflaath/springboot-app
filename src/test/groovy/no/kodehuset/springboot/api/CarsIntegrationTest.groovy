package no.kodehuset.springboot.api

import groovy.json.JsonSlurper
import no.kodehuset.springboot.domain.Car
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

import static org.junit.Assert.assertEquals

@RunWith(SpringRunner)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarsIntegrationTest {

    @LocalServerPort
    int port

    TestRestTemplate restTemplate = new TestRestTemplate("jaran", "s3rp3nt")


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
