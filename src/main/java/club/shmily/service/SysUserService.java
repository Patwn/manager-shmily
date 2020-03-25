package club.shmily.service;

import club.shmily.model.SysUser;

import java.util.List;

/**
 * @author sweet
 * @create 2020-03-25-14:59
 */
public interface SysUserService {
    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();
}
