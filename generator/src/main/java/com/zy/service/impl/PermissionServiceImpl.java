package com.zy.service.impl;

import com.zy.entity.Permission;
import com.zy.dao.PermissionDao;
import com.zy.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements IPermissionService {

}
