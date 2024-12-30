package com.aky.lostfound.service;

import com.aky.lostfound.dto.ClaimItemDto;
import com.aky.lostfound.entity.ClaimItem;

import java.util.List;

public interface ClaimItemService {

    String claimByUserId(String userid, List<ClaimItemDto> claimItemsDto);

    List<ClaimItemDto> viewAllClaim();


    List<ClaimItemDto> viewAllClaimByUserId(String userid);


}
