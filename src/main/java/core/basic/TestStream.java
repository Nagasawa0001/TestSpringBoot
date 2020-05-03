package core.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] {"fourth", "second", "third", "first", "first", "first"});


		System.out.println("[filter]================================");
		// 値が"first"の要素を返却
		Stream<String> filterStream = list.stream().filter(n -> n.equals("first"));
		// ループ処理でコンソール出力
		filterStream.forEach(a -> System.out.println(a));


		System.out.println("[limit]================================");
		// 取得する要素数を指定
		Stream<String> limitStream = list.stream().limit(4);
		limitStream.forEach(b -> System.out.println(b));

		System.out.println("[distinct]================================");
		// 重複している要素を削除
		Stream<String> distinctStream = list.stream().distinct();
		distinctStream.forEach(c -> System.out.println(c));

		System.out.println("[anyMatch]================================");
		// 条件に合致した場合、真偽値で返却
		System.out.println(list.stream().anyMatch(p -> p.equals("second"))); // true
		System.out.println(list.stream().anyMatch(p -> p.equals("fifth"))); // false

		System.out.println("[dropWhile]================================");
		// 最初の要素が条件に合致している場合、最初の要素を削除
		Stream<String> dropWhileStream = list.stream().dropWhile(p -> p.equals("fourth"));
		dropWhileStream.forEach(c -> System.out.println(c));
	}
}
