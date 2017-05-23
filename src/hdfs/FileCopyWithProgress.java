package hdfs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;

public class FileCopyWithProgress {
	
	private static final String localPath = "D:\\helloHadoop.txt";
	private static final String outPutPath="hdfs://192.168.19.9:9012/user/root/scope.txt";

	public static void main(String[] args) throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream(localPath));
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(outPutPath), conf);
		OutputStream out = fs.create(new Path(outPutPath), new Progressable(){

			public void progress() {
				System.out.println(">");
			}
			
		});
	}
	
}
