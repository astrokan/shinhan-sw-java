package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) throws Exception {
		
		String originalFileName = "hondon.png";
		String targetFileName = "hondon2.png";
		
		InputStream is = new FileInputStream(originalFileName);
		OutputStream os = new FileOutputStream(targetFileName);
		
		byte[] data = new byte[1024];
		int num = 0;
		while((num = is.read(data)) != -1) {
			os.write(data,0,num);
		}
		os.flush();
		os.close();
		is.close();
		System.out.println("copy complete!");
	}

}
