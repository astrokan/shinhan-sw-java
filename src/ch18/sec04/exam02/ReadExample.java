package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("test.txt");
			int data = 0;
			while ((data = reader.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
			
			reader = new FileReader("test.txt");
			char[] data2 = new char[100];
			int num = 0;
			while ((num = reader.read(data2)) != -1) {
				for (int i=0; i<num; i++) {
					System.out.print(data2[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {reader.close();} catch (Exception e) {e.printStackTrace();}
		}

	}

}
