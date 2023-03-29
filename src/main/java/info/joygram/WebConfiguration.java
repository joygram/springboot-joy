package info.joygram;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

// public class WebConfiguration {
// 	@Bean 
// 	public HttpMessageConverters customConverters() {
// 		        HttpMessageConverter<?> additional = ...
//                 HttpMessageConverter<?> another = ...
//                 return new HttpMessageConverters(additional, another);
// 	}
// }

//메시지 컨버터를 호출하는 구간 
/**
@Configuration 
public class WebConfiguration {
	@Order(0)
	@Bean 
	public Filter webFilter() {
		return new WebFilter();
	}
}
*/
//일부 url에만 동작하게 하고 싶다.
@Configuration
public class WebConfiguration {
	@Order(0)
	@Bean
	public FilterRegistrationBean<WebFilter> loggingFilter() {
		FilterRegistrationBean<WebFilter> reg_bean = new FilterRegistrationBean<>();
		reg_bean.setFilter(new WebFilter());
		reg_bean.addUrlPatterns("/info/*");
		return reg_bean;
	}
}