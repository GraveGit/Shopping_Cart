package api.service;

import api.dto.OrderDetailDTO;
import api.entity.OrderDetail;
import api.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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
