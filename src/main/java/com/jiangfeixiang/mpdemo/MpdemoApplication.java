package com.jiangfeixiang.mpdemo;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.jiangfeixiang.mpdemo.springbootmp.mapper")
public class MpdemoApplication {

    /**
     * 分页插件
     */


    public static void main(String[] args) {
        SpringApplication.run(MpdemoApplication.class, args);
    }

}
