package com.chatback.controllers;

import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.message.Message;
import com.chatback.pojos.converation.message.MessageService;
import com.chatback.pojos.match.Match;
import com.chatback.pojos.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class MatchController extends Controller
{

    @Autowired
    private MatchService matchService;

    @CrossOrigin
    @RequestMapping(value = "match", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Match requestMatch(@RequestBody Match match)
    {
        Match toReturn = match;
        try
        {
            match.setTimestamp(String.valueOf(System.currentTimeMillis()));
            match = matchService.getMatch(match);
            return toReturn;
        }
        catch (Exception e)
        {
            Logger.getAnonymousLogger().info(e.getLocalizedMessage());
        }
        finally
        {
            match.setDelivered(true);
            matchService.removeMatch(match);
        }
        return toReturn;
    }
}
