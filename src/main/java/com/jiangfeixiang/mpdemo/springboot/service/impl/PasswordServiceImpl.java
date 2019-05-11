package com.jiangfeixiang.mpdemo.springboot.service.impl;

import com.jiangfeixiang.mpdemo.springboot.entity.Password;
import com.jiangfeixiang.mpdemo.springboot.mapper.PasswordMapper;
import com.jiangfeixiang.mpdemo.springboot.service.IPasswordService;
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
public class PasswordServiceImpl extends ServiceImpl<PasswordMapper, Password> implements IPasswordService {

}
