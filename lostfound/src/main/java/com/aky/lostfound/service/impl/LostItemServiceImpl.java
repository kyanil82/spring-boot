package com.aky.lostfound.service.impl;

import com.aky.lostfound.entity.LostItem;
import com.aky.lostfound.repository.LostItemRepository;
import com.aky.lostfound.service.LostItemService;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LostItemServiceImpl implements LostItemService {

    @Autowired
    private LostItemRepository lostItemRepository;



    @Override
    public String processFile(MultipartFile file) throws IOException {
        //place holder for key value with :
        String [] str;

        // file content type, can be extended for other file types
         if(file.getContentType().toLowerCase().contains("application/pdf")){

         //check if file is not blank
         if(file.getInputStream().available() != -1){

             // open InputStream to read file
             InputStream inputStream = file.getInputStream();

             //open PdfReader to process InputStream
             PdfReader pdfReader = new PdfReader(inputStream);

             //store lostItem objects after grouping from file
             List<LostItem> lostItems = new ArrayList<>();

             // initialize temporary variables to use it later for each field in file
             String item = "";
             int qty = 0;
             String place = "";

             for(int i=1;i<=pdfReader.getNumberOfPages();i++){
                 Stream<String> lines = PdfTextExtractor.getTextFromPage(pdfReader,i).lines();

                 for (String line: lines.toList()){

                     if(line.isEmpty()||line.isBlank()){
                         continue;
                     }
                     else if(line.contains("ItemName")){
                         // key is saved in index 0 and value in 1
                         str = line.split(":");

                         // extract value and store in item field
                         item = str[1].trim();
                     }else if(line.contains("Quantity")) {
                         // key is saved in index 0 and value in 1
                         str = line.split(":");

                         // extract value and store in item field
                         qty = Integer.valueOf(str[1].trim());
                     }else if(line.contains("Place")){
                         // key is saved in index 0 and value in 1
                         str = line.split(":");

                         // extract value and store in item field
                         place=str[1].trim();

                         // construct object with values and add to list of objects
                         lostItems.add(new LostItem(item,qty,place));

                         // reinitialize all temporary variables for next line
                         item = "";
                         qty = 0;
                         place = "";
                     }
                 }

             }

             // close PdfReader
             pdfReader.close();

             // close InputStream
             inputStream.close();

             // save all items to db
             lostItemRepository.saveAll(lostItems);

             return file.getOriginalFilename().concat( " file uploaded successfully");

         }
    }else{
             return file.getOriginalFilename().concat( " file format not supported");
         }
        return file.getOriginalFilename().concat( " file upload failed");
}

    @Override
    public List<LostItem> viewAll() {
        return  lostItemRepository.findAll();
    }

    @Override
    public List<LostItem> viewAllWithPagination(Pageable pageable) {
        List<LostItem> li = new ArrayList<>();
        lostItemRepository.findAll(pageable).forEach(li::add);
        return li;

    }


}
