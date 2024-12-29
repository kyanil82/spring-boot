package com.aky.lostfound.mapper;

import com.aky.lostfound.dto.ClaimItemDto;
import com.aky.lostfound.entity.ClaimItem;

public class ClaimItemMapper {

    public static ClaimItem mapToClaimItem(String userId, ClaimItemDto claimItemDto){
        ClaimItem claimItem = new ClaimItem(
                claimItemDto.getItemName(),
                claimItemDto.getQuantity(),
                claimItemDto.getPlace(),
                userId
        );

        return claimItem;
    }

    /*public static ClaimItemDto mapToClaimItemDto(ClaimItem claimItem){
        ClaimItemDto claimItemDto = new ClaimItemDto(
                claimItem.getItemName(),
                claimItem.getQuantity(),
                claimItem.getPlace()
        );

        return claimItemDto;
    }*/
}
