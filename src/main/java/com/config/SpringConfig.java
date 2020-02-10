package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"com.service", "com.dao"})//����� ������� �� ������ �������� ����� ����� ���
//������� � ����� ��� ���� ����� � Spring ��� ������� ���
public class SpringConfig {

 //   @Bean
//    public UserService getUserService(){   THIS DELETE
//        return new UserServiceImpl ();
//    }
    //    @Bean
//    public UserDao getUserDao(){ //��� �� ������� ��� ����� �������� � ��� �������� ����� ����
//        return new UserDaoImpl (getJdbcTemplate ());
//    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
       return new JdbcTemplate(getDataSource());

    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/vebinar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC?useSLL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }



}
