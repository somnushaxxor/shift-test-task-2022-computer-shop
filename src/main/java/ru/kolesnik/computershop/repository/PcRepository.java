package ru.kolesnik.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolesnik.computershop.repository.entity.Pc;

@Repository
public interface PcRepository extends JpaRepository<Pc, Long>, ProductRepository {

}
