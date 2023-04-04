package com.nttdata.msreports.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("movement")
public class Movements {

    @Id
    private String id;
    private String idProduct;
    private String type;
    private Float amount;
    private String idThirdPartyProduct;
    private Date date;
}
