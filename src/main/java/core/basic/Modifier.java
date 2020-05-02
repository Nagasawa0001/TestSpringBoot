package core.basic;

public class Modifier {

	public static void main(String[] args) {

		// static修飾子はインスタンスを生成する必要がない
		System.out.println("===========================");
		System.out.println(SampleStatic.str);
		SampleStatic.method();
		System.out.println("===========================");

		// static無しの場合はインスタンス生成が必要
		System.out.println("===========================");
		SampleStatic ss = new SampleStatic();
		System.out.println(ss.defaultStr);
		ss.defaultMethod();
		System.out.println("===========================");

		System.out.println("===========================");
		System.out.println(ss.proStr);
		System.out.println("===========================");
	}

}

class SampleStatic {
	static String str = "static variable";
	String defaultStr = "default variable";
	protected String proStr = "protected variable";

	void defaultMethod() {
		System.out.println("default method");
	}

	static void method() {
		System.out.println("static method");
	}
}
