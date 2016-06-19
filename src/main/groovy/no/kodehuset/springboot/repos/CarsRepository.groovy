package no.kodehuset.springboot.repos

import no.kodehuset.springboot.domain.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarsRepository extends JpaRepository<Car, Long> {
}
