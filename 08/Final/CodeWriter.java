import java.io.*; 
import java.util.*;

public class CodeWriter {
	private PrintWriter outputStream;
	
	public CodeWriter(File outputFile) throws FileNotFoundException{
		outputStream = new PrintWriter(outputFile);	
	}
	
	public void write(String output) {
		outputStream.print(output);		
	}
	
	public void close() {
		outputStream.close();
	}
}