package ru.kolesnik.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolesnik.computershop.repository.entity.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long>, ProductRepository {

}
