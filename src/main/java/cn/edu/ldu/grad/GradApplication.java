package cn.edu.ldu.grad;

import org.krysalis.barcode4j.servlet.BarcodeServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import cn.edu.ldu.grad.intercepter.UserLogonInftercepter;

@SpringBootApplication
@MapperScan(value = {"cn.edu.ldu.grad.mapper"})
public class GradApplication implements WebMvcConfigurer {

  @Autowired
  private UserLogonInftercepter userLogonInftercepter;

  public static void main(String[] args) {
    SpringApplication.run(GradApplication.class, args);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // registry.addInterceptor(userLogonInftercepter);
  }

  @Bean // 添加@Bean的注释
  public ServletRegistrationBean getServlet() {
    // 通过ServletRegistrationBean完成对servlet的注册
    ServletRegistrationBean bean = new ServletRegistrationBean(new BarcodeServlet());
    bean.addUrlMappings("/barcodeservlet");
    return bean; // 将对象返回
  }
}
