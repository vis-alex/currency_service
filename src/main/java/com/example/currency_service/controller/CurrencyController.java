package com.example.currency_service.controller;

import com.example.currency_service.beans.CurrencyRatesBean;
import com.example.currency_service.beans.RootBean;
import com.example.currency_service.feign_proxy.CurrencyRatesServiceProxy;
import com.example.currency_service.feign_proxy.GifServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Controller
public class CurrencyController {
    private CurrencyRatesServiceProxy proxy;
    private GifServiceProxy gifProxy;

    public CurrencyController(CurrencyRatesServiceProxy proxy, GifServiceProxy gifProxy) {
        this.proxy = proxy;
        this.gifProxy = gifProxy;
    }

    @GetMapping("/get_gif/{code}")
    public String getGif(@PathVariable String code, Model model) {

        CurrencyRatesBean currentCurrencyRates = proxy.retrieveLatestCurrencyRates();

        Date yesterdayDate = new Date(System.currentTimeMillis()-24*60*60*1000);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String yesterdayDateString = formatter.format(yesterdayDate);
        CurrencyRatesBean yesterdayCurrencyRates = proxy.retrieveCurrencyRatesByDate(yesterdayDateString);
        System.out.println("CurrentRates - " + currentCurrencyRates);
        System.out.println("YesterdayRates - " + yesterdayCurrencyRates);

        Double currentRate = currentCurrencyRates.getRates().get(code);
        Double yesterdayRate = yesterdayCurrencyRates.getRates().get(code);

        System.out.println("CurrentRate" + currentRate);
        System.out.println("YesterdayRate" + yesterdayRate);


        RootBean rootBean;
        if (currentRate > yesterdayRate) {
            rootBean = gifProxy.getRichGifs();
        } else {
            rootBean = gifProxy.getBrokeGifs();
        }

        Map<String, Map<String, String>> images = rootBean.getData().get(new Random().nextInt(rootBean.getData().size())).getImages();
        String gifUrl = images.get("original").get("url");

        model.addAttribute("gif_url", gifUrl);
        return "gif";
    }
}
