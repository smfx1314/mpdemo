package com.jiangfeixiang.mpdemo.springbootmp.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ProjectName: mpdemo
 * @Package: com.jiangfeixiang.mpdemo.springbootmp.config
 * @ClassName: MybatisPlusConfig
 * @Author: jiangfeixiang
 * @email: 1016767658@qq.com
 * @Description: MybatisPlus分页配置
 * @Date: 2019/5/12/0012 19:56
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.jiangfeixiang.mpdemo.springbootmp.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
