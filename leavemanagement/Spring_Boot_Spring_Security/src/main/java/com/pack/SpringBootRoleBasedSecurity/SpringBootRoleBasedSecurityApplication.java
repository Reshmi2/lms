package com.pack.SpringBootRoleBasedSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/
//https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class SpringBootRoleBasedSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRoleBasedSecurityApplication.class, args);
	}
	
	 @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("classpath:validation");
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }
	    @Bean
	    public LocalValidatorFactoryBean validator() {
	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	        bean.setValidationMessageSource(messageSource());
	        return bean;
	    }

}
