package core.io.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class InputCSV {

	public static void main(String[] args) throws Exception {

		// ファイルパスを指定
		File file = new File("src/main/resources/io/input/input.csv");

		// 指定したファイルが存在するかチェック
		if(!file.exists()) {
			System.out.println("file not found");
			return;
		}

		// ファイルの有無、ファイルパスの有無をチェック + ファイルを開いている
		FileReader fr = new FileReader(file);

		// 引数のバイト数を確認している（0以下なら例外処理）OKなら引数をメンバ変数にセットしている
		BufferedReader br = new BufferedReader(fr);

		String data;
		// 指定の行に値が入ってる場合、処理を実行
		while((data = br.readLine()) != null) {
			System.out.println("readLine : " + data);
		}
		// クローズ処理
		br.close();
	}

}
