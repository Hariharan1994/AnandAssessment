package com.anand.task.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.anand.task.log.ConsoleLog;

/**
 * TaskWebSecurityConfig class is used for defining configuration.
 * This class is initialized from TaskDispatcherInitializer (getRootConfigClasses()).
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
@Configuration
@ComponentScan("com.anand.task.dao")
@ComponentScan("com.anand.task.service")
@ComponentScan("com.anand.task.config")
public class TaskWebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Bean
	public DataSource setDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.postgresql.Driver");
	    dataSource.setUrl("jdbc:postgresql://192.168.41.222:5432/account");
	    dataSource.setUsername("account");
	    dataSource.setPassword("account");
	    
	    ConsoleLog.printLogMessage("@ 02 - DataSource configured in TaskWebSecurityConfig");
	    return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}