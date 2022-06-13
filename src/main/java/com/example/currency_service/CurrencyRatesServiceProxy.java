package com.example.currency_service;

import com.example.currency_service.beans.CurrencyRatesBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@FeignClient(name="open-exchange", url="https://openexchangerates.org/api")
public interface CurrencyRatesServiceProxy {
    @GetMapping("/latest.json?app_id=9968744ca3284c3baf5d09cf1815ae6b")
    public CurrencyRatesBean retrieveCurrentCurrencyRates();

    @GetMapping("/historical/{date}.json?app_id=9968744ca3284c3baf5d09cf1815ae6b")
    public CurrencyRatesBean retrieveYesterdayCurrencyRates(@PathVariable String date);

}