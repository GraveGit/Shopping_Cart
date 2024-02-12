package api.version_1.service;

import lombok.AllArgsConstructor;
import api.version_1.dto.OrderDetailDTO;
import api.version_1.entity.OrderDetail;
import api.version_1.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderDetail create(OrderDetailDTO dto) {
        OrderDetail orderDetail = OrderDetail.builder()
                .order(orderService.readById(dto.getOrderId()))
                .product(productService.readById(dto.getProductId()))
                .price(productService.readById(dto.getProductId()).getPrice())
                .quantity(dto.getQuantity())
                .build();

        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> readAll() {
        return orderDetailRepository.findAll();
    }

    public List<OrderDetail> readAllById(List<Integer> ids) {
        return orderDetailRepository.findAllById(ids);
    }

    public void delete(Integer id) {
        orderDetailRepository.deleteById(id);
    }

    public List<OrderDetail> findByOrderId(Integer orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}
