package no.kodehuset.springboot.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Car {

    @Id
    @GeneratedValue
    Long id

    String brand, model, type

    Integer scale
}
