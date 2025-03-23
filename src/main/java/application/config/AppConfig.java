package application.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "application")
public class AppConfig {
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ticket_app?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("application.model"); // Updated to match Book package
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(Environment.DIALECT,
                "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty(Environment.HBM2DDL_AUTO,
                "update"); // Changed to update for persistence
        hibernateProperties.setProperty(Environment.SHOW_SQL, "true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}
