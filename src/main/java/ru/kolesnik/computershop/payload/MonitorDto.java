package ru.kolesnik.computershop.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorDto extends ProductDto {

    @NotNull
    private BigDecimal diagonal;

}
