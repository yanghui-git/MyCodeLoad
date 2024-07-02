package com.yh.test.util;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.*;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * https://blog.csdn.net/JacksonKing/article/details/104513527?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3.control
 * ElaticSearch
 */
@Component
public class ESUtil {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 创建索引
     */
    public void createIndex(String indexName) throws Exception {
        this.createIndex(indexName, "");
    }

    /**
     * 创建索引
     * 指定了创建索引的DSL语句
     */
    public void createIndex(String indexName, String dsl) throws Exception {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        if (!StringUtils.isEmpty(dsl)) {
            createIndexRequest.source(dsl, XContentType.JSON);
        }
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(
                createIndexRequest, RequestOptions.DEFAULT
        );
        System.out.println("索引创建成功...." + createIndexRequest);
    }


    /**
     * 查看索引结构
     */
    public Map getIndices(String indexName) throws Exception {
        if (!isExistIndex(indexName)) {
            throw new RuntimeException("不存在此索引......." + indexName);
        }
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        return restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT).getMappings().get(indexName).getSourceAsMap();
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
        //必须加此判断，不存在此索引的话，会抛出异常
        // [estest] ElasticsearchStatusException[Elasticsearch exception [type=index_not_found_exception, reason=no such index [estest]]
        if (!this.isExistIndex(indexName)) {
            System.out.println("删除索引成功..............,不存在此索引");
            return;
        }
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
        restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println("删除索引成功.............." + deleteIndexRequest);
    }

    /**
     * 增加文档
     */
    public void addDocument(String indexName, Object object) throws Exception {
        //创建索引请求对象
        IndexRequest indexRequest = new IndexRequest(indexName);
        // 将对象转换为 byte 数组
        byte[] json = JSON.toJSONBytes(object);
        // 设置文档内容
        indexRequest.source(json, XContentType.JSON);
        //增加执行对象
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("es 增加文档成功........" + indexResponse);
    }

    /**
     * 获取文档
     */
    public void getDocument(String indexName, String type, String id) throws Exception {
        //获取请求对象
        GetRequest getRequest = new GetRequest(indexName, type, id);
        //获取文档信息
        GetResponse getResponse = restHighLevelClient.get(
                getRequest, RequestOptions.DEFAULT
        );
        System.out.println(JSON.parseObject(getResponse.getSourceAsString()));
    }

    /**
     * 删除文档
     */
    public void deleteDocument(String indexName, String type, String id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, type, id);
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest
                , RequestOptions.DEFAULT);
    }

    /**
     * 删除文档
     */
    public void upDateDocument(String indexName, String type, String id, Object object) throws Exception {
        UpdateRequest updateRequest = new UpdateRequest(indexName, type, id);
        //设置文档更新内容
        updateRequest.doc(JSON.toJSONBytes(object), XContentType.JSON);
        //执行更新文档
        UpdateResponse updateResponse =
                restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);

    }
}
