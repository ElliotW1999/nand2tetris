import java.io.*; 
import java.util.*;

public class Converter {
	public static String popSegment(String memSegment, int iValue, String filename){	// returns asm code
		String output = "";
		switch (memSegment) {
			case "local": //System.out.println("@" + iValue + "\nD=A\n@LCL\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D");
				output = "@" + iValue + "\nD=A\n@LCL\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D\n";
				return output;
			case "argument": //System.out.println("@" + iValue + "\nD=A\n@ARG\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D");
				output = "@" + iValue + "\nD=A\n@ARG\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D\n";
				return output;
			case "this": //System.out.println("@" + iValue + "\nD=A\n@THIS\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D");
				output = "@" + iValue + "\nD=A\n@THIS\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D\n";
				return output;
			case "that": //System.out.println("@" + iValue + "\nD=A\n@THAT\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D");
				output = "@" + iValue + "\nD=A\n@THAT\nD=D+M\n@13\nM=D\n@SP\nM=M-1\nA=M\nD=M\n@13\nA=M\nM=D\n";
				return output;
			case "static": //System.out.println("@SP\nAM=M-1\nD=M\n@" + filename + iValue + "\nM=D");
				output = "@SP\nAM=M-1\nD=M\n@" + filename + iValue + "\nM=D\n";
				return output;
			case "pointer": //System.out.println("@SP\nAM=M-1\nD=M\n@" + (iValue+3) + "\nM=D");
				output = "@SP\nAM=M-1\nD=M\n@" + (iValue+3) + "\nM=D\n";
				return output;
			case "temp": //System.out.println("@SP\nAM=M-1\nD=M\n@" + (iValue+5) + "\nM=D");
				output = "@SP\nAM=M-1\nD=M\n@" + (iValue+5) + "\nM=D\n";
				return output;
		}
		return null;
	}
	public static String pushSegment(String memSegment, int iValue, String filename){	// returns asm code
		String output = ""; // needed?
		
		switch (memSegment) {
			case "local": //System.out.println("@" + iValue + "\nD=A\n@LCL\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + iValue + "\nD=A\n@LCL\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n"; // was @LCL\nA=D+M
				return output;
			case "argument": //System.out.println("@" + iValue + "\nD=A\n@ARG\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + iValue + "\nD=A\n@ARG\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
			case "this": //System.out.println("@" + iValue + "\nD=A\n@THIS\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + iValue + "\nD=A\n@THIS\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
			case "that": //System.out.println("@" + iValue + "\nD=A\n@THAT\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + iValue + "\nD=A\n@THAT\nA=D+M\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
			case "static": //System.out.println("@" + filename + "." + iValue + "\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + filename + iValue + "\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
			case "pointer": //System.out.println("@" + (iValue+3) + "\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + (iValue+3) + "\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
			case "temp": //System.out.println("@" + (iValue+5) + "\nD=M\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + (iValue+5) + "\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
			case "constant": //System.out.println("@" + iValue + "\nD=A\n@SP\nM=M+1\nA=M-1\nM=D");
				output = "@" + iValue + "\nD=A\n@SP\nM=M+1\nA=M-1\nM=D\n";
				return output;
		}
		return null;
	}
	public static String arithmetic(String command){	// returns asm code	
		int eqLabel = 0;
		int gtLabel = 0;
		int ltLabel = 0;
		switch (command) {
			case "add": //System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=D+M"); //output add asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=D+M\n");
			case "and": //System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=D&M"); //output and asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=D&M\n");
			case "eq": eqLabel++;
				//System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\nD=M\n@eq" + eqLabel + "\nD;JEQ\n@SP\nA=M-1\nM=1\n(eq" + eqLabel + ")\n@SP\nA=M-1\nM=M-1"); //output eq asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\nD=M\n@eq" + eqLabel + "\nD;JEQ\n@SP\nA=M-1\nM=1\n(eq" + eqLabel + ")\n@SP\nA=M-1\nM=M-1\n");
			
			case "gt": gtLabel++;
				//System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\nD=M\n@gt" + gtLabel + "\nD;JGT\n@SP\nA=M-1\nM=0\n@gtEnd" + gtLabel + "\n0;JMP\n(gt" + gtLabel + ")\n@SP\nA=M-1\nM=-1\n(gtEnd" + gtLabel + ")"); //output gt asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\nD=M\n@gt" + gtLabel + "\nD;JGT\n@SP\nA=M-1\nM=0\n@gtEnd" + gtLabel + "\n0;JMP\n(gt" + gtLabel + ")\n@SP\nA=M-1\nM=-1\n(gtEnd" + gtLabel + ")\n");	
			
			case "lt": ltLabel++;
				//System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\nD=M\n@lt" + ltLabel + "\nD;JLT\n@SP\nA=M-1\nM=0\n@ltEnd" + ltLabel + "\n0;JMP\n(lt" + ltLabel + ")\n@SP\nA=M-1\nM=-1\n(ltEnd" + ltLabel + ")"); //output lt asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\nD=M\n@lt" + ltLabel + "\nD;JLT\n@SP\nA=M-1\nM=0\n@ltEnd" + ltLabel + "\n0;JMP\n(lt" + ltLabel + ")\n@SP\nA=M-1\nM=-1\n(ltEnd" + ltLabel + ")\n");
				
			case "neg": //System.out.println("@SP\nA=M-1\nM=-M"); //output neg asm code
				return ("@SP\nA=M-1\nM=-M\n");
			case "not": //System.out.println("@SP\nA=M-1\nM=-M\nM=M-1"); //output not asm code
				return ("@SP\nA=M-1\nM=-M\nM=M-1\n");
			case "or": //System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=D|M"); //output or asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=D|M\n");
			case "sub": //System.out.println("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D"); //output sub asm code
				return ("@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D\n");
		}
		return null;		
	}
	public static String branchCommands(String command, String label){	// label is function$label (argument 1)
		switch (command) {
			case "goto": return ("@" + label + "\n0;JMP\n");
			case "if-goto": return ("D=M\n@" + label + "\nD;JNE\n");			// was ("@" + label + "\nD=M\nD;JNE\n");	
			case "label": return ("(" + label + ")\n");
		}
		return null;		
	}
												//command = argument[0], funcName/memSegment = argument1, n/i = intArgument, currentFunction, current file  (necessary?)
	public static String functionMemoryCommands(String command, String argument1, int intArgument, String currentFunction, String currentFile, int retNo){	// function and memory commands	
		switch (command) { 
			case "push": return pushSegment(argument1, intArgument, currentFile); 								//memory segment, i, filename
			case "pop": return popSegment(argument1, intArgument, currentFile); 								//memory segment, i, filename
			case "function": String functionLabel = ("(" + argument1 + ")\n");	
				if (intArgument >= 1) {
					for (int i = 0; i < intArgument; i++) {														//repeat nVars times: nVars = number of local variables
						functionLabel = (functionLabel + pushSegment("constant", 0, currentFile) + "\n"); 		// initializes the local variables to 0
					} 																
				}
				return functionLabel; // DONE?
			case "call": 									//DONE?
				String pushRetAddrLabel = ("@return$" + retNo + "\nD=A\n@SP\nM=M+1\nA=M-1\nM=D\n"); 					// push retAddrLabel --- translator generated label
				String pushLocal = "@LCL\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1\n";			// push LCL
				String pushArg = "@ARG\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1\n"; 										// push ARG, was pushSegment("argument", 0, currentFile);
				String pushThis = "@THIS\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1\n"; 											// push THIS
				String pushThat = "@THAT\nD=M\n@SP\nA=M\nM=D\n@SP\nM=M+1\n"; 											// push THAT
				String pushSP = ("@SP\nD=M\nM=M+1\nA=M-1\nM=D\n"); 											// push SP
				String pushC5 = pushSegment("constant", 5, currentFile); 									// push constant 5
				String sub = arithmetic("sub");																// sub
				String pushCn = pushSegment("constant", intArgument, currentFile); 							// push constant (arguments[2]) -- nArgs
																											// sub
				String popArg = ("@SP\nM=M-1\nA=M\nD=M\n@ARG\nM=D\n");						// pop ARG 0 (dynamically allocate ARG to SP-5-nArgs)
				String moveLCL = ("@SP\nD=M\n@LCL\nM=D\n");										// LCL = SP --- moves LCL
				String gotoCallee = branchCommands("goto", argument1);							// goto functionName
				String retAddrLabel = branchCommands("label", ("return$" + retNo));				// (retAddrLabel) should this be (functionName$ret.i)? 
				
				return (pushRetAddrLabel + pushLocal + pushArg + pushThis + pushThat + pushSP + pushC5 + sub + pushCn + sub + popArg + moveLCL + gotoCallee + retAddrLabel);	
		}
		return null;
	}
	
	public static String returnFunction(String currentFile){	
		String local = "@LCL\nD=M\n@SP\nM=M+1\nA=M-1\nM=D\n";
		String endFrame = popSegment("temp", 8, currentFile);				// endFrame = LCL
		String pushEndframe = pushSegment("temp", 8, currentFile);
		String pushC5 = pushSegment("constant", 5, currentFile); 
		String sub = arithmetic("sub");		
		String retAddr = ("@SP\nAM=M-1\nA=M\nD=M\n@14\nM=D\n");						// retAddr = *(endFrame – 5) in RAM[14]
		String popArg = ("@SP\nAM=M-1\nD=M\n@ARG\nA=M\nM=D\n");			 			// *ARG = pop()
		String moveSP = ("@ARG\nD=M+1\n@SP\nM=D\n");								// SP = ARG + 1
		String getTHAT = ("@13\nD=M\n@15\nM=D-1\nA=M\nD=M\n@THAT\nM=D\n");			// THAT = *(endFrame – 1)
		String getTHIS = ("@15\nM=M-1\nA=M\nD=M\n@THIS\nM=D\n");					// THIS = *(endFrame – 2)
		String getARG = ("@15\nM=M-1\nA=M\nD=M\n@ARG\nM=D\n");						// ARG = *(endFrame – 3)
		String getLCL = ("@15\nM=M-1\nA=M\nD=M\n@LCL\nM=D\n");						// LCL = *(endFrame – 4)
		
		
		String gotoRetAddr = ("@14\nA=M\n0;JMP\n");						// was branchCommands("if-goto", "13"), goto retAddr, goes to the caller’s return address, as return Address != 0, can use if-goto
		
		return (local + endFrame + pushEndframe + pushC5 + sub + retAddr + popArg + moveSP + getTHAT + getTHIS + getARG + getLCL + gotoRetAddr);
	}
}