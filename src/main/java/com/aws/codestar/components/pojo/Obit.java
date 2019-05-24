package com.aws.codestar.components.pojo;

import com.google.gson.Gson;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

@Entity
@Getter
public class Obit
{
    @Id
    private String id;
    private Date pubDate;
    private String name;

    public Obit(String pubDate, String name)
    {
        parseDate(pubDate);
        this.name = name;
    }

    private void parseDate(String pubDate)
    {
        String[] split = pubDate.split("to |on ");
        pubDate = split[split.length-1];
        try
        {
            this.pubDate = new SimpleDateFormat("MMMM dd, yyyy", Locale.US).parse(pubDate);
        }
        catch (Exception e)
        {}
    }

    @Override
    public String toString()
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(this);
        return jsonString;
    }

    public Date getPubDate()
    {

        if(pubDate!=null)
        {
            Logger.getAnonymousLogger().info("getting date of " + pubDate);
        }
        else
        {
            Logger.getAnonymousLogger().info("check this");
            try
            {
                pubDate = new SimpleDateFormat("MMMM dd, yyyy", Locale.US).parse("Dec 25, 2019");
            }
            catch (Exception e)
            {

            }
        }
        return pubDate;
    }
}
