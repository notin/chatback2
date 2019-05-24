package java.com.aws.codestar.components.controller;

import com.aws.codestar.components.pojo.ObitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@RestController
@RequestMapping("/obit")
public class ObitController
{
    @Autowired
    private ObitService obitService;

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void receive(@RequestBody String id)
    {
        obitService.findObit(id);
    }
}
