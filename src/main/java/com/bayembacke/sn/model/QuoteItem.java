package com.bayembacke.sn.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document(collection = "actualites")
@Data
public class QuoteItem {
    @Id
    private String _id;
    private String url ;
    private String date ;
    private String tags ;
    private String image ;
    private String category ;
}
