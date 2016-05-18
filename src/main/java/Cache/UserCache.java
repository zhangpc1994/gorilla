package Cache;

import pojo.User;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XH on 2016/5/17.
 */
public class UserCache {
    public static List<User> userList = new ArrayList<User>();

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

}
