package projects.pizzeria.service;

import org.springframework.stereotype.Service;
import projects.pizzeria.persistence.entity.Customer;
import projects.pizzeria.persistence.repository.CustomerRespository;

@Service
public class CustomerService {
    private final CustomerRespository customerRespository;

    public CustomerService(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }
    public Customer getByPhone(String phone){
        return customerRespository.findByPhoneNumber(phone);
    }
}
