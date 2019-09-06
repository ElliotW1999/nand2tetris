import java.io.*; 
import java.util.*; 

/* To do
	- Clean up code
	- Modulate code
	- Improve memory segment asm code
	- Only import necessary files
	- probably more?
*/

public class fileReading {
	public static void main(String[] args) throws FileNotFoundException{	
		try { //File creation
			/* must be able to translate multiple asm files into one(?) asm file */
			File outputFile = new File("C:\\Users\\Elliot\\Documents\\nand2tetris\\projects\\08\\Planning\\" + args[0].split("\\.")[0] + ".asm"); //output
			if(!outputFile.exists()){
				outputFile.createNewFile();
			}
			CodeWriter codeWriter = new CodeWriter(outputFile);	
			
			
			//bool isDirectory = false;
			
			File input = new File("C:\\Users\\Elliot\\Documents\\nand2tetris\\projects\\08\\Planning\\" + args[0]); //input
			
			File[] fileList = input.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".vm");
				}
			});
			String currentFunction = "";
			int retNo = 0; // return number
			
			//String bootstrap = Converter.functionMemoryCommands("call", "Sys.init", 0, currentFunction, args[0], retNo);
			//bootstrap = (("@256\nD=A\n@SP\nM=D\n") + bootstrap);
			String bootstrap = ("@256\nD=A\n@SP\nM=D\n");
			codeWriter.write(bootstrap);
			System.out.println(bootstrap);
			System.out.println("TESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTEST");

			//for (int fileNo = 0; fileNo < fileList.length(); fileNo++){ 		
			for (File filee : fileList) {
				Scanner labelScan = new Scanner(filee); 					// file Scanner - must choose file [fileNo]
			
				while(labelScan.hasNextLine() == true){						//while unread data exists	[fileNo]
					String parse = labelScan.nextLine();					// parse = current line [fileNo]
					codeWriter.write(parse);								// trims comments
					System.out.println(parse);
				}
			}
		
			codeWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
