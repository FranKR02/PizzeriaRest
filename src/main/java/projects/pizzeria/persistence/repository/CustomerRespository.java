package projects.pizzeria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projects.pizzeria.persistence.entity.Customer;

@Repository
public interface CustomerRespository extends ListCrudRepository<Customer, Long> {
    @Query(value = "SELECT c FROM Customer c WHERE c.phoneNumber = :phone")
    Customer findByPhoneNumber(@Param("phone") String phone);

}
