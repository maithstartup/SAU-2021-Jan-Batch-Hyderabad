package com.example.demo.controller;


import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        String response = orderService.createOrder(order);
        if(response.contains("Order Successfully Created!")) {
          logger.info("Order created", order);
          return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        logger.error("Not Created");
        return  new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @PostMapping("/additem/{orderId}")
    public ResponseEntity<String> addItem(@RequestBody Item item, @PathVariable("orderId") int orderId){
        String response = orderService.addItemIntoOrder(item, orderId);
        if(response.contains("Item Added Successfully"))
            return ResponseEntity.ok(response);
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/viewitems/{orderId}")
    public ResponseEntity<List<Item>> getItemList(@PathVariable("orderId") int orderId){
        List<Item> itemList = orderService.getItemsFromOrder(orderId).getItemList();

        return ResponseEntity.ok(itemList);
    }

    @DeleteMapping("/deleteitem/{orderId}/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("orderId") int orderId, @PathVariable("itemId") int itemId){
        String response = orderService.deleteItemFromOrder(itemId ,orderId);

        if(response.contains("Item deleted!!"))
            return ResponseEntity.ok(response);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
