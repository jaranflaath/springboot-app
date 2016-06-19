package no.kodehuset.springboot.api

import no.kodehuset.springboot.repos.CarsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value="/cars", produces = "application/json; charset=utf-8")
class Cars {

    @Autowired
    CarsRepository carsRepository

    @RequestMapping("")
    def list() {

        carsRepository.findAll()
    }
}
