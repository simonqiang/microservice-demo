package com.microservices.demo.elastic.query.service.api;

import com.microservices.demo.elastic.query.service.model.ElasticQueryServiceRequestModel;
import com.microservices.demo.elastic.query.service.model.ElasticQueryServiceResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/documents")
public class ElasticDocumentController {
    private static final Logger LOG = LoggerFactory.getLogger(ElasticDocumentController.class);

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<ElasticQueryServiceResponseModel>> getAllDocuments() {
        List<ElasticQueryServiceResponseModel> response = new ArrayList<>();
        LOG.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ElasticQueryServiceResponseModel>
    getDocumentById(@PathVariable @NotEmpty String id) {
        ElasticQueryServiceResponseModel elasticQueryServiceResponseModel
                = ElasticQueryServiceResponseModel.builder().id(id).build();
        LOG.debug("Elasticsearch returned document with id {}", id);
        return ResponseEntity.ok(elasticQueryServiceResponseModel);
    }


    @PostMapping("/get-document-by-text")
    public @ResponseBody ResponseEntity<List<ElasticQueryServiceRequestModel>>
    getDocumentByText(
            @RequestBody @Valid ElasticQueryServiceRequestModel elasticQueryServiceRequestModel
    ) {
        List<ElasticQueryServiceRequestModel> response = new ArrayList<>();
        ElasticQueryServiceRequestModel elasticQueryServiceRequestModel1 =
                ElasticQueryServiceRequestModel.builder()
                        .text(elasticQueryServiceRequestModel.getText())
                        .build();
        response.add(elasticQueryServiceRequestModel);
        LOG.debug("Elasticsearch returned {} documents", response.size());
        return ResponseEntity.ok(response);
    }
}
