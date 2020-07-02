docker安装es：[docker run -d --name es -p 9200:9200 -p 9300:9300 -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -e "discovery.type=single-node" elasticsearch:7.4.2]

docker安装kibana [docker run --name kibana -e ELASTICSEARCH_HOSTS=http://172.17.0.3:9200 -p 5601:5601 -d kibana:7.4.2]

安装ik分词器:[下载https://github.com/medcl/elasticsearch-analysis-ik/releases对应的zip包，在es plugin目录下创建ik目录，将zip包文件全部解压在ik目录下,注：在创建索引时需要指定字段使用哪种分词器，不指定则默认使用standard分词器]

##创建索引指定分词器
PUT /product
{
  "settings":{
    "number_of_shards": "6",
    "number_of_replicas": "1",  
     //指定分词器  
    "analysis":{   
      "analyzer":{
        "ik":{
          "tokenizer":"ik_max_word"
        }
      }
    }
  },
  "mappings" : {
    "properties" : {
        "content" : {
            "type" : "text",
            "analyzer" : "ik_max_word"
        },
        "attrs": {
          "properties" : {
            "cache" : {
              "type" : "text",
              "analyzer": "ik_max_word"
            },
            "cpu" : {
              "type" : "text",
              "analyzer": "ik_max_word"
            },
            "screenSize" : {
              "type" : "long"
            }
          }
        }
      }
  }
}
