package ru.kolesnik.computershop.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class HddDto extends ProductDto {

    @NotNull
    @JsonProperty("capacity_gb")
    private Long capacityGb;

}
