package club.shmily;

import club.shmily.dao.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManagerApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    void contextLoads() {
        System.out.println(sysUserMapper.findAll());
    }

}
