package core.basic;

public class Extend {

	public static void main(String[] args) {
		Test1 test1 = new Test1();
		System.out.println("===========================");
		test1.methodA();
		System.out.println("===========================");

		System.out.println("===========================");
		test1.methodB();
		System.out.println("===========================");

		System.out.println("===========================");
		test1.methodC();
		System.out.println("===========================");

		System.out.println("===========================");
		test1.method00();
		System.out.println("===========================");
	}
}


class Test1 extends Test2 {
	public void methodA() {
		System.out.println("Test1_methodA");
	}

	// Test2のmethod00を上書きしている
	void method00() {
		System.out.println("method00 拡張後");
	}
}

class Test2 extends Test3 {
	void methodB() {
		System.out.println("Test2_methodB");
		// 親クラスのメソッドを呼び出し（Test3のmethodSuper）
		super.methodSuper();
	}

	void method00() {
		System.out.println("method00 拡張前");
	}
}

class Test3 {
	void methodC() {
		System.out.println("Test3_methodC");
	}

	void methodSuper() {
		System.out.println("SuperMethod in Test3");
	}
}
