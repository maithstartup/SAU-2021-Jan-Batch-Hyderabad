package com.accolite.demo.controller;

import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;



    @PostMapping("/order/create")
    public ResponseEntity<Object> createOrder(@RequestBody Order order){

        String response = orderService.addOrder(order);
        if(response != null)
            return new ResponseEntity<Object>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("not able to create", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/order/get/{orderId}")
    public ResponseEntity<Object> getOrder(@PathVariable("orderId") Integer orderId ){

        Order order = orderService.getOrder(orderId);
        if(order != null)
            return new ResponseEntity<Object>(order, HttpStatus.FOUND);
        else
            return new ResponseEntity<Object>("Order not Found", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/order/delete/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("orderId") Integer orderId ){

        String response = orderService.deleteOrder(orderId);
        if(response != null)
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        else
            return new ResponseEntity<Object>("Order not Found", HttpStatus.NOT_FOUND);

    }

    @PutMapping("/order/update/{orderId}/{itemId}")
    public ResponseEntity<Object> updateOrderItem(@RequestBody Item item, @PathVariable("orderId") Integer orderId, @PathVariable("itemId") Integer itemId){

        Order order = orderService.updateOrderItem(item,orderId,itemId);
        if(order != null)
            return new ResponseEntity<Object>(order, HttpStatus.OK);
        else
            return new ResponseEntity<Object>("Order not Found", HttpStatus.NOT_FOUND);

    }

    @GetMapping("order/list")
    public ResponseEntity<Object> showOrders(){
       List<Order> orderList = orderService.showOrders();

        if(orderList != null)
            return new ResponseEntity<Object>(orderList, HttpStatus.OK);
        else
            return new ResponseEntity<Object>("Order not Found", HttpStatus.NOT_FOUND);


    }

}
