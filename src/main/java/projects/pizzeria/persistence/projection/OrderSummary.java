package projects.pizzeria.persistence.projection;

import java.time.LocalDateTime;

public interface OrderSummary {
    Long getIdOrder();
    String getCustomerName();
    LocalDateTime getOderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
