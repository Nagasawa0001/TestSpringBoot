package core.basic;

public class TestException {

	public static void main(String[] args) {
		TestException te = new TestException();
		try {
			te.methodCallException();
		} catch (SampleException e) {
			e.printStackTrace();
		}
	}

	// throw new で例外を投げる場合、メソッド名の横にthrowsをつける（呼び出し先で例外投げるよ〜という意味）
	private void methodCallException() throws SampleException {
		int i = 5;
		if(i == 5) {
			// 例外を投げる（呼び出し先で例外処理をする）
			throw new SampleException("自作Exceptionが呼び出されました");
		}
	}

}

// 自作の例外処理クラスを作成
class SampleException extends Exception {

	// コンストラクタを実装
	SampleException(String msg){
		// 親クラス(Exceptionクラス)のコンストラクタを呼び出し
		super(msg);
	}
}
