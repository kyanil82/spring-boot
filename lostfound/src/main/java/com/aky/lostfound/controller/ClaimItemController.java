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

        return new ResponseEntity<>(claimItemService.claimByUserId(userid,claimItemsDto), HttpStatus.CREATED);
    }

    @GetMapping("/viewAllClaim")
    public ResponseEntity<List<ClaimItemDto>> viewClaim(){


        return new ResponseEntity<List<ClaimItemDto>>(claimItemService.viewAllClaim(), HttpStatus.OK);
    }

    @GetMapping("/viewAllClaim/{userid}")
    public ResponseEntity<List<ClaimItemDto>> viewAllClaimByUserId(@PathVariable String userid){


        return new ResponseEntity<List<ClaimItemDto>>(claimItemService.viewAllClaimByUserId(userid), HttpStatus.OK);
    }



}
