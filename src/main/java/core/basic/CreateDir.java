package core.basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateDir {
	public static void main(String[] args) throws IOException {
		File dir = new File("/Users/nagasawashuuhei/Desktop/llllll");
		dir.mkdir();

		File file = new File("/Users/nagasawashuuhei/Desktop/llllll/aaaaaa.csv");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("テストｵｵｵｵｵｵｵｵｵｵｵｵｵｵ");
	}
}
