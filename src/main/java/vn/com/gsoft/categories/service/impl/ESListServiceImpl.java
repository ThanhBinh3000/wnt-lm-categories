package vn.com.gsoft.categories.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.CachingConstant;
import vn.com.gsoft.categories.constant.ESConstant;
import vn.com.gsoft.categories.entity.HangHoa;
import vn.com.gsoft.categories.model.cache.HangHoaCache;
import vn.com.gsoft.categories.model.elastichsearch.HangHoaES;
import vn.com.gsoft.categories.service.ESListService;
import vn.com.gsoft.categories.service.RedisListService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void pushProductData(List<HangHoa> data) throws Exception {
//        if(!indexExist()){
//            createIndexWithCustomSettings();
//        }
        bulkInsert(data);
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

    private void bulkInsert(List<HangHoa> hangHoas) throws IOException {
        int batchSize = 1000;
        for (int i = 0; i < hangHoas.size(); i += batchSize) {
            BulkRequest bulkRequest = new BulkRequest();
            int end = Math.min(i + batchSize, hangHoas.size());

            for (int j = i; j < end; j++) {
                Map<String, Object> data = new HashMap<>();
                data.put("id", hangHoas.get(j).getThuocId());
                data.put("name", hangHoas.get(j).getTenThuoc());
                IndexRequest request = new IndexRequest(ESConstant.INDEX_PRODUCT)
                        .id(String.valueOf(hangHoas.get(j).getThuocId()))
                        .source(data, XContentType.JSON);
                bulkRequest.add(request);
            }

            BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
//
//            if (bulkResponse.hasFailures()) {
//                System.out.println("Bulk request had failures:");
//                bulkResponse.forEach(item -> {
//                });
//            } else {
//                System.out.println("Bulk request succeeded.");
//            }
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
