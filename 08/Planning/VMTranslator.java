import java.io.*; 
import java.util.*; 

/* To do
	- Clean up code
	- Modulate code
	- Improve memory segment asm code
	- Only import necessary files
	- probably more?
	- Save file to original path (folder)
*/

public class VMTranslator{		
	public static void main(String[] args) throws FileNotFoundException{	
		try { //File creation
			File outputFile = new File("C:\\Users\\Elliot\\Documents\\nand2tetris\\projects\\08\\Planning\\" + args[0].split("\\.")[0] + ".asm"); //output
			if(!outputFile.exists()){
				outputFile.createNewFile();
			}
			CodeWriter codeWriter = new CodeWriter(outputFile);				
			File input = new File("C:\\Users\\Elliot\\Documents\\nand2tetris\\projects\\08\\Planning\\" + args[0]); //input
			
			File[] fileList = input.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".vm");
				}
			});
			String currentFunction = "";
			int retNo = 0; // return number
			
			String bootstrap = Converter.functionMemoryCommands("call", "Sys.init", 0, currentFunction, args[0], retNo);
			bootstrap = (("@256\nD=A\n@SP\nM=D\n") + bootstrap);
			codeWriter.write(bootstrap);
			retNo++;
			for (File eachFile : fileList) {															// for each VM file
				Scanner labelScan = new Scanner(eachFile); 												// file Scanner - must choose file
				String currentFile = eachFile.getName();
				System.out.println(currentFile);
				while(labelScan.hasNextLine() == true){													//while unread data exists
					String parse = labelScan.nextLine();												// parse = current line
					if(!parse.startsWith("/")){			
						parse = parse.split("/")[0];													// trims comments
						if (parse.length()!=0){															// if not blank line
							String[] arguments = parse.split("\\s+");									// parse.split("\\s+", 3);
							if ((arguments.length == 1) && !(arguments[0].matches("return"))){			//arithmetic cases
																										//add,and,eq,gt,lt,neg,not,or,sub
								String output = Converter.arithmetic(arguments[0]);	
								codeWriter.write("// " + arguments[0] + "\n");
								codeWriter.write(output);
							} else if (arguments.length == 2){ 											// of the form @(functionName.foo)$(labelName)
								String command = arguments[0];
								String label = arguments[1];
								String output = Converter.branchCommands(command, (currentFunction+"$"+label));
								//System.out.println("// " + arguments[0] + " " + arguments[1]);
								//System.out.println(output);
								codeWriter.write("// " + arguments[0] + " " + arguments[1] + "\n");
								codeWriter.write(output);
							} else if (arguments.length == 3) {			
								// command = arguments[0];	
								// memSegment = arguments[1];	
								int intArgument = Integer.parseInt(arguments[2]);	//i					
								if (arguments[0].matches("function")){
									currentFunction = arguments[1];
								}
								String output = Converter.functionMemoryCommands(arguments[0], arguments[1], intArgument, currentFunction, currentFile, retNo);
								//System.out.println("// " + arguments[0] + " " + arguments[1] + " " + arguments[2]);
								//System.out.println(output);
								codeWriter.write("// " + arguments[0] + " " + arguments[1] + " " + arguments[2] + "\n");
								codeWriter.write(output);
								if (arguments[0].matches("call")){
									retNo++;
								}
							} else if (arguments[0].matches("return")) {
								String output = Converter.returnFunction(currentFile);
								//System.out.println("// " + arguments[0]);
								//System.out.println(output);
								codeWriter.write("// " + arguments[0] + "\n");
								codeWriter.write(output);
							}	
						}
					}
				}
			}
			codeWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}