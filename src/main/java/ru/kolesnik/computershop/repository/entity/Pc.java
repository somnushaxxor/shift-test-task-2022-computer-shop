package ru.kolesnik.computershop.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "pcs", uniqueConstraints = {@UniqueConstraint(columnNames = {"series_number", "manufacturer_name"})})
public final class Pc extends Product {

    @ManyToOne
    @JoinColumn(name = "form_factor_id")
    @NotNull
    @JsonProperty("form_factor")
    private PcFormFactor formFactor;

    public Pc(Long seriesNumber, String manufacturerName, BigDecimal price, Long numberInStock,
              PcFormFactor formFactor) {
        super(seriesNumber, manufacturerName, price, numberInStock);
        this.formFactor = formFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pc pc = (Pc) o;
        return id != null && Objects.equals(id, pc.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
