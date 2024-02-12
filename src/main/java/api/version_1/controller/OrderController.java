package api.version_1.controller;

import api.version_1.entity.Order;
import api.version_1.dto.OrderDTO;
import api.version_1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer_order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDTO dto) {
        return ResponseEntity.ok(orderService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Order>> readAll() {
        return ResponseEntity.ok(orderService.readAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> readById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.readById(id));

    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(order));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        orderService.delete(id);
        return HttpStatus.OK;
    }
}
