package servlet;

import Cache.StockCache;
import Util.Page;
import pojo.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-14.
 */
@WebServlet(name = "StockServlet")
public class StockServlet extends HttpServlet {



    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------------------------进入StockServlet----------------------------");
        List<Stock> stockList = new ArrayList<Stock>();
        String pageNow = request.getParameter("pageNow");

        System.out.println("pageNow/pageSize：" + pageNow);

        //分页
        Page page = new Page();
        if(pageNow != null){
            //设置当前页
            page.setPageNow(Integer.parseInt(pageNow));
            System.out.println("servlet pageNow---------->"+Integer.parseInt(pageNow));
        }
        page = StockCache.page(page);
        System.out.println("page servlet pageNow---------->" + page.getPageNow());

        //将pageStock放入request，在页面上遍历
        request.setAttribute("page",page);
        request.setAttribute("totalPage",page.getTotalPage());
        request.setAttribute("pageStock", page.getStockList());
        request.getRequestDispatcher("/jsp/stock_list.jsp").forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
