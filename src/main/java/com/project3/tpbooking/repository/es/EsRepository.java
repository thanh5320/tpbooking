package com.project3.tpbooking.repository.es;

import com.alibaba.fastjson.JSON;
import com.project3.tpbooking.data.model.request.HomeSearchRequest;
import com.project3.tpbooking.document.Hotel;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@Repository
public class EsRepository {
    private final RestHighLevelClient client;
    private static final String index="hotel";
    private static final int sizePage = 10;
    private List<String> hotCities = List.of("Hà Nộ", "Hồ Chí Minh", "Đà Nẵng");

    public EsRepository(RestHighLevelClient client) {
        this.client = client;
    }

    public List<Hotel> homeSearch(){
        List<Hotel> results = new ArrayList<>();

        for(String city : hotCities){
            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("city", city);
            QueryBuilder rangeScoreQueryBuilder = QueryBuilders.rangeQuery("review_score.score").gte(8);
            QueryBuilder rangeCountQueryBuilder = QueryBuilders.rangeQuery("review_score.count").gte(500);
            QueryBuilder query = QueryBuilders.boolQuery().filter(matchQuery).minimumShouldMatch(1).should(rangeCountQueryBuilder).should(rangeScoreQueryBuilder);

            SearchSourceBuilder builder = new SearchSourceBuilder().query(query).size(3);

            SearchRequest searchRequest = new SearchRequest().indices(index);
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
            searchRequest.source(builder);

            SearchResponse response = null;
            try {
                response = client.search(searchRequest, RequestOptions.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            SearchHit[] searchHits = response.getHits().getHits();
            results.addAll(
                    Arrays.stream(searchHits)
                            .map(hit -> JSON.parseObject(hit.getSourceAsString(), Hotel.class))
                            .collect(Collectors.toList()));
        }

        //System.out.println(results.size());
        return  results;
    }

    public List<Hotel> search(HomeSearchRequest request){
        QueryBuilder query = QueryBuilders.queryStringQuery(request.getText());
        SearchSourceBuilder builder = new SearchSourceBuilder().query(query).from(request.getPage()*sizePage).size(sizePage);
        SearchRequest searchRequest = new SearchRequest().indices(index);
        searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
        searchRequest.source(builder);

        SearchResponse response = null;
        try {
            response = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchHit[] searchHits = response.getHits().getHits();
        return
                Arrays.stream(searchHits)
                        .map(hit -> JSON.parseObject(hit.getSourceAsString(), Hotel.class))
                        .collect(Collectors.toList());
    }

    public List<Hotel> findById(String id){
        QueryBuilder query = QueryBuilders.termQuery("id", id);
        SearchSourceBuilder builder = new SearchSourceBuilder().query(query).size(1);
        SearchRequest searchRequest = new SearchRequest().indices(index);
        searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
        searchRequest.source(builder);

        SearchResponse response = null;
        try{
            response = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e){
            e.printStackTrace();
        }

        SearchHit[] searchHits = response.getHits().getHits();
        return
                Arrays.stream(searchHits)
                        .map(hit -> JSON.parseObject(hit.getSourceAsString(), Hotel.class))
                        .collect(Collectors.toList());
    }


    public List<Hotel> getAll(){
        QueryBuilder query = QueryBuilders.matchAllQuery();
        SearchSourceBuilder builder = new SearchSourceBuilder().query(query).size(1000);
        SearchRequest searchRequest = new SearchRequest().indices(index);
        searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
        searchRequest.source(builder);

        SearchResponse response = null;
        try {
            response = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchHit[] searchHits = response.getHits().getHits();
        return
                Arrays.stream(searchHits)
                        .map(hit -> JSON.parseObject(hit.getSourceAsString(), Hotel.class))
                        .collect(Collectors.toList());
    }

}
