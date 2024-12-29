package com.aky.lostfound.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Data
@Entity
@Table(name="LostItem")
public class LostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name="ItemName")
    private String itemName;

    @Column(name="Quantity")
    private int quantity;

    @Column(name="Place")
    private String place;



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public LostItem(String itemName, int quantity, String place) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.place = place;
    }

    public LostItem() {
    }
}
