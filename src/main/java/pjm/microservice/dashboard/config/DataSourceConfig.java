package pjm.microservice.dashboard.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration(proxyBeanMethods = false)
public class DataSourceConfig {
//    @Bean(name = "bsiMitraGunaDataSource")
    @Bean
    @Primary
    @ConfigurationProperties("spring.bsi-mitra-guna-data-source")
    public DataSourceProperties bsiMitraGunaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.bsi-mitra-guna-data-source.configuration")
    public HikariDataSource bsiMitraGunaDataSource(DataSourceProperties bsiMitraGunaDataSourceProperties) {
        return bsiMitraGunaDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties("spring.master-data-source")
    public BasicDataSource masterDataSource() {
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }

  /*  @Bean
//    @Primary
    @ConfigurationProperties("spring.master-data-source")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
//    @Primary
    @ConfigurationProperties("spring.master-data-source.configuration")
    public HikariDataSource masterDataSource(DataSourceProperties masterDataSourceProperties) {
        return masterDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }*/

    /*@Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.bsi-mitra-guna-data-source")
    public DataSourceProperties bsiMitraGunaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.bsi-mitra-guna-data-source.configuration")
    public HikariDataSource bsiMitraGunaDataSource(
            DataSourceProperties bsiMitraGunaDataSourceProperties
    ) {
        return bsiMitraGunaDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.master-data-source")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.master-data-source.configuration")
    public HikariDataSource masterDataSource(
            DataSourceProperties masterDataSourceProperties
    ) {
        return masterDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    // Template
    @Bean
    public JdbcTemplate bsiMitraGunaJdbcTemplate(@Qualifier("bsiMitraGunaDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }*/


//    @Bean(name = "datasource1")
//    @ConfigurationProperties("spring.bsi-mitra-guna-data-source")
//    @Primary
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "datasource2")
//    @ConfigurationProperties("spring.master-data-source")
//    public DataSource dataSource2() {
//        return DataSourceBuilder.create().build();
//    }


//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/dbbsimitragunanew_2");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("");


}
