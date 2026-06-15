package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("test1.db");
//			while(true) {
//				int data = is.read();
//				if (data == -1) break;
//				System.out.println(data);
//			}
			int data = 0;
			while((data = is.read()) != -1) {
				System.out.println(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {is.close();} catch(Exception e) {}
		}
	}

}
