package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaginationBean {
    private Integer totalCount;
    private Integer count;
    private Integer offset;
}
