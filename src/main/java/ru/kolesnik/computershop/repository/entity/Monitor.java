package ru.kolesnik.computershop.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "monitors", uniqueConstraints = {@UniqueConstraint(columnNames = {"series_number", "manufacturer_name"})})
public class Monitor extends Product {

    @NotNull
    private BigDecimal diagonal;

    public Monitor(Long seriesNumber, String manufacturerName, BigDecimal price, Long numberInStock, BigDecimal diagonal) {
        super(seriesNumber, manufacturerName, price, numberInStock);
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Monitor monitor = (Monitor) o;
        return id != null && Objects.equals(id, monitor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
