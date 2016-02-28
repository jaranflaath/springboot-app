package no.kodehuset.springboot.api

import no.kodehuset.springboot.domain.Car
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value="/cars", produces = "application/json; charset=utf-8")
class Cars {

    @RequestMapping("")
    def list() {

        [
                new Car(brand: "Serpent", model: "S411 RTR", type: "Touring", scale: 10, owned: true),
                new Car(brand: "Serpent", model: "Cobra 2.1 811 Be", type: "Buggy", scale: 8, owned: true),
                new Car(brand: "Serpent", model: "S411 Eryx 4.0", type: "Touring", scale: 10, owned: false)
        ]
    }
}
