package samples.fileUtil;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		FileReader1 fr1 = new FileReader1();
		System.out
				.println(fr1
						.readFile("C:\\DevelopTools\\Eclipse\\Workspace\\PRIVATE\\samples\\testfiles\\sample.txt"));

	}
}
