package ru.shop.shoppingcart.controller.v1;

import ru.shop.shoppingcart.service.OrderDetailService;
import ru.shop.shoppingcart.dto.OrderDetailDTO;
import ru.shop.shoppingcart.entity.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetailDTO dto) {
        return ResponseEntity.ok(orderDetailService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> readAll() {
        return ResponseEntity.ok(orderDetailService.readAll());
    }

    @GetMapping("/find-by-order")
    public ResponseEntity<List<OrderDetail>> readAllById(@RequestParam List<Integer> ids) {
        return ResponseEntity.ok(orderDetailService.readAllById(ids));
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<List<OrderDetail>> findByOrderId(@PathVariable Integer order_id) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(order_id);
        return ResponseEntity.ok(orderDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        orderDetailService.delete(id);
        return ResponseEntity.ok().build();
    }
}
