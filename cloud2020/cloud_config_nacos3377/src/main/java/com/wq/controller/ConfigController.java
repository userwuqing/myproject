package com.wq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 *
 * @author v_qqinwu
 * @date 2020年07月15日 18:57
 */

@RestController
@RefreshScope //保证nacos配置中心更新后这里自动刷新
@RequestMapping("config")
public class ConfigController {

    @Value("${config.info}")
    private String config;

    @GetMapping("getConfig.do")
    public String getConfig() {

        return config;
    }
}
