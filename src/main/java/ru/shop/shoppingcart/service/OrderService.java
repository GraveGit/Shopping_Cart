package ru.shop.shoppingcart.service;

import ru.shop.shoppingcart.mapper.OrderMapper;
import ru.shop.shoppingcart.entity.Customer;
import ru.shop.shoppingcart.entity.Order;
import ru.shop.shoppingcart.dto.OrderDTO;
import ru.shop.shoppingcart.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    /**
     * Создает новый заказ на основе переданных данных DTO.
     *
     * @param dto DTO заказа для создания.
     * @return Созданный заказ.
     */
    public Order create(OrderDTO dto) {
        Order order = OrderMapper.INSTANCE.orderDTOToOrder(dto);
        Customer customer = customerService.readById(dto.getCustomerId());
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    /**
     * Получает список всех заказов.
     *
     * @return Список всех заказов.
     */
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    /**
     * Получает заказ по его ID.
     *
     * @param id ID заказа для поиска.
     * @return Заказ с указанным ID, если найден.
     * @throws RuntimeException если заказ с указанным ID не найден.
     */
    public Order readById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find order by id" + id));
    }

    /**
     * Обновляет информацию о заказе.
     *
     * @param order Заказ для обновления.
     * @return Обновленный заказ.
     */
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Удаляет заказ по его ID.
     *
     * @param id ID заказа для удаления.
     */
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
