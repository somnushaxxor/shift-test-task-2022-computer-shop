package ru.kolesnik.computershop.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public abstract class ProductDto {

    @NotNull
    @JsonProperty("series_number")
    protected Long seriesNumber;

    @NotNull
    @JsonProperty("manufacturer_name")
    protected String manufacturerName;

    @NotNull
    protected BigDecimal price;

    @NotNull
    @JsonProperty("number_in_stock")
    protected Long numberInStock;

}
