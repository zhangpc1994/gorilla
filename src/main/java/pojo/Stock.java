package pojo;

/**
 * Created by Administrator on 2016-05-14.
 */
public class Stock {
    private String stockCode;
    private String stockName;
    private String openPrice;
    private String nowPrice;
    private String change;

    public Stock(){}

    public Stock(String stockCode, String stockName, String openPrice, String nowPrice, String change) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.openPrice = openPrice;
        this.nowPrice = nowPrice;
        this.change = change;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
