package by.bsu.frankovski.web.repositories;

import by.bsu.frankovski.web.models.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> getByCountry_A2Code(String a2, Pageable pageable);
}
