package com.yh.test;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

/**
 * ElasticSearch提供了基于JSON的DSL(Domain_Specific_Language)来定义查询。常见的查询类型包括
 * <p>
 * 查询所有:查询出所有数据，一般测试用。例如:match_all
 * <p>
 * 全文检索(full text)查询:利用分词器对用户输入内容分词，然后去倒排索引库中匹配。例如:match_query multi_match_query
 * <p>
 * 精确查询:根据精确词条值查找数据，一般是查找keyword、数值、日期、boolean等类型字段。例如:,ids,range,term
 * <p>
 * 地理(geo)查询:根据经纬度查询。例如:geo_distancegeo bounding_box
 * <p>
 * 复合查询 Boolean Query
 * 布尔查询是一个或多个查询子句的组合。子查询的组合方式有
 * must:必须匹配每个子查询，类似“与’
 * should:选择性匹配子查询，类似“或”
 * must_not:必须不匹配，不参与算分，类似“非”
 * filter:必须匹配，不参与算分
 */
public class EsSearchTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 查询所有 match_all
     * GET /indexName/_search
     * {
     * "query": {"match_all": {}}
     * }
     *
     * @throws Exception
     */
    @Test
    public void matchAll() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数
        searchRequest.source().query(QueryBuilders.matchAllQuery());
        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析响应结果
        printResult(response);
    }


    /**
     * 全文检索 match_query multi_match_query
     * <p>
     * GET /hotel/_search
     * {"query":
     * {"match_all":{}}
     * }
     * <p>
     * {"query":
     * {"match":{"all":"如家"}
     * }
     * <p>
     * {"query":
     * {"multi_match":{"query":"如家"， fields": ["brand","name"]}
     * }
     */
    @Test
    public void matchQuery() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数

        //searchRequest.source().query(QueryBuilders.matchQuery("info", "一嗨"));

        //multi_query
        searchRequest.source().query(QueryBuilders.multiMatchQuery("一嗨", "info", "place"));

        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析响应结果
        printResult(response);
    }


    /**
     * #组合boolean查询
     * GET estest/_search
     * {
     * "query": {
     * "bool": {
     * "must": [
     * {
     * "match": {
     * "place": "上海"
     * }
     * }
     * ],
     * "filter": [
     * {
     * "range": {
     * "age": {
     * "gte": 5,
     * "lte": 6
     * }
     * }
     * }
     * ]
     * }
     * }
     * }
     */
    @Test
    public void booleanQuery() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数

        //创建Boolean查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //匹配match
        boolQueryBuilder.must(QueryBuilders.matchQuery("place", "上海"));
        //匹配filter
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("age").gte(5).lte(6));

        searchRequest.source().query(boolQueryBuilder);

        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析响应结果
        printResult(response);
    }


    /**
     * 精确查询 ids,range,term
     * GET /hotel/_search
     * {"query":
     * {"term":{"city":"杭州"}}
     * }
     * <p>
     * {"query": {
     * "range":{"price":{"gte":100，"lte":150 }}
     * }
     * }
     */
    @Test
    public void idRangeTerm() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数

        //searchRequest.source().query(QueryBuilders.termQuery("age", 10));

        searchRequest.source().query(QueryBuilders.rangeQuery("age").gte(5).lte(7));

        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析响应结果
        printResult(response);
    }


    /**
     * 排序 分页
     * <p>
     * #排序 分页
     * GET /estest/_search
     * {
     * "query": {
     * "match_all": {}
     * },
     * "from": 0,
     * "size": 5,
     * "sort": [
     * {
     * "age": "desc"
     * }
     * ]
     * }
     *
     * @throws Exception
     */
    @Test
    public void pageAndSort() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数
        searchRequest.source().query(QueryBuilders.matchAllQuery());

        //排序
        searchRequest.source().sort("age", SortOrder.DESC);
        //分页
        searchRequest.source().from(0).size(3);

        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析响应结果
        printResult(response);
    }


    /**
     * 高亮
     *
     * @throws Exception
     */
    @Test
    public void highLight() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数

        //创建Boolean查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //匹配match
        boolQueryBuilder.must(QueryBuilders.matchQuery("place", "上海"));
        //匹配filter
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("age").gte(5).lte(6));

        searchRequest.source().query(boolQueryBuilder);

        //高亮，比如把 "上海高亮" 用tagTest包装
        searchRequest.source().highlighter(new HighlightBuilder().field("place").requireFieldMatch(false)
                //前置标签
                .preTags("<tagTestStart>")
                //后置标签
                //默认<em></eam>
                .postTags("<tagTestEnd>"));

        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //打印高亮
        for (SearchHit hit : response.getHits().getHits()) {

            System.out.println("es 高亮处理结果....." + hit.getHighlightFields().toString());
        }

        //解析响应结果
        printResult(response);
    }

    /**
     * 解析响应结果
     */
    private void printResult(SearchResponse response) {
        //解析响应结果
        SearchHits searchHits = response.getHits();
        //查询的总条数
        long total = searchHits.getTotalHits().value;
        //查询的结果数组
        SearchHit[] resultHits = searchHits.getHits();
        for (SearchHit hit : resultHits) {
            //得到source
            String result = hit.getSourceAsString();
            System.out.println("es 查询结果成功....." + result);
        }
    }

}
