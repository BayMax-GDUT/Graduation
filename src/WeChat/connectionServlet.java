package WeChat;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@WebServlet("/connection")
public class connectionServlet extends HttpServlet {

    public static final String TOKEN = "sunny";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
//        signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
//        timestamp	时间戳
//        nonce	随机数
//        echostr	随机字符串
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(signature);
        //校验签名
        if(check(signature,timestamp,nonce))
        {
            System.out.println("接入成功");
            PrintWriter writer = response.getWriter();
            writer.print(echostr);
        }
        else
        {
            System.out.println("接入失败");
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException {
        ServletInputStream is = request.getInputStream();
        byte[] b = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = is.read(b)) != -1)
        {
            sb.append(new String(b,0,len));
        }
        System.out.println(sb.toString());
    }

    public static boolean check(String signature,String timestamp,String nonce)
    {
//    1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[]{TOKEN,timestamp,nonce};
        Arrays.sort(strs);
//    2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String mySig = sha1(str);
//    3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        System.out.println(mySig);
        return mySig.equalsIgnoreCase(signature);

    }

    public static String sha1(String src)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");

            byte[] bytes = md.digest(src.getBytes());
            char[] character = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            for(byte b:bytes)
            {
                sb.append(character[(b>>4)&15]);
                sb.append(character[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
            return null;
    }
}
