package com.example.currency_service.controller;

import com.example.currency_service.CurrencyRatesServiceProxy;
import com.example.currency_service.beans.CurrencyRatesBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyController {
    private CurrencyRatesServiceProxy proxy;

    public CurrencyController(CurrencyRatesServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/get_gif")
    public String getGif(Model model) {
        CurrencyRatesBean currencyRates = proxy.retrieveCurrencyRates();
        System.out.println(currencyRates);


//        model.addAttribute("rates", currencyRates);
        return "gif";
    }
}
