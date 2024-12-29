package com.aky.lostfound.controller;

import com.aky.lostfound.dto.ClaimItemDto;
import com.aky.lostfound.service.ClaimItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claimItem")
public class ClaimItemController {


    private ClaimItemService claimItemService;

    public ClaimItemController(ClaimItemService claimItemService) {
        this.claimItemService = claimItemService;
    }

    @PostMapping("/claim/{userid}")
    public ResponseEntity<String> claimById(@PathVariable String userid, @RequestBody List<ClaimItemDto> claimItemsDto){

        return new ResponseEntity<>(claimItemService.claimByUserId(userid,claimItemsDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewAllClaim")
    public ResponseEntity<List<ClaimItemDto>> viewClaim(){


        return new ResponseEntity<List<ClaimItemDto>>(claimItemService.viewAllClaim(), HttpStatus.ACCEPTED);
    }

}
