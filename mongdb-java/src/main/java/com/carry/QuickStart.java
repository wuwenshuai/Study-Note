package com.carry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class QuickStart {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://efficiency_reader:RUijq37e@172.16.170.81:27017/efficiency_platform_db?retryWrites=false");
        Date now = new Date();
        Date endDate = new Date(now.getTime());
        String endTime =  DateUtils.getDateString(endDate,DateUtils.DATE_TIME_PATTERN);
        Date startDate = new Date(now.getTime()-72*3600*1000);
        String startTime =  DateUtils.getDateString(startDate,DateUtils.DATE_TIME_PATTERN);

        //获取数据库
        MongoDatabase database = mongoClient.getDatabase("efficiency_platform_db");
        MongoCollection<Document> collection = database.getCollection("ep_core_release");

        Bson bson = Filters.and(Filters.gte("createdDate", DateUtils.dateToISODate(startTime)), Filters.lte("createdDate", DateUtils.dateToISODate(endTime)));
        MongoCursor<Document> cursor = collection.find(bson).skip(0).limit(2000).iterator();

        List<ReleaseDocument> releaseDocuments = new ArrayList<>();

        cursor.forEachRemaining(document -> {
            String s = document.toJson();
            JSONObject jsonObject = JSONObject.parseObject(s);
            ReleaseDocument releaseDocument = new ReleaseDocument();
             releaseDocument.setCreatedDate(document.getObjectId("_id").getDate());
            releaseDocument.setProjectNo(jsonObject.getString("projectNo"));
            releaseDocument.setPjId(jsonObject.getInteger("pjId"));
            User user = jsonObject.getObject("createdBy",User.class);

            System.out.println(jsonObject.getString("pjId"));
            releaseDocuments.add(releaseDocument);
        });

       System.out.println(releaseDocuments.size());



    }
}
