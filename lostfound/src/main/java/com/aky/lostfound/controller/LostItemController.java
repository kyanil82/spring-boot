package com.aky.lostfound.controller;

import com.aky.lostfound.entity.LostItem;
import com.aky.lostfound.service.LostItemService;
import com.aky.lostfound.service.impl.LostItemServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lostItem")
public class LostItemController {

    private  LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
         this.lostItemService = lostItemService;
    }



    @PostMapping("/uploadRecord")
    public ResponseEntity<String> uploadRecord(@RequestParam("file")MultipartFile file) throws IOException {


         return new ResponseEntity<>(lostItemService.processFile(file), HttpStatus.CREATED);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<LostItem>> viewAll()  {

        return new ResponseEntity<List<LostItem>>(lostItemService.viewAll(), HttpStatus.OK);
    }

    @GetMapping("/viewAllWithPagination")
    public ResponseEntity<List<LostItem>> viewAllWithPagination(@RequestParam(required=true) int page, @RequestParam(required=true) int size)  {
        Pageable pageable = PageRequest.of(page,size);
        return new ResponseEntity<List<LostItem>>(lostItemService.viewAllWithPagination(pageable), HttpStatus.OK);
    }

}
