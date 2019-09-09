package WeChat;

import net.sf.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class CreateMenu
{
    public static void main(String[] args)
    {
        Button btn = new Button();
        //往集合中加入view类型按钮
        btn.getButton().add(new ViewButton("二手图书管理平台","http://bookshop.free.idcfengye.com/login"));
        btn.getButton().add(new ViewButton("百度一下，你就知道","https://www.baidu.com"));
        //将按钮转为json字符串
        JSONObject jsonObject = JSONObject.fromObject(btn);
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", WxService.getAccess_Token());
        System.out.println(url);
        //发送请求
        String result = WxService.post(url,jsonObject.toString());
        System.out.println(result);
    }


}
