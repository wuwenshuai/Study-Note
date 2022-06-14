package com.carry.controller;

import com.carry.DateUtils;
import com.carry.ReleaseDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/6/8 17:44
 */

@RestController
public class TestController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/test")
    public String test() {

        String startTime = String.valueOf("2021-04-19 00:00:00");
        String endTime = String.valueOf("2022-06-21 00:00:00");
        Query query = new Query();
        Criteria criteria = new Criteria();
//设置查询时间范围
        criteria.and("createdDate").gte(DateUtils.dateToISODate(startTime)).lte(DateUtils.dateToISODate(endTime));

        query.addCriteria(criteria);

        List<ReleaseDocument> all = mongoTemplate.find(query, ReleaseDocument.class,"ep_core_release");
        all = all.stream().filter(item -> item.getProjectName() != null).collect(Collectors.toList());
        Map<String, List<ReleaseDocument>> releaseDocumentGroupMap = all.stream()
                .collect(Collectors.groupingBy(ReleaseDocument::getProjectName));

        System.out.println(releaseDocumentGroupMap);
        return "test";
    }
}
