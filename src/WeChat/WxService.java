package WeChat;

import net.sf.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WxService
{
    //跟微信的各种服务的对接类

    public static final String APPID = "wxa5d8ebd314d1f5c6";
    public static final String APPSECRET = "e13170002674094a7e5ab9ec310830eb";
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static Access_Token at;

    public static String post(String url,String data) {
        try {
            URL urlObj = new URL(url);
            URLConnection urlConnection = urlObj.openConnection();
            //设置为可发送状态
            urlConnection.setDoOutput(true);
            //获取输出流
            OutputStream os = urlConnection.getOutputStream();
            //写出数据
            os.write(data.getBytes());
            //关闭流
            os.close();
            //获取输入流
            InputStream is = urlConnection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while((len = is.read(b)) != -1)
            {
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String get(String url) {
        try {
            URL urlObj = new URL(url);
            //开连接
            URLConnection connection = urlObj.openConnection();
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while((len = is.read(b)) != -1)
            {
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getToken()
    {
        String url = GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        String jsonStr = get(url);
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        String access_token = jsonObject.getString("access_token");
        long expires_in = Long.parseLong(jsonObject.getString("expires_in"));
        at = new Access_Token(access_token,expires_in);
    }

    public static String getAccess_Token()
    {
        if(at == null || at.isExpired())
        {
            getToken();
        }
            return at.getaccess_token();
    }
}
