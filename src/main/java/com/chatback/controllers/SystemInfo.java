package com.chatback.controllers;

import com.chatback.pojos.SysInfo.SysInfo;
import com.chatback.pojos.db.DBConnection;
import org.springframework.web.bind.annotation.*;

@RestController
public class SystemInfo extends com.chatback.controllers.Controller {
    @RequestMapping(value = "sysinfo", method = RequestMethod.GET)
    public SysInfo retrieve() {
        SysInfo sysInfo = SysInfo.builder().build();
        sysInfo.setIp(com.chatback.controllers.Controller.IP);
        return sysInfo;
    }

}
