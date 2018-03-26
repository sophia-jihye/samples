package samples.wordFinder;

import java.io.IOException;

import samples.fileUtil.FileReader1;

public class Main {
	public static void main(String[] args) throws IOException {

		FileReader1 fr1 = new FileReader1();
		String sentence = fr1
				.readFile("C:\\DevelopTools\\Eclipse\\Workspace\\PRIVATE\\samples\\testfiles\\sample.txt");

		String startWord = "/thumbnail/";
		String endWord = "/";

		String foundWord = null;
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
		}

	}
}
