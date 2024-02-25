package api.service;

import api.entity.Customer;
import api.entity.Order;
import api.dto.OrderDTO;
import api.mapper.OrderMapper;
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
        Order order = OrderMapper.INSTANCE.orderDTOToOrder(dto);
        Customer customer = customerService.readById(dto.getCustomerId());
        order.setCustomer(customer);
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
