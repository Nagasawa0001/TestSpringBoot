package core.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample {

	public static String BASE_RESOUCES_URL = "src/main/resources/sample/";

	public static void main(String[] args) throws IOException{
		File dir = new File(BASE_RESOUCES_URL + "original/");
		File[] fileList = dir.listFiles();

		System.out.println("操作するファイル番号を入力してください");
		System.out.println("===============================");
		for(int i = 0; i < fileList.length; i++) {
			System.out.println(i + " : " + fileList[i].getName());
		}
		System.out.println("===============================");

		BufferedReader inputFileNum = new BufferedReader(new InputStreamReader(System.in));
		Common common = new Common();
		String num;
		if(!common.isNumber(num = inputFileNum.readLine())) {
			System.out.println("不正な番号です");
			return;
		}
		File file = new File(fileList[Integer.parseInt(num)].toString());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String[] titleList = br.readLine().split(",", -1);

		System.out.println("検索対象の番号を選んでください");
		System.out.println("===============================");
		for(int j = 0; j < titleList.length; j++) {
			System.out.println(j + " : " + titleList[j]);
		}
		System.out.println("===============================");
		BufferedReader inputTitleCode = new BufferedReader(new InputStreamReader(System.in));
		String titleCode;
		if(!common.isNumber(titleCode = inputTitleCode.readLine())) {
			System.out.println("不正な番号です");
			br.close();
			return;
		}
		System.out.println("検索する文字列を入力してください（部分一致）");
		BufferedReader inputTitleName = new BufferedReader(new InputStreamReader(System.in));
		String titleName = inputTitleName.readLine();

		System.out.println("出力するファイル名を入力してください");
		BufferedReader outputFileName = new BufferedReader(new InputStreamReader(System.in));
		String opFileName = outputFileName.readLine();

		File outputFile = new File(BASE_RESOUCES_URL + "after/" + opFileName + ".csv");
		FileWriter fw = new FileWriter(outputFile);
		BufferedWriter bw = new BufferedWriter(fw);

		String data;
		while((data = br.readLine()) != null) {
			String[] block = data.split(",", -1);
			if(block[Integer.parseInt(titleCode)].indexOf(titleName) != -1) {
				bw.write(data);
				bw.newLine();
			}
		}

		br.close();
		bw.close();
		System.out.println("===============================");
		System.out.println("ファイル出力が完了しました");
		System.out.println("出力先：" + BASE_RESOUCES_URL + "after/" + opFileName + ".csv");
		System.out.println("===============================");
	}
}


class Common {
	public boolean isNumber(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
