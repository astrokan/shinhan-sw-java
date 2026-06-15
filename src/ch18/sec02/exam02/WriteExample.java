package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("test2.db");

			byte[] array = { 10, 20, 30 };
			os.write(array);

			os.flush();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
