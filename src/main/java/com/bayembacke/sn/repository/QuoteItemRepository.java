package com.bayembacke.sn.repository;

import com.bayembacke.sn.model.QuoteItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuoteItemRepository extends MongoRepository<QuoteItem, String> {
    List<QuoteItem> findByCategory(String category);

}
