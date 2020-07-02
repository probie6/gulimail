package org.probie.gulimail.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ElasticSearchConfig {
  public static final RequestOptions COMMON_OPTIONS;
  static {
    RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
//    builder.addHeader("Authorization", "Bearer " + TOKEN);
//    builder.setHttpAsyncResponseConsumerFactory(
//        new HttpAsyncResponseConsumerFactory
//            .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
    COMMON_OPTIONS = builder.build();
  }
  @Bean
  public RestHighLevelClient esClient() {
    return new RestHighLevelClient(
        RestClient.builder(new HttpHost("localhost", 9200, "http")));
  }
}
