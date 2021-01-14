package com.yh.test.util;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ESUtil {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     */
    public void createIndex(String indexName) throws Exception {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(
                createIndexRequest, RequestOptions.DEFAULT
        );
    }

    /**
     * 判断是否存在索引
     */
    public boolean isExistIndex(String indexName) throws Exception {
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        return restHighLevelClient.indices().exists(getIndexRequest,
                RequestOptions.DEFAULT);
    }

    /**
     * 删除索引
     */
    public void deleteIndex(String indexName) throws Exception {
        if (!this.isExistIndex(indexName)) {
            return;
        }
        restHighLevelClient.indices().delete(new
                        DeleteIndexRequest(indexName),
                RequestOptions.DEFAULT
        );
    }
}
