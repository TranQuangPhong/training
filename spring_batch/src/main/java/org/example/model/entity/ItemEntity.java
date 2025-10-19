package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.model.dto.Item;

@Entity
@Table(schema = "public", name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id", nullable = false)
    private String itemId;

    @Column(nullable = false)
    private int quantity;

    public ItemEntity(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public ItemEntity(Item item) {
        this.itemId = item.getItemId();
        this.quantity = item.getQuantity();
    }
}
