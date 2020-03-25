package club.shmily.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sweet
 * @create 2020-03-25-11:03
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public Object hello(){
        return "hello";
    }
}
