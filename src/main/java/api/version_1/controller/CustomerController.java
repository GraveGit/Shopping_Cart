package api.version_1.controller;

import api.version_1.service.CustomerService;
import lombok.AllArgsConstructor;
import api.version_1.dto.CustomerDTO;
import api.version_1.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO dto) {
        return new ResponseEntity<>(customerService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> readAll() {
        return new ResponseEntity<>(customerService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        customerService.delete(id);
        return HttpStatus.OK;
    }

}
