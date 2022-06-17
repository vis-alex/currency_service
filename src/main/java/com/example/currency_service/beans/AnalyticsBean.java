package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class AnalyticsBean {
    private Map<String, UrlBean> analytics;
}
