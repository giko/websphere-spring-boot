package org.kluge;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;


/**
 * Created by giko on 5/22/2016.
 */
@Configuration
@DependsOn("hibernatePersistenceProviderResolver")
public class HikariCPConfig {
    @Value("${hikari.driverclassname}")
    private String driverClassName;

    @Value("${hikari.jdbc.url}")
    private String jdbcUrl;

    @Value("${hikari.username}")
    private String userName;

    @Value("${hikari.password}")
    private String password;

    @Value("${hikari.pool.size}")
    private int poolSize;


    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(poolSize);
        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}