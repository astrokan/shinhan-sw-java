package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("test2.db");
			byte[] data = new byte[100];
			
			int num = 0;
			while ((num = is.read(data)) != -1) {
				for (int i=0; i<num; i++) {
					System.out.println(data[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

}
