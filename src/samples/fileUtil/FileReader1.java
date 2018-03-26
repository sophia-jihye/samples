package samples.fileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReader1 {

	public String readFile(String filePath) throws IOException {
		StringBuffer text = new StringBuffer();

		BufferedReader br = new BufferedReader(new FileReader(
				new File(filePath)));

		String buffer = "";
		while ((buffer = br.readLine()) != null) {
			text.append(buffer + "\n");
		}
		br.close();

		return text.toString();
	}

}
