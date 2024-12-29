package com.aky.lostfound.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ClaimItem")
public class ClaimItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @Column(name="ItemName")
    private String itemName;

    @Column(name="Quantity")
    private int quantity;

    @Column(name="Place")
    private String place;

    @Column(name="UserId")
    private String userId;


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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public ClaimItem() {
    }


    public ClaimItem(String itemName, int quantity, String place, String userId) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.place = place;
        this.userId = userId;
    }



}
