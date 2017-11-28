package tutorial.app.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tutorial.app.dao.StudentDAO;
import tutorial.app.dao.StudentDAOImpl;

/**
 * @author vanvtt
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("tutorial.app.*")
@PropertySource("classpath:datasources.properties")
public class AppConfig {
	// Lưu trữ các giá thuộc tính load bởi @PropertySource.
	@Autowired
	private Environment env;

	// @Autowired
	// @Bean(name = "sessionFactory")
	// public LocalSessionFactoryBean getSessionFactory() {
	// LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// sessionFactory.setDataSource(getDataSource());
	// sessionFactory.setPackagesToScan(new String[] { "tutorial.app.model" });
	// sessionFactory.setHibernateProperties(hibernateProperties());
	// return sessionFactory;
	// }

	// @Bean(name = "dataSource")
	// public DataSource getDataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName(env.getProperty("mysql.driver"));
	// dataSource.setUrl(env.getProperty("mysql.url"));
	// dataSource.setUsername(env.getProperty("mysql.user"));
	// dataSource.setPassword(env.getProperty("mysql.password"));
	// return dataSource;
	// }

	// @Autowired
	// @Bean(name = "transactionManager")
	// public HibernateTransactionManager getTransactionManager(SessionFactory
	// sessionFactory) {
	// HibernateTransactionManager transactionManager = new
	// HibernateTransactionManager(sessionFactory);
	//
	// return transactionManager;
	// }

	@Bean(name = "dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("mysql.driver"));
		ds.setUrl(env.getProperty("mysql.url"));
		ds.setUsername(env.getProperty("mysql.user"));
		ds.setPassword(env.getProperty("mysql.password"));
		return ds;
	}

	/**
	 * Cofigure SessionFactory to connect model.
	 */
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
		builder.scanPackages("tutorial.app.model").addProperties(hibernateProperties());

		return builder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		return properties;
	}

	// @Bean(name = "studentDAO")
	// public StudentDAO getStudentDAO() {
	// return new StudentDAOImpl(getSessionFactory().getObject());
	// }

}
