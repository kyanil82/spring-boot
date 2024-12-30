package com.aky.lostfound.service;

import com.aky.lostfound.entity.LostItem;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface LostItemService {


    String processFile(MultipartFile file) throws IOException;

    List<LostItem> viewAll();

    List<LostItem> viewAllWithPagination(Pageable pageable);
}
