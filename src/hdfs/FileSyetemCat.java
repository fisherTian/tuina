package hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileSyetemCat {
	
	private static final String path = "hdfs://192.168.19.9:9012/user/root/copyTest.json";

	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(path), conf);
		InputStream in = null;
		try{
			in = fs.open(new Path(path));
			IOUtils.copyBytes(in, System.out, 4096, false);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(in);
		}
	}
}
