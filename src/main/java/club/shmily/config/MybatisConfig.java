package club.shmily.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author sweet
 * @create 2020-03-24-19:14
 */
@Configuration
@MapperScan("club.shmily.dao")
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("club.shmily.**.model");
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        //扫描映射文件
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }
}
