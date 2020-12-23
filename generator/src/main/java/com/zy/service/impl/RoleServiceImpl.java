package com.zy.service.impl;

import com.zy.entity.Role;
import com.zy.dao.RoleDao;
import com.zy.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zengyu
 * @since 2020-12-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements IRoleService {

}
