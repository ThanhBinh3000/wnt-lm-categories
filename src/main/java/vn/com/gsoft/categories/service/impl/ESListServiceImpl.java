package vn.com.gsoft.categories.service.impl;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.ESConstant;
import vn.com.gsoft.categories.entity.Thuocs;
import vn.com.gsoft.categories.service.ESListService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ESListServiceImpl implements ESListService {
    @Autowired
    private RestHighLevelClient client;

    @Value("${elasticsearch.index.refresh_interval}")
    private String refreshInterval;
    @Value("${elasticsearch.index.number_of_replicas}")
    private Integer numberOfReplicas;
    @Value("${elasticsearch.index.number_of_shards}")
    private Integer numberOfShards;

    @Override
    public void pushProductData(List<Thuocs> data) throws Exception {
//        if(!indexExist()){
//            createIndexWithCustomSettings();
//        }
        //createIndexWithCustomSettings();
        bulkInsert(data);
    }

    public List<Long> searchByTenThuoc(String tenThuoc) throws IOException {
        SearchRequest searchRequest = new SearchRequest(ESConstant.INDEX_PRODUCT);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name", tenThuoc));
        searchSourceBuilder.size(ESConstant.MAX_SIZE);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();

        List<Long> ids = new ArrayList<>();
        for (SearchHit hit : hits) {
            ids.add(Long.valueOf(hit.getId()));
        }
        return ids;
    }

    private void createIndexWithCustomSettings() throws Exception {
        CreateIndexRequest request = new CreateIndexRequest(ESConstant.INDEX_PRODUCT);

        request.settings(Settings.builder()
                .put("index.number_of_shards", numberOfShards)
                .put("index.number_of_replicas", numberOfReplicas)
                .put("index.refresh_interval", refreshInterval)
        );

        client.indices().create(request, RequestOptions.DEFAULT);
    }

    public void bulkInsert(List<Thuocs> data) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();

        data.forEach(x->{
            Map<String, Object> item = new HashMap<>();
            item.put("id", x.getThuocId());
            item.put("name", x.getTenThuoc());
            bulkRequest.add(new IndexRequest(ESConstant.INDEX_PRODUCT)
                    .id(x.getThuocId().toString()).source(item, XContentType.JSON));
        });

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        if (bulkResponse.hasFailures()) {
            System.out.println("Bulk request had failures:");
        } else {
            System.out.println("Bulk request succeeded.");
        }
    }
    private boolean indexExist() {
        try {
            GetIndexRequest request = new GetIndexRequest(ESConstant.INDEX_PRODUCT);
            GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
