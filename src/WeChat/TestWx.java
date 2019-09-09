package WeChat;


import net.sf.json.JSONObject;
import org.junit.Test;

public class TestWx
{
   /*
    "access_token": "21_5QmGlVUjmB6VPrJ97MDE2ZUyFtEja7LtOMEN-CkcwXZ-GrKFosDoQCyGydUNtpUZSbYB1jv_SXxVSXOHA-YlreoVhQOXBeS_o0AuEDUufJ5C-xSjqT4w5J4sjFk7mfm6f4FPfy_ktWRilf9LKDGgAHAEXA"
    "expires_in": 7200
    */

   /*
   {
     "button":[
     {
          "type":"view",
          "name":"二手书管理平台",
          "url":"http://bookshop.free.idcfengye.com/login"
      }]
 }
    */

   @Test
   public void testButton()
   {
        Button btn = new Button();
        btn.getButton().add(new ViewButton("二手图书管理平台","http://bookshop.free.idcfengye.com/login"));
       JSONObject jsonObject = JSONObject.fromObject(btn);
       System.out.println(jsonObject.toString());
   }

   @Test
    public void testAccess_Token()
   {
       System.out.println(WxService.getAccess_Token());
       System.out.println(WxService.getAccess_Token());
   }
}
