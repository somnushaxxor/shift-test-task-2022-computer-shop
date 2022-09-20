package ru.kolesnik.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolesnik.computershop.repository.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>, ProductRepository {

}
