package ru.shop.shoppingcart.service;

import ru.shop.shoppingcart.dto.OrderDetailDTO;
import ru.shop.shoppingcart.entity.Order;
import ru.shop.shoppingcart.entity.OrderDetail;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.mapper.OrderDetailMapper;
import ru.shop.shoppingcart.repository.OrderDetailRepository;
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
