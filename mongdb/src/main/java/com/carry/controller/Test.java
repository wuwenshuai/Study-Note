package com.carry.controller;

import com.carry.ReleaseDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/6/9 15:34
 */
public class Test {

    public static void main(String[] args) {

        List<ReleaseDocument> list = new ArrayList<>();
        ReleaseDocument document1 = new ReleaseDocument();
        document1.setProjectName("1");
        document1.setPjId("123");
        list.add(document1);

        ReleaseDocument document12 = new ReleaseDocument();
        document12.setProjectName("1");
        document12.setPjId("document12");
        list.add(document12);


        ReleaseDocument document13 = new ReleaseDocument();
        document13.setProjectName("document13");
        document13.setPjId("document13");
        list.add(document13);

        ReleaseDocument document14 = new ReleaseDocument();
        document14.setProjectName("document14");
        document14.setPjId("document14");
        list.add(document14);

        List<ReleaseDocument> duplicateElements = getDuplicateElements(list);
        System.out.println(duplicateElements);


    }
    public static  List<ReleaseDocument> getDuplicateElements(List<ReleaseDocument> list) {
        return list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream()
                // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1)
                // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey())
                // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());
    }

}
