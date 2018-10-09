package com.chatback.controllers;

import com.chatback.pojos.match.Match;
import com.chatback.pojos.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
public class MatchController extends Controller
{

    @Autowired
    private MatchService matchService;

    @CrossOrigin
    @RequestMapping(value = "match", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Match requestMatch(@RequestBody Match match) throws Exception
    {
        Match toReturn = match;
        try
        {
            match.setTimestamp(String.valueOf(System.currentTimeMillis()));
            match = matchService.getMatch(match);
            return match;
        }
        catch (Exception e)
        {
            Logger.getAnonymousLogger().info(e.getLocalizedMessage());
            throw new Exception();
        }
        finally
        {
            try
            {
                if (match.isMatched()) {
                    match.setDelivered(true);
                    Logger.getAnonymousLogger().info("delivering " + match.toString());
                } else {
                    Logger.getAnonymousLogger().info("failed to match  " + match.toString());
                }
                matchService.removeMatch(match, match::getPartner, match::isDelivered);
                matchService.removeOld();
            }
            catch (Exception e)
            {
                Logger.getAnonymousLogger().info(e.getLocalizedMessage());
            }
        }
    }
}
