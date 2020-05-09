package core.basic;

import java.util.regex.Pattern;

public class MatchSample {
	public static void main(String[] args) {
		// ひらがな
		String hiragana = "あいうえお";

		// カタカナ（全角）
		String katakanaBig = "アイウエオ";

		// カタカナ（半角）
		String katakanaSmall = "ｱｲｳｴｵ";

		// 英数字（半角）
		String alphaSmall = "ABCDE12345[];:";

		// 半角記号

		// 英数字 + 記号（全角）
		String alphaBig = "ＡＢＣＤＥ１２３４５「」；：";

		// 完全一致
		System.out.println("--- 完全一致 ---");
		System.out.println(hiragana.equals("あいうえお")); // true
		System.out.println(katakanaBig.equals("アイウエオ")); // true
		System.out.println(katakanaSmall.equals("ｱｲｳｴｵ")); // true
		System.out.println(alphaSmall.equals("ABCDE12345[];:")); // true
		System.out.println(alphaBig.equals("ＡＢＣＤＥ１２３４５「」；：")); // true

		// 部分一致（一致した文字番号を返却）
		System.out.println("--- 部分一致（一致した文字番号を返却） ---");
		System.out.println(hiragana.indexOf("お")); // 4
		System.out.println(hiragana.indexOf("か")); // -1
		// 部分一致の条件分岐記述方法
		if(hiragana.indexOf("か") == -1) {
			System.out.println("部分一致しませんでした");
		} else {
			System.out.println("部分一致しました");
		}

		// 前方一致
		System.out.println("--- 前方一致 ---");
		System.out.println(hiragana.startsWith("あ"));
		System.out.println(hiragana.startsWith("い"));

		// 後方一致
		System.out.println("--- 前方一致 ---");
		System.out.println(hiragana.endsWith("お"));
		System.out.println(hiragana.endsWith("え"));

		// 正規表現用
		String str = "aaaaa123ddd";
		String regex1 = "^.*123.*$";
		String regex2 = "^ss.*$";

		// ^.* 先頭はなんでも良い
		// .*$ 末尾はなんでも良い

		// a.z         a から始まって z で終わる 3 桁の文字列
		// a.*z        a から始まって z で終わる 2 桁以上の文字列
		// a.+z        a から始まって z で終わる 3 桁以上の文字列
		// \d{4}       4 桁の半角数字
		// \d{4,}      4 桁以上の半角数字
		// \d{1,4}     1 ～ 4 桁の半角数字
		// \d{4,10}    4 ～ 10 桁の半角数字 (最長一致)
		// \d{4,10}?   4 ～ 10 桁の半角数字 (最短一致)
		// \b\d{1,3}(,\d{3})*\b  桁区切りのカンマ付数字列
		// [¥u¥l]      半角英文字
		// [^¥u¥l]     半角英文字以外
		// \b[¥u¥l]+\b  英単語（半角英文字列）
		// [02468]      1 桁の偶数
		// \d*[02468]\b 1 桁以上の偶数
		// Email                   ^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
		// \\w 英数字 or アンダーバー
		// +
		//
		// URL                     ^https?://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$
		// ドメイン名                ^[a-zA-Z0-9][a-zA-Z0-9-]{1,61}[a-zA-Z0-9]\.[a-zA-Z-]{2,}$
		// 固定電話番号              ^0\d(-\d{4}|\d-\d{3}|\d\d-\d\d|\d{3}-\d)-\d{4}$
		// 携帯電話番号              ^0[789]0-\d{4}-\d{4}$
		// IP電話番号               ^050-\d{4}-\d{4}$
		// フリーダイヤル            (0120|0800)-\d{3}-\d{3}$
		// 日付 (YYYY-MM-DD形式)    ^\d{4}-\d\d-\d\d$
		// 郵便番号                 ^\d{3}-\d{4}$

		// 正規表現
		String str2 = "ss";
		String regex3 = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String regex4 = "^[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*@[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*$";
		String regexHttp = "^https?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
		String regexDomain = "^[a-zA-Z0-9][a-zA-Z0-9-]{1,61}[a-zA-Z0-9]\\.[a-zA-Z-]{2,}$";
		String str3 = "https://a.a/aaaaa";
		String str4 = "a-q.-ttj";

		System.out.println("--- 正規表現 ---");
		System.out.println(Pattern.matches(regex1, str));
		System.out.println(Pattern.matches(regex2, str));
		System.out.println(Pattern.matches(regexHttp, str3));
		System.out.println(Pattern.matches(regexDomain, str4));

	}

}
