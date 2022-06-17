package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaBean {
    private Integer status;
    private String msg;
    private String responseId;
}
