import java.util.*;
import java.io.*;

public class lookUpTable {
	
	private ArrayList<String> symbol;
	private ArrayList<Integer> address;// string or int???
	
	lookUpTable() {
		address = new ArrayList<Integer>();
		symbol = new ArrayList<String>();
	}
	
	lookUpTable( ArrayList<String> symbol, ArrayList<Integer> address){
		symbol = symbol;
		address = address;
	}
		
	public int getSymbolIndex(String input) {
		for (int i=0;i<symbol.size();i++){
			//System.out.println(symbol.get(i));
			if(symbol.get(i).equals(input)) {
				return i;
			}
		}
		return 0;
	}
	
	public String getSymbol(int index) {
		return symbol.get(index);	
	}
	
	public int getAddress(int index) {
		return address.get(index);	
	}
	
//	public int getAddress(String symbol){
//		return getAddress(getSymbolIndex(symbol));
//	}
	
	public void setSymbol(List<String> input){
		symbol.addAll(input);
	}
	
	public void setAddress(List<Integer> input){
		address.addAll(input);
	}
	
	public void addEntry(String inputSymbol, int inputAddress){
		symbol.add(inputSymbol);
		address.add(inputAddress);
	}
	
	public boolean containsSymbol(String input){
		if (symbol.contains(input)) {
			return true;
		}
		return false;
	}
	
}