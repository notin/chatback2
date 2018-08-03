package com.chatback.controllers;

import com.chatback.broker.database.DatabaseBroker;
import com.chatback.pojos.SysInfo.SysInfo;
import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class SystemInfo extends com.chatback.controllers.Controller
{
    @RequestMapping(value = "sysinfo", method = RequestMethod.GET)
    public SysInfo retrieve()
    {
        SysInfo sysInfo = SysInfo.builder().build();
        sysInfo.setIp(com.chatback.controllers.Controller.IP);
       return sysInfo;
    }

}
