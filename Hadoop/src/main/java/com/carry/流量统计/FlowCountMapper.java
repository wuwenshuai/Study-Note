package com.carry.流量统计;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowCountMapper extends Mapper<LongWritable, Text, Text,FlowBean> {

    FlowBean v = new FlowBean();
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1获取一行
        String line = value.toString();
        //2切割字段
        String[] fields = line.split("\t");
        //3封装对象
        //取出手机号
        String phoneNum = fields[1];
        // 取出上行流量和下行流量
        long upFlow = Long.parseLong(fields[fields.length - 3]);
        long downFlow = Long.parseLong(fields[fields.length - 2]);
        k.set(phoneNum);
        v.set(upFlow,downFlow);
        context.write(k,v);
    }
}
