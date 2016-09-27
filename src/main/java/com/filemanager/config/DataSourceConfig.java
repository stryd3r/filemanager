package com.filemanager.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	private static final String PACKAGES_TO_SCAN = "com.filemanager.utils.transporters.entities";

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/stomato");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(PACKAGES_TO_SCAN);

		Properties hibernateProperties = new Properties();

		hibernateProperties.put("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
		hibernateProperties.put(Environment.SHOW_SQL, "true");
		factory.setHibernateProperties(hibernateProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public HibernateTransactionManager transactionManager() throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory());
		transactionManager.setDataSource(dataSource());

		return transactionManager;
	}

}
