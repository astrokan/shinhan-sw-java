package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {
		try {
			// 192.168.0.8
			Socket socket = new Socket("localhost", 50001);
			System.out.println("[클라이언트] 연결 성공");
			
			// 데이터 보내기
			String sendMessage = "나는 자바가 좋아~~~~~";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄: " + sendMessage);
			
			// 데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음: " + receiveMessage);
			
			
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch(UnknownHostException e) {
			// IP 표기 방법이 잘못됨.
			System.out.println("UnknownHostException");
		} catch(IOException e) {
			// 해당 포트의 서버에 연결할 수 없음.
			System.out.println("IOException");
		}

	}

}
