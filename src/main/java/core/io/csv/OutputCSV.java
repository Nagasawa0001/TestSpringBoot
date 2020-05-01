package core.io.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class OutputCSV {

	public static void main(String[] args) throws Exception {
		String list[] = new String[5];
		list[0] = "AAAAA";
		list[1] = "BBBBB";
		list[2] = "CCCCC";
		list[3] = "DDDDD";
		list[4] = "EEEEE";

		// 出力するファイルパスを指定
		File file = new File("src/main/resources/io/output/output.csv");

		// ファイルの有無、ファイルパスの有無をチェック + ファイルを開いている
		FileWriter fw = new FileWriter(file);

		// 引数のバイト数を確認している（0以下なら例外処理）OKなら引数をメンバ変数にセットしている
		BufferedWriter bw = new BufferedWriter(fw);

		for(String item : list) {
			// CSVファイルにテキストを書き込む
			bw.write(item);
			// 改行を追加
			bw.newLine();
		}
		// クローズ処理
		bw.close();
	}

}
