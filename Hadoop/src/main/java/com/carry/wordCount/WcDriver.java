package com.carry.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WcDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 1获取job实例
        Job job = Job.getInstance(new Configuration());
        //2设置jar包
        job.setJarByClass(WcDriver.class);
        //3设置Map和Reduce
        job.setMapperClass(WcMapper.class);
        job.setReducerClass(WcReducer.class);
        //4设置Map和Reduce输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //5设置输入输出文件
        FileInputFormat.setInputPaths(job, new Path("/Users/oldshuai/Desktop/input"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/oldshuai/Desktop/output"));
        //6提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}
