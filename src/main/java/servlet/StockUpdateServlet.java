package servlet;

import Cache.StockCache;
import pojo.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by XH on 2016/5/17.
 */
@WebServlet(name = "StockUpdateServlet")
public class StockUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---------------进入UpdateServlet-------------------");
        String stockCode = request.getParameter("stockCode");
        String stockName = request.getParameter("stockName");
        String openPrice = request.getParameter("openPrice");
        String nowPrice = request.getParameter("nowPrice");
        String change = request.getParameter("change");
        //解觉中文乱码
        stockName =  new String(stockName.getBytes("iso-8859-1"), "UTF-8");

        List<Stock> stockList = StockCache.stockList;
        for(Stock stock : stockList){
            System.out.println(stock.getStockCode());
            if(stock.getStockCode()==stockCode){
                stock.setStockName(stockName);
                stock.setOpenPrice(openPrice);
                stock.setNowPrice(nowPrice);
                stock.setChange(change);
                break;
            }
        }
        //更新后的列表置入Cache
        StockCache.setStockList(stockList);
        response.sendRedirect("stock.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
