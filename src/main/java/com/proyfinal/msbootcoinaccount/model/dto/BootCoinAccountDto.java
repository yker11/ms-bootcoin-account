package com.proyfinal.msbootcoinaccount.model.dto;

import com.proyfinal.msbootcoinaccount.model.BootCoinAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinAccountDto {

    private String id;
    private BootCoinAccount.DocumentType documentType;
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
