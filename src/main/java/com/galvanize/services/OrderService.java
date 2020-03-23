package com.galvanize.services;

import com.galvanize.entities.Order;
import com.galvanize.entities.Status;
import com.galvanize.repositories.OrderDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    OrderDao orderDao;

    public OrderService(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public Order createOrder(Order order){
        return orderDao.save(order);
    }

    public Order getOrder(Long id){
        Optional<Order> order = orderDao.findById(id);
        return order.orElse(null);
    }

    public List<Order> getAllOrders(){
        return orderDao.findAll();
    }

    public Order updateOrder(Long id, String customerName, Status status, String note){
        Order order = getOrder(id);
        if (customerName != "")
          order.setCustomerName(customerName);
        if (status != null)
          order.setStatus(status);
        if (note != "")
          order.setNote(note);
        Order savedOrder = orderDao.saveAndFlush(order);
        return savedOrder;
    }
}

