package samples.wordFinder;

public class Main {
	public static void main(String[] args) {

		String sentence = "Hello, World. Hello, Korea. Hello, Thailand. Hello, Hello, ";

		String foundWord = "Pseudo Word";
		String startWord = "Hello, ";
		String endWord = ".";

		while (sentence.length() >= startWord.length()) {

			if (!sentence.contains(startWord)) {
				break;
			}
			sentence = sentence.substring(sentence.indexOf(startWord)
					+ startWord.length());

			if (!sentence.contains(endWord)) {
				break;
			}
			foundWord = sentence.substring(0, sentence.indexOf(endWord));
			System.out.println(foundWord);
			System.out.println(sentence);
		}

	}
}
