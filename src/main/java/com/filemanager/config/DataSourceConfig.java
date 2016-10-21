package com.filemanager.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
//@EnableTransactionManagement
public class DataSourceConfig {

	private static final String PACKAGES_TO_SCAN = "com.filemanager.utils.transporters.entities";
	private DataSource dataSource;

	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	// dataSource.setUrl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7140776");
	// dataSource.setUsername("sql7140776");
	// dataSource.setPassword("g4Tcxnf6z4");
	// // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	// // dataSource.setUrl("jdbc:mysql://localhost:3306/stomato");
	// // dataSource.setUsername("root");
	// // dataSource.setPassword("mysql");
	// return dataSource;
	// }

//	@Bean
//	public JdbcTemplate setJdbcTemplate(DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}

//	@Bean
//	public SessionFactory sessionFactory() throws IOException {
//		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
//		factory.setDataSource(dataSource);
//		factory.setPackagesToScan(PACKAGES_TO_SCAN);
//
//		Properties hibernateProperties = new Properties();
//
//		hibernateProperties.put("dialect",
//				"org.hibernate.dialect.MySQLInnoDBDialect");
//		hibernateProperties.put(Environment.SHOW_SQL, "true");
//		factory.setHibernateProperties(hibernateProperties);
//		factory.afterPropertiesSet();
//		return factory.getObject();
//	}
//
//	@Bean
//	public HibernateTransactionManager transactionManager() throws IOException {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//				sessionFactory());
//		transactionManager.setDataSource(dataSource);
//
//		return transactionManager;
//	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
