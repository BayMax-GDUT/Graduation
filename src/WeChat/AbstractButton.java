package WeChat;

public abstract class AbstractButton
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AbstractButton(){}

    public AbstractButton(String name)
    {
        this.name = name;

    }}
