package com.yh.test;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
     * #聚合 按email聚合 bucket聚合
     * GET /estest/_search
     * {
     * "size": 0,
     * "aggs": {
     * "emailAgg": {
     * "terms": {
     * "field": "email",
     * "order": {
     * "_count": "asc"
     * },
     * "size": 10
     * }
     * }
     * }
     * }
     * <p>
     * <p>
     * #聚合 按email聚合，然后求age最大值,然后按照平均值降序
     * GET /estest/_search
     * {
     * "size": 0,
     * "aggs": {
     * "emailAgg": {
     * "terms": {
     * "field": "email",
     * "size": 5,
     * "order": {
     * "ageAgg.avg": "desc"
     * }
     * },
     * "aggs": {
     * "ageAgg": {
     * "stats": {
     * "field": "age"
     * }
     * }
     * }
     * }
     * }
     * }
     */
    @Test
    public void aggrs() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("estest");
        //组织DSL参数
        //设置文档数据size
        searchRequest.source().size(0);
        //设置聚合
        searchRequest.source().aggregation(AggregationBuilders
                //此次聚合名称
                .terms("emailAgg")
                //指定聚合字段
                .field("email")
                //聚合结果大小
                .size(5)
                //结果排序
                //默认情况下，Bucket聚合会统计Bucket内的文档数量，记为_count，并且按照_count降序排序
                //.order(BucketOrder.count(false))

                //按照平均值降序
                .order(BucketOrder.aggregation("ageAgg.avg", false))

                //子聚合 按email聚合，然后求age最大值,然后按照平均值降序
                .subAggregation(AggregationBuilders
                        // 子聚合名称ageAgg
                        .stats("ageAgg")
                        //指定年龄字段
                        .field("age"))

        );

        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析聚合结果
        Aggregations aggregations = response.getAggregations();
        //根据名称获取聚合结果
        Terms emailTerm = aggregations.get("emailAgg");
        //获取桶
        List<? extends Terms.Bucket> buckets = emailTerm.getBuckets();
        //查询的结果数组
        for (Terms.Bucket bucket : buckets) {
            //
            System.out.println("es 聚合解析结果获取成功.....key: " +
                    bucket.getKeyAsString() + "....数量: " +
                    bucket.getDocCount() + "....对应子聚合结果:" + JSON.toJSONString(bucket.getAggregations().get("ageAgg")));
        }

        //打印结果
        // printResult(response);
    }


    /**
     * 自动补全
     * #自动补全查询
     * GET /testzidong/_search
     * {
     * "suggest": {
     * "mysuggest": {
     * "text": "h",
     * "completion": {
     * "field": "title",
     * "size": 10
     * }
     * }
     * }
     * }
     *
     * @throws Exception
     */
    @Test
    public void suggest() throws Exception {
        //准备Request
        SearchRequest searchRequest = new SearchRequest("testzidong");
        //请求参数
        searchRequest.source().suggest(
                new SuggestBuilder()
                        //自定义名称
                        .addSuggestion("mysuggest",
                                //补全字段
                                SuggestBuilders.completionSuggestion("title")
                                        //搜索字
                                        .prefix("h")
                                        .size(5))
        );
        //发送请求，得到响应结果
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //打印自动补全
        for (Suggest.Suggestion.Entry.Option option : response.getSuggest().getSuggestion("mysuggest").getEntries().get(0).getOptions()) {
            System.out.println("es 自动补全结果....." + option.getText());
        }

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
