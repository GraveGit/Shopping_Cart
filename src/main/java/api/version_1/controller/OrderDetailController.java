package api.version_1.controller;

import api.version_1.service.OrderDetailService;
import lombok.AllArgsConstructor;
import api.version_1.dto.OrderDetailDTO;
import api.version_1.entity.OrderDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_detail")
@AllArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetailDTO dto) {
        return new ResponseEntity<>(orderDetailService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> readAll() {
        return new ResponseEntity<>(orderDetailService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDetail>> readAllById(@RequestParam List<Integer> ids) {
        return new ResponseEntity<>(orderDetailService.readAllById(ids), HttpStatus.OK);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<List<OrderDetail>> findByOrderId(@PathVariable Integer order_id) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(order_id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        orderDetailService.delete(id);
        return HttpStatus.OK;
    }
}
