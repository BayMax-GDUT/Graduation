package WeChat;

public class Access_Token
{
    private String access_token;
    private long expires_in;

    public String getaccess_token() {
        return access_token;
    }

    public void setaccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public Access_Token(String name,long expires_in)
    {
        this.access_token = name;
        this.expires_in = System.currentTimeMillis() + expires_in * 1000;
    }

    public boolean isExpired()
    {
        return System.currentTimeMillis()>this.expires_in;
    }
}
