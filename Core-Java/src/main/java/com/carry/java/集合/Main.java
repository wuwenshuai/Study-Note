package com.carry.java.集合;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream()   // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream()
                // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1)
                // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey())
                // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());
        // 转化为 List
    }

    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("a", "b", "c", "d", "a", "a", "d", "d");
        List<String> duplicate = getDuplicateElements(list);
        System.out.println("list 中重复的元素：" + duplicate);
    }
}
