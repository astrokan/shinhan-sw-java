package ch19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

	public static void main(String[] args) throws IOException{
		JSONObject root = new JSONObject();
		/*
		 {
		 
		 }
		 root: 빈 중괄호를 먼저 생성.
		 */
		
		root.put("id","winter");
		root.put("name","한겨울");
		root.put("age",25);
		root.put("student",true);
		
		JSONObject tel = new JSONObject();
		tel.put("home", "02-123-1234");
		tel.put("mobile", "010-123-1234");
		root.put("tel", tel);
		
		JSONArray skill = new JSONArray(); // ["java", "c", "c++"]
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);
		
		String json = root.toString(); // toString(int indentFactor)
		System.out.println(root.toString(4));
		
		Writer writer = new FileWriter("member.json", Charset.forName("UTF-8"));
		
		// 1.
		writer.write(json);
		
		// 인자 설명: root.write(Writer객체, 들여쓰기칸수, 시작들여쓰기단계);
		// 4와 0을 주면 4칸 들여쓰기로 기록
		// 2.
		root.write(writer, 4, 0);
		writer.flush();
		writer.close();
	}

}
