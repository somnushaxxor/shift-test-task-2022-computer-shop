package ru.kolesnik.computershop.repository;

import ru.kolesnik.computershop.repository.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findBySeriesNumberAndManufacturerName(Long seriesNumber, String manufacturerName);

}
