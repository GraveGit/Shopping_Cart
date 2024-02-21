package api.controller.v1;

import api.entity.Order;
import api.dto.OrderDTO;
import api.service.OrderService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
