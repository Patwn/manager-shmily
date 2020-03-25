package club.shmily.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author sweet
 * @create 2020-03-25-17:44
 */
@Configuration
@EnableConfigurationProperties(DruidDataSourceProperties.class)//用于导入上一步druid的配置信息
public class DruidConfig {
    @Autowired
    private DruidDataSourceProperties properties;
    @Bean
    @ConditionalOnMissingBean
    public DataSource druidDateSource() throws SQLException {
        DruidDataSource druidDateSource=new DruidDataSource();
        druidDateSource.setDriverClassName(properties.getDriverClassName());
        druidDateSource.setUrl(properties.getUrl());
        druidDateSource.setUsername(properties.getUsername());
        druidDateSource.setPassword(properties.getPassword());
        druidDateSource.setInitialSize(properties.getInitialSize());
        druidDateSource.setMinIdle(properties.getMinIdle());
        druidDateSource.setMaxActive(properties.getMaxActive());
        druidDateSource.setMaxWait(properties.getMaxWait());
        druidDateSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        druidDateSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        druidDateSource.setValidationQuery(properties.getValidationQuery());
        druidDateSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDateSource.setFilters(properties.getFilters());
        druidDateSource.setTestWhileIdle(properties.isTestWhileIdle());
        druidDateSource.setTestOnBorrow(properties.isTestOnBorrow());
        druidDateSource.setTestOnReturn(properties.isTestOnReturn());
        return druidDateSource;
    }
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean=new
                ServletRegistrationBean<Servlet>(new StatViewServlet(),"/druid/*");
        //白名单
        servletServletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //ip黑名单(存在共同时,deny优先于allow)
        //如果满足deny的话提示:sorry,you are not permitted to view this page.servletRegistrationBean.addInitParameter(
        //        "deny","xxxxx.xxx.xx.xx");
        //登录查看信息的账号密码,用于登录druid监控后台
        servletServletRegistrationBean.addInitParameter("loginUsername","admin");
        servletServletRegistrationBean.addInitParameter("loginPassword","admin");
        //是否能够重置数据
        servletServletRegistrationBean.addInitParameter("resetEnable","true");
        return servletServletRegistrationBean;
    }
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean=new FilterRegistrationBean<>();
        Filter filter=new Filter() {
            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            }
        };
        filterFilterRegistrationBean.setFilter(filter);
        return filterFilterRegistrationBean;
    }
}
