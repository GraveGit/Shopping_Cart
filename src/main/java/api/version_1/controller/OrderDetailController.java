package api.version_1.controller;

import api.version_1.service.OrderDetailService;
import api.version_1.dto.OrderDetailDTO;
import api.version_1.entity.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_detail")
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

    @GetMapping("/order")
    public ResponseEntity<List<OrderDetail>> readAllById(@RequestParam List<Integer> ids) {
        return ResponseEntity.ok(orderDetailService.readAllById(ids));
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<List<OrderDetail>> findByOrderId(@PathVariable Integer order_id) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(order_id);
        return ResponseEntity.ok(orderDetails);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        orderDetailService.delete(id);
        return HttpStatus.OK;
    }
}
