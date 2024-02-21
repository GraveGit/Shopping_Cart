package api.service;

import api.dto.CustomerDTO;
import api.entity.Customer;
import api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Создает нового клиента на основе переданных данных.
     *
     * @param dto данные клиента для создания
     * @return созданный объект Customer
     */
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
