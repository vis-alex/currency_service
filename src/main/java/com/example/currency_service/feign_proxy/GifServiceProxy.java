package com.example.currency_service.feign_proxy;

import com.example.currency_service.beans.RootBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "api-giphy", url = "https://api.giphy.com/v1/gifs/search")
public interface GifServiceProxy {
    @GetMapping("?api_key=WXpCt1X1tDwup2N1YRcBqfI38edEvweb&q=rich")
    public RootBean getRichGifs();

    @GetMapping("?api_key=WXpCt1X1tDwup2N1YRcBqfI38edEvweb&q=broke")
    public RootBean getBrokeGifs();

}
