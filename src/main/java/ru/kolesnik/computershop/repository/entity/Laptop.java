package ru.kolesnik.computershop.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "laptops", uniqueConstraints = {@UniqueConstraint(columnNames = {"series_number", "manufacturer_name"})})
public class Laptop extends Product {

    @ManyToOne
    @JoinColumn(name = "size_id")
    @NotNull
    private LaptopSize size;

    public Laptop(Long seriesNumber, String manufacturerName, BigDecimal price, Long numberInStock,
                  LaptopSize size) {
        super(seriesNumber, manufacturerName, price, numberInStock);
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Laptop laptop = (Laptop) o;
        return id != null && Objects.equals(id, laptop.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
