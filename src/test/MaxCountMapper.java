package test;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import com.alibaba.fastjson.JSONObject;

public class MaxCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	

	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
//		String line = value.toString();
		String line =new String(value.getBytes(),0,value.getLength(),"GBK");
		JSONObject jo = JSONObject.parseObject(line);
		System.out.println(jo.toJSONString());
		output.collect(new Text(jo.getString("name")), new IntWritable(jo.getInteger("count")));
	}
	
}
