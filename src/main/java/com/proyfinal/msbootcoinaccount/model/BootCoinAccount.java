package com.proyfinal.msbootcoinaccount.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document("BootCoinAccount")
public class BootCoinAccount {

    @Id
    private String id;
    private DocumentType documentType;
    private String documentNumber;
    private int phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private Double amount;

    public enum DocumentType {
        DNI,
        CEX,
        PASSPORT
    }
}
