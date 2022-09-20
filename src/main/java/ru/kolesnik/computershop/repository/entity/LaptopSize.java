package ru.kolesnik.computershop.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "laptop_sizes")
public class LaptopSize {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "size_value")
    @NotNull
    @JsonProperty("value")
    private Integer sizeValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LaptopSize that = (LaptopSize) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
