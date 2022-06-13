package com.carry;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 这是一个配置类
 */
//@Import({ MainConfig.MyImportRegistrar.class})
//@Import(AspectJAutoProxyRegistrar.class)
@ComponentScan({"com.carry"})
@Configuration
public class MainConfig {

	public MainConfig(){
		System.out.println("MainConfig...创建了....");
	}



	@Bean //配置视图解析器
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		//配置前缀
		internalResourceViewResolver.setPrefix("/");
		//配置后缀
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

}


