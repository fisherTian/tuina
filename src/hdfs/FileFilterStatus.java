package hdfs;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class FileFilterStatus {
	
	private static final String PATH="hdfs://192.168.19.9:9012/user/root";

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(PATH), conf);
		FileStatus[] arr = fs.globStatus(new Path("/*/*/*"),new PathFilter() {
			public boolean accept(Path arg0) {
				if(arg0.toString().equals("hdfs://192.168.19.9:9012/user/root/scope.txt")){
					return false;
				}
				return true;
			}
		});
		Path[] paths = FileUtil.stat2Paths(arr);
		for(Path p:paths){
			System.out.println(p);
		}
	}
	
}
