package pojos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Credentials
{
    String text;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        String response = null;
        ObjectMapper mapper = new ObjectMapper();

        try
        {
         response = mapper.writeValueAsString(this);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
