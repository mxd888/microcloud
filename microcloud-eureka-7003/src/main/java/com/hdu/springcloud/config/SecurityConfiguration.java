package com.hdu.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.hdu.springcloud.EurekaServer7003_App;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static Logger logger = LoggerFactory.getLogger(EurekaServer7003_App.class);
	 
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("eureka7003设置csrf校验关闭!");
        super.configure(http);
        http.csrf().disable();
    }


}
