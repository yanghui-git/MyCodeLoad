package com.yh.test.util;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESClient {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        HttpHost[] httpHosts = new HttpHost[]{new HttpHost(
                "localhost", 9200
        )};
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(httpHosts)
        );

        System.out.println("es 客户端连接成功........................."+restHighLevelClient);

        return restHighLevelClient;
    }
}
