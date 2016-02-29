package no.kodehuset.springboot.api

import no.kodehuset.springboot.domain.Car
import org.omg.CORBA.Request
import org.springframework.http.HttpEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/cars", produces = "application/json; charset=utf-8")
class Cars {

    @RequestMapping(value = "", method = RequestMethod.GET)
    def list() {

        [
                new Car(brand: "Serpent", model: "S411 RTR", type: "Touring", scale: 10, owned: true),
                new Car(brand: "Serpent", model: "Cobra 2.1 811 Be", type: "Buggy", scale: 8, owned: true),
                new Car(brand: "Serpent", model: "S411 Eryx 4.0", type: "Touring", scale: 10, owned: false)
        ]
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
