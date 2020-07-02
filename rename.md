docker��װes��[docker run -d --name es -p 9200:9200 -p 9300:9300 -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -e "discovery.type=single-node" elasticsearch:7.4.2]

docker��װkibana [docker run --name kibana -e ELASTICSEARCH_HOSTS=http://172.17.0.3:9200 -p 5601:5601 -d kibana:7.4.2]

��װik�ִ���:[����https://github.com/medcl/elasticsearch-analysis-ik/releases��Ӧ��zip������es pluginĿ¼�´���ikĿ¼����zip���ļ�ȫ����ѹ��ikĿ¼��,ע���ڴ�������ʱ��Ҫָ���ֶ�ʹ�����ִַ�������ָ����Ĭ��ʹ��standard�ִ���]

##��������ָ���ִ���
PUT /product
{
  "settings":{
    "number_of_shards": "6",
    "number_of_replicas": "1",  
     //ָ���ִ���  
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
