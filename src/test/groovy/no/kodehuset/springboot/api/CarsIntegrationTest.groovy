package no.kodehuset.springboot.api

import groovy.json.JsonSlurper
import no.kodehuset.springboot.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.web.client.RestTemplate

import static org.junit.Assert.assertEquals

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(Application)
@WebIntegrationTest(randomPort = true)
class CarsIntegrationTest {

    @Value('${local.server.port}')
    int port

    RestTemplate restTemplate = new RestTemplate()

    @Test
    void listShouldReturnAllCars() {

        String response = restTemplate.getForEntity("http://localhost:" + port + "/cars", String).body

        def json = new JsonSlurper().parseText(response)
        assertEquals(2, json.size())
    }


}
