package com.aky.lostfound.service.impl;

import com.aky.lostfound.dto.ClaimItemDto;
import com.aky.lostfound.entity.AppUser;
import com.aky.lostfound.entity.ClaimItem;
import com.aky.lostfound.mapper.ClaimItemMapper;
import com.aky.lostfound.repository.AppUserRepository;
import com.aky.lostfound.repository.ClaimItemRepository;
import com.aky.lostfound.service.ClaimItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClaimItemServiceImpl implements ClaimItemService {


    @Autowired
    private ClaimItemRepository claimItemRepository;

    @Autowired
    private AppUserRepository appUserRepository;



    @Override
    public String claimByUserId(String userid, List<ClaimItemDto> claimItemsDto) {
        try{
        appUserRepository.findById(userid).orElseThrow(()-> new RuntimeException("User does not exist"));
            List<ClaimItem> claimItems = new ArrayList<>();
            for (ClaimItemDto claimItemDto : claimItemsDto) {
                ClaimItem claimItem = ClaimItemMapper.mapToClaimItem(userid, claimItemDto);
                claimItems.add(claimItem);
            }

            claimItemRepository.saveAll(claimItems);
            return "claimed sucessfully";
        }catch(Exception e){
            return e.getMessage();
        }




    }

    @Override
    public List<ClaimItemDto> viewAllClaim() {
         // Get All Users registered
         List<AppUser> appusers = appUserRepository.findAll();
         // load into Hashmap to find username by userid
         Map<String, String> map = new HashMap<>();

         for(AppUser appuser : appusers){
             map.put(appuser.getUserId(), appuser.getUserName());
         }

         // get all claim Item
         List<ClaimItem> claimItems = claimItemRepository.findAll();
         List<ClaimItemDto> claimItemsDto = new ArrayList<>();

         for(ClaimItem claimItem : claimItems){
             ClaimItemDto claimtemDto = new ClaimItemDto();
             claimtemDto.setItemName(claimItem.getItemName());
             claimtemDto.setQuantity(claimItem.getQuantity());
             claimtemDto.setPlace(claimItem.getPlace());
             claimtemDto.setUserid(claimItem.getUserId());
             claimtemDto.setUserName(map.get(claimItem.getUserId()));
             claimItemsDto.add(claimtemDto);
         }
         return claimItemsDto;

    }
}
