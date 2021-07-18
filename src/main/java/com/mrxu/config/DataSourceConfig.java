package com.mrxu.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.mrxu")
public class DataSourceConfig {

    @Bean(name = "dev")
    @ConfigurationProperties(prefix = "spring.datasource.dev")
    public DataSource dev() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fat")
    @ConfigurationProperties(prefix = "spring.datasource.fat")
    public DataSource fat() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pro")
    @ConfigurationProperties(prefix = "spring.datasource.pro")
    public DataSource pro() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name="dynamicDataSource")
    @Primary
    public DynamicDataSource dynamicDataSource(@Qualifier("dev") DataSource dev,
                                        @Qualifier("fat") DataSource fat,
                                        @Qualifier("pro") DataSource pro){
        Map<Object, Object> targetDataSourceMap = new HashMap<>();
        targetDataSourceMap.put(DatabaseType.dev, dev);
        targetDataSourceMap.put(DatabaseType.fat, fat);
        targetDataSourceMap.put(DatabaseType.pro, pro);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(dev);
        return dynamicDataSource;
    }

    @Bean(name="sessionFactory")
    public SqlSessionFactory sessionFactory(@Qualifier("dynamicDataSource")DynamicDataSource dynamicDataSource) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dynamicDataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sessionFactoryBean.setMapperLocations(resolver.getResources(environment.getProperty("mybatis.mapperLocations")));    //*Mapper.xml位置
        return sessionFactoryBean.getObject();
    }

}