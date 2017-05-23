package hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListStatus {
	
	private static final String PATH="hdfs://192.168.19.9:9012/user/root";

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(PATH), conf);
		FileStatus[] arr = fs.listStatus(new Path(PATH));
		Path[] paths = FileUtil.stat2Paths(arr);
		for(Path p:paths){
			System.out.println(p);
		}
	}
	
}
