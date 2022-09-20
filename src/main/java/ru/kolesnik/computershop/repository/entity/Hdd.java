package ru.kolesnik.computershop.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
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
@Table(name = "hdds", uniqueConstraints = {@UniqueConstraint(columnNames = {"series_number", "manufacturer_name"})})
public class Hdd extends Product {

    @Column(name = "capacity_gb")
    @NotNull
    @JsonProperty("capacity_gb")
    private Long capacityGb;

    public Hdd(Long seriesNumber, String manufacturerName, BigDecimal price, Long numberInStock, Long capacityGb) {
        super(seriesNumber, manufacturerName, price, numberInStock);
        this.capacityGb = capacityGb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Hdd hdd = (Hdd) o;
        return id != null && Objects.equals(id, hdd.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
