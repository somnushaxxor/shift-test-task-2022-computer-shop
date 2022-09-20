package ru.kolesnik.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolesnik.computershop.repository.entity.Hdd;

@Repository
public interface HddRepository extends JpaRepository<Hdd, Long>, ProductRepository {

}
