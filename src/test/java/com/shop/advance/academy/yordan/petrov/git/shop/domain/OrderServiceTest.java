package com.shop.advance.academy.yordan.petrov.git.shop.domain;

import com.shop.advance.academy.yordan.petrov.git.shop.data.dao.OrderDao;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Order;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.OrderServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Class test  for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @MockBean
    OrderDao orderDao;

    @Autowired
    OrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOrderServiceReturnsAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());

        Mockito.when(orderDao.findAll()).thenReturn(orders);
        List<OrderServiceViewModel> ordersFetchedFromRepo = orderService.getAllOrders();

        assertEquals(3, ordersFetchedFromRepo.size());
    }


    @Test
    public void testOrderServiceGetOrderById() {
        Order order = new Order();
        order.setId(15L);

        Mockito.when(orderDao.findById(15L))
                .thenReturn(java.util.Optional.of(order));
        OrderServiceViewModel orderServiceViewModel = this.modelMapper.map(order, OrderServiceViewModel.class);

        assertEquals(orderServiceViewModel, orderService.getOrderById(15L));
    }

    //TODO ADD TEST IF CREATES

    //TODO ADD TEST IF REMOVES

    //TODO ADD TEST IF UPDATES
}
