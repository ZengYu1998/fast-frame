package com.zy.service.impl;

import com.zy.entity.UserInfo;
import com.zy.dao.UserInfoDao;
import com.zy.service.IUserInfoService;
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
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements IUserInfoService {

}
