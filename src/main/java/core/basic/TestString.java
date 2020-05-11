package core.basic;

import java.util.ArrayList;
import java.util.List;

public class TestString {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		StringBuilder sb = new StringBuilder();
		sb.append("AAAAA");
		System.out.println(sb.toString().getClass());

		List<String> AList = new ArrayList<String>();
		AList.add("AAAA");

		List<String> BList = new ArrayList<String>();
		BList.add("BBBB");

		C c = new C();
		c.AList = AList;
		c.BList = BList;

	}
}

class A {
	public String ACode;
}

class B {
	public String BCode;
}

class C {
	public List<String> AList;
	public List<String> BList;
}