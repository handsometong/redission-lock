package com.tom.demo.lock.redisson.config;

import com.tom.demo.lock.redisson.interceptors.PerformanceInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
;

/**  
 * @author handsometong
 * @Date 2022年11月9日 下午3:10:58
 * @version 1.0.0
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("add interceptors");
		registry.addInterceptor(new PerformanceInterceptor());
	}
}
