package com.example.demo.test;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private MongoTemplate mongoTemplate;

    public void add(TestDto testDto) {
        mongoTemplate.insert(testDto);
//        mongoTemplate.save(testDto);
    }

    public void delete1() {
        TestDto testDto = TestDto.builder().id("5e786517e9babf45a79fda46").build();
        DeleteResult deleteResult = mongoTemplate.remove(testDto);
    }

    public void delete2() {
        Query query = Query.query(Criteria.where("_id").is("5e786517e9babf45a79fda46"));
        DeleteResult deleteResult = mongoTemplate.remove(query, TestDto.class);
    }

    public void update() {
        Query query = Query.query(Criteria.where("_id").is("5e786517e9babf45a79fda46"));
        Update update = Update.update("status", "ONLINE").set("update_ts", System.currentTimeMillis());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, TestDto.class);
    }

    public void queryList() {
//        Criteria criteria1 = Criteria.where("status").is("ONLINE");
//        Criteria criteria2 = Criteria.where("update_ts").lte(System.currentTimeMillis());
//        Query query = new Query();
//        query.addCriteria(criteria1);
//        query.addCriteria(criteria2);
//        query.skip(100);
//        query.limit(10);

        Query query = Query.query(Criteria.where("status").is("ONLINE").and("update_ts").lte(System.currentTimeMillis()))
                .skip(1000)
                .limit(10);
        List<TestDto> testDtos = mongoTemplate.find(query, TestDto.class);
    }

    public void queryOne() {
        Query query = Query.query(Criteria.where("_id").is("5e786517e9babf45a79fda46"));
        TestDto testDto = mongoTemplate.findOne(query, TestDto.class);
    }

}
