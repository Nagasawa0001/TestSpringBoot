package core.basic;

import java.util.Arrays;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class CreatePassword {
	public static void main(String[] args) {
		List<CharacterRule> rules = Arrays.asList(
				new CharacterRule(EnglishCharacterData.UpperCase, 2),
				new CharacterRule(EnglishCharacterData.LowerCase, 2),
				new CharacterRule(EnglishCharacterData.Digit, 5)
				);

		PasswordGenerator generator = new PasswordGenerator();
		String password = generator.generatePassword(10, rules);
		System.out.println(password);
	}
}
