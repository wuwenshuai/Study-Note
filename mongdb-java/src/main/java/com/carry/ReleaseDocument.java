package com.carry;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.Date;


@Data
@ToString
public class ReleaseDocument {




    private Integer pjId;
    private String projectNo;
    private String projectName;
    private String status;
    private Date createdDate;



}
