package com.accolite.demo.service;

import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;

import java.util.List;

public interface OrderService {

    public String addOrder(Order order);

    public Order getOrder(Integer orderId);

    public String deleteOrder(Integer orderId);

    public  Order updateOrderItem(Item item, Integer orderId, Integer itemId);

    public List<Order> showOrders();
}
