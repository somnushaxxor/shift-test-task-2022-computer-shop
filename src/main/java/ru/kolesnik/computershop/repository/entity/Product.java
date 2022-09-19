package ru.kolesnik.computershop.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@JsonPropertyOrder({"id", "series_number", "manufacturer_name", "price", "number_in_stock"})
public abstract class Product {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name = "series_number")
    @NotNull
    @JsonProperty("series_number")
    protected Long seriesNumber;

    @Column(name = "manufacturer_name")
    @NotNull
    @JsonProperty("manufacturer_name")
    protected String manufacturerName;

    @NotNull
    protected BigDecimal price;

    @Column(name = "number_in_stock")
    @NotNull
    @JsonProperty("number_in_stock")
    protected Long numberInStock;

    public Product(Long seriesNumber, String manufacturerName, BigDecimal price, Long numberInStock) {
        this.seriesNumber = seriesNumber;
        this.manufacturerName = manufacturerName;
        this.price = price;
        this.numberInStock = numberInStock;
    }

}
