package es;

import static org.probie.gulimail.es.config.ElasticSearchConfig.COMMON_OPTIONS;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.probie.gulimail.es.EsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class SearchTest {
  @Autowired
  private RestHighLevelClient client;

  @Test
  public void search() throws IOException {
    SearchRequest searchRequest = new SearchRequest();
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(QueryBuilders.matchAllQuery());
    searchRequest.source(searchSourceBuilder);
    SearchResponse searchResponse = client.search(searchRequest, COMMON_OPTIONS);
    System.out.println(searchResponse);
  }

  @Test
  public void test() {
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    sourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
    sourceBuilder.from(0);
    sourceBuilder.size(5);
  }
}
