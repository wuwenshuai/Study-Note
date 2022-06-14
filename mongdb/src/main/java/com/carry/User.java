package com.carry;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/6/9 10:06
 */

@Data
public class User {
    private String userId;
    private String fullName;
    private String email;
    private List<String> groups;
}
