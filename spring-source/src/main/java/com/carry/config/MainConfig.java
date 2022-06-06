package com.carry.config;



import com.carry.bean.Cat;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 这是一个配置类
 */
//@Import({ MainConfig.MyImportRegistrar.class})
//@Import(AspectJAutoProxyRegistrar.class)
@ComponentScan("com.carry")
@Configuration
public class MainConfig {

	public MainConfig(){
		System.out.println("MainConfig...创建了....");
	}



	/**
	 * 		BeanDefinitionRegistry：Bean定义信息注册中心：图纸中心;
	 * 				它里面都是BeanDefinition
	 *
	 * 	<bean class="com.atguigu.spring.bean.Person" id="person">
	 * 		<property name="name" value="张三"/>
	 * 	</bean>
	 * 	 对应
	 * 	RootBeanDefinition
	 *
	 */
//	static class MyImportRegistrar implements ImportBeanDefinitionRegistrar{
//		@Override
//		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
//											BeanDefinitionRegistry registry) {
//
//
//			// BeanDefinition
//			RootBeanDefinition catDefinition = new RootBeanDefinition();
//			catDefinition.setBeanClass(Cat.class);
////			catDefinition.setInitMethodName("aaa");
//			//可以声明定义信息，包括我需要自动装配什么？
////			catDefinition.setInstanceSupplier(()-> new Cat());
//			//Spring 这个实例的类型，名字
//			registry.registerBeanDefinition("tomCat",catDefinition);
//		}
//	}
}


