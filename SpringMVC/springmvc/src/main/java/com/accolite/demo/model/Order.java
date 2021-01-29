package com.accolite.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter @Setter @NoArgsConstructor
public class Order {

    private Integer orderId;
    private List <Item> itemList;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemList=" + itemList +
                '}';
    }
}
