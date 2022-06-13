package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
public class CurrencyRatesBean {
    private String disclaimer;

    private String license;

    private Date timestamp;

    private String base;

    private Map<String, Double> rates;

    public CurrencyRatesBean(String disclaimer, String license, Date timestamp, String base, Map<String, Double> rates) {
        super();
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }
}
