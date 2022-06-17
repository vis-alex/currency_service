package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class GifInfoBean {
    private String type;
    private String id;
    private String url;
    private String slug;
    private String bitly_gif_url;
    private String bitly_url;
    private String embed_url;
    private String username;
    private String source;
    private String title;
    private String rating;
    private String content_url;
    private String source_tld;
    private String source_post_url;
    private Integer is_sticker;
    private String import_datetime;
    private String trending_datetime;
    private Map<String, Map<String, String>> images;
    private UserBean userBean;
    private String analyticsResponsePayload;
    private AnalyticsBean analytics;
}
