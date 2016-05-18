package Util;

import Cache.StockCache;
import pojo.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-15.
 */
public class Page {
    private Integer pageNow=1;//当前页码
    private Integer pageSize=3;//每页记录数
    private Integer total;//总记录数
    private Integer totalPage;//总页数

    private List<Stock> stockList = new ArrayList<Stock>();

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //返回总记录数
    public Integer getTotal() {
        return StockCache.stockList.size();
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    public Integer getTotalPage() {
        return ((StockCache.stockList.size())+pageSize-1)/pageSize;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
