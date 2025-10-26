package org.example.model;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private String orderId;

    private Customer customer;

    private List<Item> items;
}

