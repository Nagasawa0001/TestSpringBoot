package core.io.image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class InputIMAGE {

	public static void main(String[] args) throws Exception {

		// 画像ファイル読み込み
		BufferedImage bi = ImageIO.read(new File("src/main/resources/io/input/input.jpg"));

		// ファイル形式を指定して出力
		ImageIO.write(bi, "gif", new File("src/main/resources/io/output/output.gif"));
	}

}
