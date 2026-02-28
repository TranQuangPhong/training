package org.example.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @NotNull
    private String orderId;

    @Valid
    private Customer customer;

    @Valid
    @Size(min = 1)
    private List<Item> items;
}

