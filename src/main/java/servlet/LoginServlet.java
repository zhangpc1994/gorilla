package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by XH on 2016/5/13.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("---------------------------进入LoginServlet-----------------------------");

        //获取会话
        HttpSession session = request.getSession();
        String reqUserName= request.getParameter("username");
        String reqPassWord=request.getParameter("password");
        if(reqUserName==null && reqPassWord==null){
            reqUserName="";
            reqPassWord="";
        }
        System.out.println("页面穿过来的------------------>"+reqUserName+"\t"+reqPassWord);

        //便于判断用户名密码是否匹配
        boolean flag = false;

        //转成字符串
        String jsonStr=getJsonStr("/user.json");

        //转成JSON数组
        JSONArray userArr = (JSONArray)JSON.parse(jsonStr);
        JSONObject obj=null;
        //姓名层
        //获取name的json对象
        obj = (JSONObject)userArr.get(0);
        Object name = obj.get("name");
        System.out.println("name----------->" + name.toString());
        //username的json数组
        JSONArray nameArr = (JSONArray)JSON.parse(name.toString());
        System.out.println(nameArr.size());

        //遍历username 最终获取到username
        for(int i = 0;i<nameArr.size();i++){
            obj=(JSONObject)nameArr.get(i);
            String jsonUserName=obj.get("username").toString();
            if(reqUserName.equals(jsonUserName)){

                //密码层
                //获取pwd的json对象
                obj = (JSONObject)userArr.get(1);
                Object password =  obj.get("pwd");
                System.out.println("pwd----------->" +password.toString());
                //pwd的json数组
                JSONArray pwdArr = (JSONArray)JSON.parse(password.toString());
                System.out.println(pwdArr.size());
                //遍历pwd 最终获取到password
                for(int i2 = 0;i2<pwdArr.size();i2++){
                    obj=(JSONObject)pwdArr.get(i2);
                    String jsonPassWord=obj.get("password").toString();
                    if(jsonPassWord.equals(reqPassWord)){
                        flag=true;
                        break;
                    }else {
                        flag=false;
                    }
                    System.out.println("password--------->"+jsonPassWord);
                }
                break;

            }else{
                flag=false;

            }
            System.out.println("jsonUserName--------->"+jsonUserName);
        }



        if(flag){
            session.setAttribute("username",reqUserName);
            request.getRequestDispatcher("stock.jsp").forward(request,response);
        }else {
            request.setAttribute("loginError","用户名密码不匹配！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    public String getJsonStr(String str){
        //解析json数据。1，获取json文件流 2，转换成String格式
        InputStream is =  LoginServlet.class.getResourceAsStream(str);
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] bytes = new byte[1024];
        int len = -1;
        String jsonStr = "";
        try {
            while((len=bis.read(bytes))!=-1){
                jsonStr=new String(bytes,0,len);
            }
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr---------->" + jsonStr);

        return jsonStr;
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
