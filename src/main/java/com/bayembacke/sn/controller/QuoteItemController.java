package com.bayembacke.sn.controller;

import com.bayembacke.sn.model.QuoteItem;
import com.bayembacke.sn.repository.QuoteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteItemController {
    @Autowired
    private QuoteItemRepository quoteItemRepository;

    @GetMapping("/all")
    public ResponseEntity<Iterable<QuoteItem>> getAll() {
        return new ResponseEntity<>(quoteItemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/allItems")
    public ResponseEntity<Iterable<QuoteItem>> getAllByAuthor(@RequestParam(required = false) String category) {

        try {
            List<QuoteItem> items = new ArrayList<QuoteItem>();
            if (category == null) {
                 quoteItemRepository.findAll().forEach(items::add);
            }else{
                quoteItemRepository.findByCategory(category).forEach(items::add);
            }
            if(items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
