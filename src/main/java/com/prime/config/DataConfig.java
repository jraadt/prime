package com.prime.config;

import com.prime.domain.AtBat;
import com.prime.domain.Pitch;
import com.prime.domain.Player;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DataConfig implements TransactionManagementConfigurer {

  @Autowired
  Environment env;

  @Bean
  public DataSource dataSource() {
    final DataSource dataSource = new DataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl(env.getProperty("jdbc.url"));
    dataSource.setUsername(env.getProperty("jdbc.username"));
    dataSource.setPassword(env.getProperty("jdbc.password"));
    dataSource.setTestOnBorrow(true);
    dataSource.setTestWhileIdle(true);
    dataSource.setTestOnReturn(false);
    dataSource.setValidationQuery("SELECT 1");
    dataSource.setValidationInterval(30000);
    dataSource.setTimeBetweenEvictionRunsMillis(5000);
    dataSource.setMaxActive(100);
    dataSource.setMinIdle(10);
    dataSource.setMaxWait(10000);
    dataSource.setInitialSize(10);
    dataSource.setRemoveAbandonedTimeout(3600);
    dataSource.setRemoveAbandoned(true);
    dataSource.setLogAbandoned(true);
    dataSource.setMinEvictableIdleTimeMillis(30000);
    return dataSource;
  }

  @Bean
  public SessionFactory sessionFactory() {
    return new LocalSessionFactoryBuilder(dataSource())
        .addAnnotatedClasses(
            AtBat.class,
            Pitch.class,
            Player.class
        )
        .addProperties(hibernateProperties())
        .buildSessionFactory();
  }

  @Bean
  public Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    properties.put("hibernate.show_sql", "false");
    properties.put("hibernate.id.new_generator_mappings", "true");
    properties.put("jadira.usertype.autoRegisterUserTypes", "true");

    return properties;
  }

  @Override
  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return new HibernateTransactionManager(sessionFactory());
  }

}
