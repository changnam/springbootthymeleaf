package com.honsoft.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = "com.honsoft.mapper")
@EnableJpaRepositories(basePackages = "com.honsoft.repository",entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "mysqlJpaTransactionManager" )
public class MysqlDataSourceConfig {
	@Autowired
	private Environment env;
	
	@Bean
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSourceProperties mysqlDataSourceProperties() {
		DataSourceProperties properties = new DataSourceProperties();
		return properties;
	}
	
	@Bean
	public DataSource mysqlDataSource() {
		return mysqlDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build(); 
	}
	

	@Bean
	public DataSourceInitializer mysqlDataSourceInitializer(@Qualifier("mysqlDataSource") DataSource dataSource) {
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setEnabled(env.getProperty("mysql.datasource.initialize", Boolean.class, false));

		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setSqlScriptEncoding(env.getProperty("mysql.datasource.sql-script-encoding"));
		//populator.addScript(new ClassPathResource("schema-mysql.sql"));
		populator.addScript(new ClassPathResource("sql/data-mysql.sql"));

		initializer.setDatabasePopulator(populator);

		return initializer;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(mysqlDataSource());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setPackagesToScan("com.honsoft.entity");
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("mysql.jpa.hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", env.getProperty("mysql.jpa.hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("mysql.jpa.hibernate.format_sql"));
		properties.put("hibernate.dialect", env.getProperty("mysql.jpa.hibernate.dialect"));
		
		factory.setJpaProperties(properties);
		
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager mysqlJpaTransactionManager() {
		return new JpaTransactionManager(mysqlEntityManagerFactory().getObject());
	}
}
