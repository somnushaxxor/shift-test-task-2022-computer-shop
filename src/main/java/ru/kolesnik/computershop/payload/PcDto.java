package ru.kolesnik.computershop.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public final class PcDto extends ProductDto {

    @NotNull
    @JsonProperty("form_factor")
    private String formFactorName;

}
