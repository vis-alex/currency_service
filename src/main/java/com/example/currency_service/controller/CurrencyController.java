package com.example.currency_service.controller;

import com.example.currency_service.CurrencyRatesServiceProxy;
import com.example.currency_service.beans.CurrencyRatesBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CurrencyController {
    private CurrencyRatesServiceProxy proxy;

    public CurrencyController(CurrencyRatesServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/get_gif/{code}")
    public String getGif(@PathVariable String code, Model model) {
        CurrencyRatesBean currentCurrencyRates = proxy.retrieveCurrentCurrencyRates();

        Date yesterdayDate = new Date(System.currentTimeMillis()-24*60*60*1000);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String yesterdayDateString = formatter.format(yesterdayDate);

        CurrencyRatesBean yesterdayCurrencyRates = proxy.retrieveYesterdayCurrencyRates(yesterdayDateString);
        System.out.println("CurrentRates" + currentCurrencyRates);
        System.out.println("YesterdayRates" + yesterdayCurrencyRates);

        Double currentRate = currentCurrencyRates.getRates().get(code);
        Double yesterdayRate = yesterdayCurrencyRates.getRates().get(code);


//        model.addAttribute("rates", currencyRates);
        return "gif";
    }
}
