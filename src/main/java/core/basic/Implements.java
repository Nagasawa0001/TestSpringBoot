package core.basic;

public class Implements {

	public static void main(String[] args) {
		TestB testB = new TestB();
		testB.methodA();
		testB.methodB();


		TestC testC = new TestC();
		testC.methodA();
	}

}

interface TestA {
	// interfaceにはメソッドの概要だけ記述する（処理内容は別クラスで実装する）
	public void methodA();
}

interface TestX {
	public void methodB();
}

// implementsでinterfaceを指定するとinterface内の全てのメソッドを実装する必要がある
class TestB implements TestA, TestX {

	// TestAのmethodAを実装している
	@Override
	public void methodA() {
		System.out.println("Test2_methodA");

	}

	@Override
	public void methodB() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("TestX_methodB");
	}
}

class TestC implements TestA {

	@Override
	public void methodA() {
		System.out.println("Test3_methodA");
	}

}
