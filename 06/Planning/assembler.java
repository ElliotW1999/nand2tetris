import java.io.*; 
import java.util.*; 

/* To do list:
	- Create modules for files
	- Clean up code 
	- Make assembler take fileName as input and create fileName.hack (automation)
	- Improve logic
	- Figure out how to write to files properly
	- Only import relevant java stuff
*/


public class assembler{	
	public static String translate(int input, int size){	//change to return bin value
		int container[] = new int[size];
		int i = 0;
		while (input > 0){
			container[i] = input%2;
			i++;
			input = input/2;
		}
		while (i < size) {
			container[i] = 0;
			i++;
		}
		for(int j = 0; j<size/2; j++){
			int temp = container[j];
			container[j] = container[size -j -1];
			container[size -j -1] = temp;
		}
		String binStr = Arrays.toString(container).replaceAll("\\[|\\]|,|\\s", "");
		return binStr;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		// Initialization
		lookUpTable symbolTable = new lookUpTable();
		List<String> initSymbols = Arrays.asList("R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15", "SCREEN", 
													"KBD", "SP", "LCL", "ARG", "THIS", "THAT");		
		symbolTable.setSymbol(initSymbols);	

		List<Integer> initAddress = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16384, 24576, 0, 1, 2, 3, 4);
		symbolTable.setAddress(initAddress);		
		
		lookUpTable computationTable = new lookUpTable();
		computationTable.setSymbol(Arrays.asList("0", "1", "-1", "D", "A", "!D", "!A", "-D", "-A", "D+1", "A+1", "D-1", "A-1", "D+A", "D-A", "A-D", "D&A", "D|A", "M", "!M", "-M", 
									"M+1", "M-1", "D+M", "D-M", "M-D", "D&M", "D|M"));
		computationTable.setAddress(Arrays.asList(42, 63, 58, 12, 48, 13, 49, 15, 51, 31, 55, 14, 50, 2, 19, 7, 0, 21, 112, 113, 115, 119, 114, 66, 83, 71, 64, 85)); //7bit
		
		lookUpTable destinationTable = new lookUpTable();
		destinationTable.setSymbol(Arrays.asList("0", "M", "D", "MD", "A", "AM", "AD", "AMD"));
		destinationTable.setAddress(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));	// 3bit
	
		lookUpTable jumpTable = new lookUpTable();
		jumpTable.setSymbol(Arrays.asList("0", "JGT", "JEQ", "JGE", "JLT", "JNE", "JLE", "JMP"));
		jumpTable.setAddress(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)); // 3bit
		try {
			File outputFile = new File("C:\\Users\\Elliot\\Documents\\nand2tetris\\projects\\06\\Planning\\Output.hack");
			if(!outputFile.exists()){
				outputFile.createNewFile();
			}
		
		PrintWriter printWriter = new PrintWriter(outputFile);		
		File file = new File("C:\\Users\\Elliot\\Documents\\nand2tetris\\projects\\06\\Planning\\Rect.asm");
		Scanner labelScan = new Scanner(file);			// file Scanner - must choose file
		int currentLine = 0;
		int skipLine = 0;
		
		// Extracting labels
		while(labelScan.hasNextLine() == true){					//while unread data exists
			String parse = labelScan.nextLine();				// parse = current line
			parse = parse.replace(" ", "");						// removes white space
			parse = parse.split("/")[0];						// trims comments
			if (parse.length()!=0){								// if not blank line
			
				if (parse.contains("(")){
					parse = parse.substring(1,parse.length()-1);
					symbolTable.addEntry(parse, currentLine-skipLine);
					skipLine++;
				}
				currentLine++;
			}
		}
		
		Scanner instructionScan = new Scanner(file);						// Construct new Scanner for second loop
		int n = 16;		
		while(instructionScan.hasNextLine() == true){						//while unread data exists
			String parse = instructionScan.nextLine();						// parse = current line
			parse = parse.replace(" ", "");									// removes white space
			parse = parse.split("/")[0];									// trims comments
			if (parse.length()!=0){	
				if (parse.contains("@")){										// if a-inst
					parse = parse.split("@")[1];
					if (parse.matches("^\\d+$")){								//if parse = +integer
						int instruction = Integer.parseInt(parse);
						String output = translate(instruction, 15);
						System.out.println("0" + output);
						printWriter.println("0" + output);	
					} else {
						if(symbolTable.containsSymbol(parse)){						// if in symbol list, get address value
							int instruction = symbolTable.getAddress(symbolTable.getSymbolIndex(parse));
							String output = translate(instruction, 15);
							System.out.println("0" + output);
							printWriter.println("0" + output);
						} else {		
							symbolTable.addEntry(parse, n);							// add to symbol table
							String output = translate(n, 15); // (n, 15)? or Integer.parseInt(parse)
							System.out.println("0" + output);
							printWriter.println("0" + output);
							n++;
						}
					}
					
				} else if (!parse.contains("(")){								// if c-instr
					String destOut = "000";
					String jumpOut = "000";
					String compOut = parse;
					
					String comp = new String();
					
					if (parse.contains("=")){
						comp = parse.split("=")[1];									// converting comp bits
						comp = comp.split(";")[0];
						comp = comp.split(" ")[0];
						if (computationTable.containsSymbol(comp)){
							int compBin = computationTable.getAddress(computationTable.getSymbolIndex(comp));
							compOut = translate(compBin, 7);
						}
						
						String dest = parse.split("=")[0];							// converting dest bits
						if (destinationTable.containsSymbol(dest)){
							int destBin = destinationTable.getAddress(destinationTable.getSymbolIndex(dest));
							destOut = translate(destBin, 3);
						}
						
						if (parse.contains(";")){
							String jump = parse.split(";")[1];
							jump = jump.split(" ")[0];
							if (jumpTable.containsSymbol(jump)){
								int jumpBin = jumpTable.getAddress(jumpTable.getSymbolIndex(jump));
								jumpOut = translate(jumpBin, 3);
							}
						}
						
					} else if (parse.contains(";")){
						String jump = parse.split(";")[1];
						jump = jump.split(" ")[0];
						if (jumpTable.containsSymbol(jump)){
							int jumpBin = jumpTable.getAddress(jumpTable.getSymbolIndex(jump));
							jumpOut = translate(jumpBin, 3);
							
						}
						
						comp = parse.split(";")[0];
						if (computationTable.containsSymbol(comp)){
							int compBin = computationTable.getAddress(computationTable.getSymbolIndex(comp));
							compOut = translate(compBin, 7);
						}
					}
					System.out.println("111" + compOut + destOut + jumpOut);
					printWriter.println("111" + compOut + destOut + jumpOut);	// write to file
				}
			}
		}
		printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}