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

        String yesterdayDateString = formatDateToString();
        CurrencyRatesBean yesterdayCurrencyRates = proxy.retrieveCurrencyRatesByDate(yesterdayDateString);

        Double currentRate = currentCurrencyRates.getRates().get(code);
        Double yesterdayRate = yesterdayCurrencyRates.getRates().get(code);
        RootBean rootBean = chooseGifs(currentRate, yesterdayRate);

        String gifUrl = getUrlForGif(rootBean);

        model.addAttribute("gif_url", gifUrl);
        return "gif";
    }

    private String getUrlForGif(RootBean rootBean) {
        Map<String, Map<String, String>> images = rootBean.getData().get(new Random().nextInt(rootBean.getData().size())).getImages();
        return images.get("original").get("url");
    }

    private String formatDateToString() {
        Date yesterdayDate = new Date(System.currentTimeMillis()-24*60*60*1000);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(yesterdayDate);
    }

    private RootBean chooseGifs(Double currentRate, Double yesterdayRate) {
        if (currentRate > yesterdayRate) {
            return gifProxy.getRichGifs();
        } else {
            return gifProxy.getBrokeGifs();
        }
    }


}
