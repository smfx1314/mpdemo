package com.jiangfeixiang.mpdemo.springboot.service.impl;

import com.jiangfeixiang.mpdemo.springboot.entity.User;
import com.jiangfeixiang.mpdemo.springboot.mapper.UserMapper;
import com.jiangfeixiang.mpdemo.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 姜飞祥
 * @since 2019-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
