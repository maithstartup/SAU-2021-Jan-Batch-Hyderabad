package com.accolite.demo.impl;

import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    List<Order> orderList=new LinkedList<>();

    public String addOrder(Order order){

        if(order!=null) {
            orderList.add(order);
            System.out.println(order);
            return "Order Added";
        }
        else
            return null;

    }

    public Order getOrder(Integer orderId){
        for (Order order: orderList)
        {
            if(order.getOrderId()==orderId)
                return order;
        }
        return null;
    }

    public String deleteOrder(Integer orderId){
        for(int i=0; i<orderList.size();i++)
        {
            if(orderList.get(i).getOrderId()==orderId) {
                orderList.remove(i);
                return "Order Removed";
            }
        }
        return null;
    }
    public  Order updateOrderItem(Item item, Integer orderId, Integer itemId){
        for(int i=0; i<orderList.size();i++)
        {
            if(orderList.get(i).getOrderId()==orderId) {
                orderList.get(i).getItemList().set(itemId-1,item);
                return orderList.get(i);
            }
        }
        return null;
    }

    public List<Order> showOrders(){
            return orderList;
        }

}
