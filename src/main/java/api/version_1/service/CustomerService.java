package api.version_1.service;

import lombok.AllArgsConstructor;
import api.version_1.dto.CustomerDTO;
import api.version_1.entity.Customer;
import api.version_1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer create(CustomerDTO dto) {
        Customer customer = Customer.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();

        return customerRepository.save(customer);
    }

    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    public Customer readById(Integer id) {
        return  customerRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Cannot find customer by id" + id));
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
