package com.example.demo;

import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

@Slf4j
@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    @Resource
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void clean() {
        LocalDate localDate = LocalDate.now().minusMonths(6);
        System.out.println(localDate.toString());
        Date from = Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        ObjectId objectId = new ObjectId(from);
        System.out.println(localDate.toString() + "#" + objectId.toHexString());
        log.info("now#{}, ObjectId#{}", localDate.toString(), objectId.toHexString());

        Query query = Query.query(Criteria.where("_id").lt(objectId)).limit(1);

        long now = System.currentTimeMillis();

        DeleteResult deleteResult = mongoTemplate.remove(query, Document.class, "test_col");

        log.info("delete test_col result#{}-{}, cost#{}", deleteResult.wasAcknowledged(), deleteResult.getDeletedCount(), System.currentTimeMillis() - now);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clean();
    }
}
