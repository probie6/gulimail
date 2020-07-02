package es;

import static org.probie.gulimail.es.config.ElasticSearchConfig.COMMON_OPTIONS;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import es.Sku.Attr;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.runner.RunWith;
import org.probie.gulimail.es.EsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 保存数据
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class IndexTest {

  @Autowired
  private RestHighLevelClient client;

  @org.junit.Test
  public void loadContext() {
    System.out.println(client);
  }

  /**
   * 存储数据
   */
  @org.junit.Test
  public void indexData() throws IOException {
    IndexRequest request = new IndexRequest("posts");
    request.id("1");
    String jsonString = "{" +
        "\"user\":\"kimchy\"," +
        "\"postDate\":\"2013-01-30\"," +
        "\"message\":\"trying out Elasticsearch\"" +
        "}";
    request.source(jsonString, XContentType.JSON);
    // ID相同调用多次version递增，数据更新
    client.index(request, COMMON_OPTIONS);
  }

  /**
   * 存储数据
   */
  @org.junit.Test
  public void indexData1() throws IOException {
    IndexRequest request = new IndexRequest("product");
    request.id("1");
    Sku sku = new Sku();
    Attr attr1 = new Attr(14, "麒麟521", "16");
    Attr attr2 = new Attr(16, "麒麟530", "32");
    sku.setSkuId("1");
    sku.setAttrs(Lists.newArrayList(attr1, attr2));
    sku.setContent("我是一只小小小小鸟");
    request.source(new Gson().toJson(sku), XContentType.JSON);
    // ID相同调用多次version递增，数据更新
    client.index(request, COMMON_OPTIONS);
  }

  /**
   * 测试版本冲突报错
   */
  @org.junit.Test
  public void testConflict() throws IOException {
    IndexRequest request = new IndexRequest("posts")
        .id("1")
        .source("field", "value")
        .opType(DocWriteRequest.OpType.CREATE); // OpType CREATE会出现CONFLICT
    client.index(request, RequestOptions.DEFAULT);
  }

}

class Sku {
  String skuId;
  private List<Attr> attrs;
  private String content;

  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }

  public List<Attr> getAttrs() {
    return attrs;
  }

  public void setAttrs(List<Attr> attrs) {
    this.attrs = attrs;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public static class Attr{
    private int screenSize;
    private String cpu;
    private String cache;

    public Attr(int screenSize, String cpu, String cache) {
      this.screenSize = screenSize;
      this.cpu = cpu;
      this.cache = cache;
    }
  }
}
