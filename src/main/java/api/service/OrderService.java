package api.service;

import api.entity.Order;
import api.dto.OrderDTO;
import api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public Order create(OrderDTO dto) {
        Order order = Order.builder()
                .orderDate(dto.getOrderDate())
                .orderStatus(dto.getOrderStatus())
                .paymentMethod(dto.getPaymentMethod())
                .customer(customerService.readById(dto.getCustomerId()))
                .build();

        return orderRepository.save(order);
    }

    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    public Order readById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find order by id" + id));
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
