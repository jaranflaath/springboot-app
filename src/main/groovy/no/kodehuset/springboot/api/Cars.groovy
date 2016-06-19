package no.kodehuset.springboot.api

import no.kodehuset.springboot.repos.CarsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/cars", produces = "application/json; charset=utf-8")
class Cars {

    @Autowired
    CarsRepository carsRepository

    @RequestMapping(value = "", method = RequestMethod.GET)
    def list() {

        carsRepository.findAll()
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    def create(@RequestBody Map<String, Object> payload) {

        println "Saving new car: " + payload

        [
                new Car(brand: payload.brand, model: payload.model, type: payload.type, scale: payload.scale,
                        owned: payload.owned)
        ]
    }
}
