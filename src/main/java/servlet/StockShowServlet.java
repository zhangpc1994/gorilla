package servlet;

import pojo.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016-05-15.
 */
@WebServlet(name = "StockShowServlet")
public class StockShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------------------进入StockShowServlet------------------------------");
        String stockCode = request.getParameter("stockCode");
        String stockName = request.getParameter("stockName");
        String openPrice = request.getParameter("openPrice");
        String nowPrice = request.getParameter("nowPrice");
        String change = request.getParameter("change");

        //解决get请求中文乱码
        stockName =  new String(stockName.getBytes("iso-8859-1"), "UTF-8");

        System.out.println("stock----------------->"+stockCode+"\t"+stockName+"\t"+openPrice+"\t"+nowPrice+"\t"+change);
        Stock stock = new Stock(stockCode,stockName,openPrice,nowPrice,change);
        request.setAttribute("stock",stock);
        request.getRequestDispatcher("/jsp/stock_show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
