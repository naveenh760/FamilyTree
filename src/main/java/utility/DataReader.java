package utility;

import java.io.*;

public class DataReader {

	private File inputFile;
	private BufferedReader bufReader;

	public DataReader(File file) throws FileNotFoundException {
		this.inputFile = file;
		reset();
	}

	public void reset() throws FileNotFoundException {
		FileReader fileReader = new FileReader(inputFile);
		bufReader = new BufferedReader(fileReader);
	}

	public String getLine() throws IOException {
		return bufReader.readLine();
	}

}
