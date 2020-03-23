package com.galvanize.services;


import com.galvanize.entities.Order;
import com.galvanize.entities.Status;
import com.galvanize.repositories.OrderDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@AutoConfigureMockMvc
class OrderServiceTest {

    @Autowired // means use the real thing
    OrderService orderService;

    //@MockBean // means use a mock

    @Autowired
    OrderDao orderDao;

    Order order1;
    Order order2;

    @BeforeEach
    void setUp(){
        //create test orders
        order1 = new Order("TestCustomer1", "19-20-30", Status.CANCELLED, "I bought too much TP!", "5-30-20" );
        order2 = new Order("TestCustomer2", "12-10-30", Status.PENDING, "I'm ready for my tuna cans!", "5-6-20" );
        orderService.createOrder(order1);
        orderService.createOrder(order2);
    }

    @Test
    void createOrderWithId() {
        Order order = orderService.createOrder(order1);
        assertNotNull(order1.getId());
        System.out.println(order1);
    }

    @Test
    public void getAllOrders_whenOrdersExists_returnOrderList() {
        //Setup
        //Exercise
        List<Order> orders = orderService.getAllOrders();
        //Assert
        assertNotNull(orders);
        //Teardown
    }

    @Test
    public void getOneOrderById_whenOrderExists_returnOrder() {
        //Setup
        //Exercise
        Order order = orderService.getOrder(1L);
        //Assert
        assertEquals(1L, order.getId());
        //Teardown
    }

    @Test
    public void assignOneOrderById_whenOrderExists_returnOrder() {
        //Setup
        long id = 1L;
        String customerName = "renamed";
        Status status = Status.CANCELLED;
        String note = "";
        //Exercise
        Order order = orderService.updateOrder(id, customerName, status, note);
        //Assert
        assertEquals(status, order.getStatus());
        //Teardown
    }

}