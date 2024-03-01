package ru.shop.shoppingcart.service;

import ru.shop.shoppingcart.dto.CustomerDTO;
import ru.shop.shoppingcart.entity.Customer;
import ru.shop.shoppingcart.mapper.CustomerMapper;
import ru.shop.shoppingcart.repository.CustomerRepository;
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
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(dto);
        return customerRepository.save(customer);
    }

    /**
     * Получает список всех клиентов.
     *
     * @return Список всех клиентов.
     */
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    /**
     * Получает клиента по его ID.
     *
     * @param id ID клиента для поиска.
     * @return Клиент с указанным ID, если найден.
     * @throws RuntimeException если клиент с указанным ID не найден.
     */
    public Customer readById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find customer by id" + id));
    }

    /**
     * Обновляет или создает нового клиента.
     *
     * @param customer Клиент для обновления или создания.
     * @return Обновленный или созданный клиент.
     */
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Удаляет клиента по ID.
     *
     * @param id ID клиента для удаления.
     */
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
