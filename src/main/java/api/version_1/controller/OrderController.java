package api.version_1.controller;

import api.version_1.entity.Order;
import lombok.AllArgsConstructor;
import api.version_1.dto.OrderDTO;
import api.version_1.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer_order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDTO dto) {
        return new ResponseEntity<>(orderService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> readAll() {
        return new ResponseEntity<>(orderService.readAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> readById(@PathVariable Integer id) {
        return new ResponseEntity<>(orderService.readById(id), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.update(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        orderService.delete(id);
        return HttpStatus.OK;
    }
}
