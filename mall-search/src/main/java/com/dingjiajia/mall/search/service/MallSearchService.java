package com.dingjiajia.mall.search.service;


import com.dingjiajia.mall.search.vo.SearchParam;
import com.dingjiajia.mall.search.vo.SearchResult;

public interface MallSearchService {

    /**
     * @param param 检索的所有参数
     * @return 返回检索的结果
     */
    SearchResult search(SearchParam param);
}
