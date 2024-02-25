package api.service;

import api.dto.OrderDetailDTO;
import api.entity.Order;
import api.entity.OrderDetail;
import api.entity.Product;
import api.mapper.OrderDetailMapper;
import api.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderDetail create(OrderDetailDTO dto) {
        OrderDetail orderDetail = OrderDetailMapper.INSTANCE.orderDetailDTOToOrderDetail(dto);
        Order order = orderService.readById(dto.getOrderId());
        Product product = productService.readById(dto.getProductId());
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        //orderDetail.setPrice(product.getPrice());
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
