package hdfs;

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class UrlCat {
	
	private static final String path = "hdfs://192.168.19.9:9012/user/root/copyTest.json";
	
	static{
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}

	public static void main(String[] args) {
		InputStream in = null;
		try{
			in = new URL(path).openStream();
			IOUtils.copyBytes(in, System.out, 4096, false);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(in);
		}
	}
}
