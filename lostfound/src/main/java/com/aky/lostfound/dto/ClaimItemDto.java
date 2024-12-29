package com.aky.lostfound.dto;


import lombok.*;

@AllArgsConstructor
@Data
public class ClaimItemDto {

    private String itemName;


    private int quantity;


    private String place;

    private String userid;

    private String userName;



    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




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

    public ClaimItemDto() {
    }

    public ClaimItemDto(String itemName, int quantity, String place, String userid, String userName) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.place = place;
        this.userid = userid;
        this.userName = userName;
    }



}
