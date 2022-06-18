package com.example.currency_service.feign_proxy;

import com.example.currency_service.beans.RootBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${giphy.app.name}", url = "${giphy.api.url}")
public interface GifServiceProxy {
    @GetMapping("${giphy.api.search.rich}")
    public RootBean getRichGifs();

    @GetMapping("${giphy.api.search.broke}")
    public RootBean getBrokeGifs();

}
