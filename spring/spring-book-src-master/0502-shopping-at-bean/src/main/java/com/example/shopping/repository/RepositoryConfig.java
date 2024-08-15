package com.example.shopping.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    @Bean
    OrderItemRepository orderItemRepository(DataSource dataSource) {
        return new JdbcOrderItemRepository(dataSource);
    }

    @Bean
    OrderRepository orderRepository(DataSource dataSource) {
        return new JdbcOrderRepository(dataSource);
    }

    @Bean
    ProductRepository productRepository(DataSource dataSource) {
        return new JdbcProductRepository(dataSource);
    }
}
