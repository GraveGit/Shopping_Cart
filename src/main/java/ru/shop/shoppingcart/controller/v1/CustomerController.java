package ru.shop.shoppingcart.controller.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.shoppingcart.dto.CustomerDTO;
import ru.shop.shoppingcart.entity.Customer;
import ru.shop.shoppingcart.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(customerService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Customer>> readAll(Pageable pageable) {
        Page<Customer> customers = customerService.readAll(pageable);
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/")
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.update(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

}
