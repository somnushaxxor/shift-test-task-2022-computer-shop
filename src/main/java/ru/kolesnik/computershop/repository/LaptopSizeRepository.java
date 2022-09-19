package ru.kolesnik.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolesnik.computershop.repository.entity.LaptopSize;

import java.util.Optional;

@Repository
public interface LaptopSizeRepository extends JpaRepository<LaptopSize, Long> {

    Optional<LaptopSize> findBySizeValue(Integer value);

}
