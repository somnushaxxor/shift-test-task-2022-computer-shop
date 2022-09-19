package ru.kolesnik.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolesnik.computershop.repository.entity.PcFormFactor;

import java.util.Optional;

@Repository
public interface PcFormFactorRepository extends JpaRepository<PcFormFactor, Long> {

    Optional<PcFormFactor> findByName(String formFactorName);

}
