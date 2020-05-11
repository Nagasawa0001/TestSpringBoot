package core.basic;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SampleJackson {

	public static void main(String[] args) throws JsonProcessingException {
		User user = new User();
		user.id = "1";
		user.name = "Sato Taro";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);

		System.out.println(json);

		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user);
		userList.add(user);
		userList.add(user);
		userList.add(user);


		System.out.println(user.parseJson(userList));

		// エラー発生
		System.out.println(user.parseJson(new Test()));
	}

}

class User {
	public String id;
	public String name;

	public String parseJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}
}

class Test {

}
