package club.shmily.controller;

import club.shmily.model.SysUser;
import club.shmily.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sweet
 * @create 2020-03-25-15:20
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/findAll")
    public List<SysUser> findAll(){
        System.out.println(123);
        return sysUserService.findAll();
    }
}
