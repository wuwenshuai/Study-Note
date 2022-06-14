package com.carry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * @author cw3k
 * @version 1.0
 * @description: TODO
 * @date 2022/6/8 17:33
 */

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data

public class ReleaseDocument {


    private ObjectId id;
    private String type;
    private String pjId;


    private String projectNo;

    private String projectName;
    private String status;
    private User createdBy;
    private Date createdDate;
    private User lastModifiedBy;



}
