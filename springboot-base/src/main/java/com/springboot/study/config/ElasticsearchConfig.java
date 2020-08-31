
package com.springboot.study.config;

import java.time.Duration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**    
 * @Description: 高级REST客户端 https://docs.spring.io/spring-data/elasticsearch/docs/4.0.1.RELEASE/reference/html/#reference
 * @author: chenjun
 * @date: 2020年7月2日 下午1:57:56    
 */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
	
	@Value("${elasticsearch.config.hosts}")
    private String hosts;

	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(hosts).withConnectTimeout(Duration.ofSeconds(10))                            
				  .withSocketTimeout(Duration.ofSeconds(5)).build();	
		return RestClients.create(clientConfiguration).rest();
	}
}