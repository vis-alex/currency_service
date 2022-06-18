package com.example.currency_service.feign_proxy;

import com.example.currency_service.beans.CurrencyRatesBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="${currency.rates.api.name}", url="${currency.rates.api.url}")
public interface CurrencyRatesServiceProxy {
    @GetMapping("${currency.rates.latest}")
    public CurrencyRatesBean retrieveLatestCurrencyRates();

    @GetMapping("${currency.rates.by.date}")
    public CurrencyRatesBean retrieveCurrencyRatesByDate(@PathVariable String date);

}