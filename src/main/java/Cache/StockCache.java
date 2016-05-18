package Cache;

import Util.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pojo.Stock;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-15.
 */
public class StockCache {
    //股票集合
    public static List<Stock> stockList = new ArrayList<Stock>();


    static {
        //获取所有的股票及详情
        String jsonStr = getJsonStr("/stock.json");
        //字符串解析为json
        JSONArray jsonArr = (JSONArray) JSON.parse(jsonStr);
        //遍历所有的json对象
        for (int i = 0; i < jsonArr.size(); i++) {
            Stock stock = new Stock();
            //获取到下标为i的json对象
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            //System.out.println("obj------------>" + jsonObj);
            //设置code
            int code = Integer.parseInt("6000") + i + 1;
            Object stockObj = jsonObj.get("" + code);
            //获取json格式的Stock对象-----------失败
            //stock = JSONObject.toJavaObject(new JSONObject(stock.toString()),Stock.class);
            JSONArray stockJsonArr = (JSONArray) JSON.parse(stockObj.toString());

            //遍历stock内属性
            for (int j = 0; j < stockJsonArr.size(); j++) {
                //获取到[{"stockCode":"6001"},{"stockName":"中国银行"},{"openPrice":"25.6"},{"nowPrice":"27.2"},{"change":"2.1%"}]
                String stockJsonObj = stockJsonArr.get(j).toString();

                //找到对应的属性，并设置进stock对象
                switch (j) {
                    case 0:
                        JSONObject codeKey = JSONObject.parseObject(stockJsonObj);//获取到{"stockCode":"6001"}
                        String stockCode = codeKey.get("stockCode").toString();
                        System.out.println("stock--------->" + codeKey.get("stockCode"));
                        stock.setStockCode(stockCode);
                        break;
                    case 1:
                        JSONObject nameKey = JSONObject.parseObject(stockJsonObj);//获取到"stockName":"中国银行"}
                        String stockName = nameKey.get("stockName").toString();
                        System.out.println("stock--------->" + nameKey.get("stockName"));
                        stock.setStockName(stockName);
                        break;
                    case 2:
                        JSONObject openPriceKey = JSONObject.parseObject(stockJsonObj);//获取到{"openPrice":"25.6"}
                        String openPrice = openPriceKey.get("openPrice").toString();
                        System.out.println("stock--------->" + openPriceKey.get("openPrice"));
                        stock.setOpenPrice(openPrice);
                        break;
                    case 3:
                        JSONObject nowPriceKey = JSONObject.parseObject(stockJsonObj);//获取到{"nowPrice":"27.2"}
                        String nowPrice = nowPriceKey.get("nowPrice").toString();
                        System.out.println("stock--------->" + nowPriceKey.get("nowPrice"));
                        stock.setNowPrice(nowPrice);
                        break;
                    case 4:
                        JSONObject changeKey = JSONObject.parseObject(stockJsonObj);//获取到{"change":"2.1%"}
                        String change = changeKey.get("change").toString();
                        System.out.println("stock--------->" + changeKey.get("change"));
                        stock.setChange(change);
                        break;
                }
            }
            //将stock对象放进集合，传到页面
            stockList.add(stock);
        }
    }

    //解析json文件-->json转成String
    public static String getJsonStr(String path) {

        String jsonStr = "";
        //获取json文件
        try {
            InputStream is = StockCache.class.getResourceAsStream(path);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] bytes = new byte[10 * 1024];
            int len = -1;

            while ((len = bis.read(bytes)) != -1) {
                jsonStr = new String(bytes, 0, len,"UTF-8");
            }

            bis.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cache jsonStr---------->"+jsonStr);
        return jsonStr;
    }

    //分页
    public static Page page(Page page)
    {
        System.out.println("---------------------------进入page方法------------------------");
        List<Stock> pageStock = new ArrayList<Stock>();
        //Page page2 = new Page();
        Stock stock = new Stock();
        //每页起始的下标
        int startIndex = (page.getPageNow()-1)*page.getPageSize();
        //每页终止的下标
        int endIndex = 0;
        if(page.getPageSize()+startIndex>page.getTotal()){
            endIndex=10;
        }else {
            endIndex=page.getPageSize()+startIndex;
        }
        System.out.println("stratIndex----------->"+startIndex);

        for(int i = startIndex;i<endIndex;i++)
        {
            stock = stockList.get(i);
            System.out.println("StockCache.stockList.get(i)----->"+page);
            page.getStockList().add(stock);//将当前页的数据添加到page对象中的list
        }
        System.out.println("pageStock------------>"+page.getStockList());
        return page;
    }
    public static List<Stock> getStockList() {
        return stockList;
    }

    public static void setStockList(List<Stock> stockList) {
        StockCache.stockList = stockList;
    }
}
