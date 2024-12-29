package com.aky.lostfound.service.impl;

import com.aky.lostfound.entity.AppUser;
import com.aky.lostfound.repository.AppUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl {



    AppUserRepository appUser;

    public AppUserServiceImpl(AppUserRepository appUser) {
        this.appUser = appUser;
    }

    // initialize app user table when application starts
    @PostConstruct
    public void initUser(){

        List<AppUser> ul =
                List.of(new AppUser[]{(new AppUser("1001","1001UserName")),
                        new AppUser("1002","1002UserName"),
                        new AppUser("1003","1003UserName"),
                        new AppUser("1004","1004UserName"),
                        new AppUser("1005","1005UserName"),
                        new AppUser("1006","1006UserName"),
                        new AppUser("1007","1007UserName"),
                        new AppUser("1008","1008UserName"),
                        new AppUser("1009","1009UserName"),
                        new AppUser("10010","10010UserName")});

        appUser.saveAll(ul);

    }
}
