package com.project3.tpbooking.config.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class Config extends AbstractElasticsearchConfiguration {

    ///@Value("${elasticsearch.url}")
    private String elasticsearchUrl="127.0.0.1:9200";

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration config = ClientConfiguration.builder()
                .connectedTo(elasticsearchUrl).build();
        return RestClients.create(config).rest();
    }
}