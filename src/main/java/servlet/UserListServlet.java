package servlet;

import Cache.UserCache;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XH on 2016/5/17.
 */
@WebServlet(name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------------------------进入UserListServlet------------------");
        List<User> userList = new ArrayList<User>();

        //添加操作
        if(null!=request.getParameter("regiestName")) {
            String regiestName = request.getParameter("regiestName");
            String regiestPassword = request.getParameter("regiestPassword");
            User user = new User(regiestName,regiestPassword);
            userList.add(user);
        }


        //查询操作
        String username="";
        String password="";
        String userJson = UserCache.getJsonStr("/user.json");
        JSONArray userArr = (JSONArray) JSONArray.parse(userJson);

        //获取到下标为name的jsonObject
        JSONObject userNameObj = userArr.getJSONObject(0);
        System.out.println("userNameObj:"+userNameObj);
        //[{"username":"admin"},{"username":"root"}]},{"pwd":[{"password":"123"},{"password":"123"}]
        JSONArray userNameArr = (JSONArray)JSON.parse(userNameObj.get("name").toString());

        //获取到下标为pwd的jsonObject
        JSONObject passwordObj = userArr.getJSONObject(1);
        System.out.println("passwordObj:"+passwordObj);
        JSONArray passwordArr = (JSONArray)JSON.parse(passwordObj.get("pwd").toString());

        //利用姓名数组长度做对象赋值循环
        for(int i=0;i<userNameArr.size();i++){
            User user = new User();
            username = userNameArr.getJSONObject(i).get("username").toString();
            System.out.println("username:"+username);
            user.setUsername(username);

            password = passwordArr.getJSONObject(i).get("password").toString();
            System.out.println("password:" + password);
            user.setPassword(password);

            userList.add(user);
        }

        System.out.println("userList:"+userList);

        //删除操作
        if(null!=request.getParameter("deleteUserName")){
            String deleteUserName = request.getParameter("deleteUserName");
            for(User user : userList){
                if(deleteUserName==user.getUsername()){
                    userList.remove(1);
                    break;
                }
            }
        }



//        //修改操作
//        if(null != request.getParameter("updateUserName")){
//            String updateUserName = request.getParameter("updateUserName");
//            String updatePassword = request.getParameter("updatePassword");
//            for(User user : UserCache.userList){
//                if(updateUserName==user.getUsername()){
//                    user.setPassword(updatePassword);
//                    UserCache.userList.add(user);
//                    System.out.println("修改中：" + UserCache.userList.get(0).getPassword());
//                }
//            }
//        }

        request.setAttribute("userList",userList);
        request.getRequestDispatcher("jsp/user_list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
