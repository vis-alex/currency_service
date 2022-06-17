package com.example.currency_service.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RootBean {

    private List <GifInfoBean> data;

    private PaginationBean paginationBean;

    private MetaBean metaBean;
}
