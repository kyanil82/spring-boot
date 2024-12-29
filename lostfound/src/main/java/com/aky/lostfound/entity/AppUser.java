package com.aky.lostfound.entity;


import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name="AppUser")
public class AppUser {




    @Id
    @Column(name="UserId")
    private String userId;

    @NonNull
    @Column(name="UserName")
    private String userName;

    public AppUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public @NonNull String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public AppUser() {
    }
}
