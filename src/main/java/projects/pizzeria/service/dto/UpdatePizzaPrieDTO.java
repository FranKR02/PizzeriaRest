package projects.pizzeria.service.dto;

import lombok.Data;

@Data
public class UpdatePizzaPrieDTO {
    private Long pizzaId;
    private Double newPrice;
}
