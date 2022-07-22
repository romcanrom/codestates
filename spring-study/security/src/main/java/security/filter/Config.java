package security.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegister() {
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>(new FirstFilter());

        registrationBean.setOrder(2);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilterRegister() {
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>(new SecondFilter());

        registrationBean.setOrder(1); //실행 순서 지정 가능

        return registrationBean;
    }
}
