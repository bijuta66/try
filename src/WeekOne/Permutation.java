package WeekOne;
import java.util.*;

public class Permutation {
	 public static void main(String[] args) { 
	        Permutation permutation = new Permutation(); 
	                         
	        LinkedList<Integer> input_number_list = new LinkedList<Integer>();
	        input_number_list.add(1);
	        input_number_list.add(0);
	        input_number_list.add(1);
	               
	        String input_number = permutation.convertToString(input_number_list);
	        System.out.println(input_number);
	        int lngth = input_number.length(); 
	 
	        LinkedHashSet<String> all_binary_permutes = new LinkedHashSet<String>();
	        permutation.permute(input_number, all_binary_permutes, 0, lngth-1);
	        System.out.println(all_binary_permutes);
	        
	        LinkedList<Integer> result = permutation.convertToDecimal(all_binary_permutes);
	        for(int k=0; k<result.size(); k++) {
	            System.out.println(result.get(k));
	        }
	    } 
	    
	    
	    public LinkedList<Integer> convertToDecimal(LinkedHashSet<String> unique_permutations) {
	        LinkedList<Integer> decimal_list = new LinkedList<Integer>();
	        for (String val: unique_permutations) {
	            char[] individual_numbers = val.toCharArray();
	            int decimal_value = binaryToDecimal(individual_numbers);
	            decimal_list.add(decimal_value);
	        }
	        return decimal_list;
	    }
	    
	    public int binaryToDecimal(char number_array[]) {
	        int decimal = 0;
	        int power = 0;
	        for(int i=number_array.length-1; i>=0; i--) {            
	            decimal += Integer.parseInt(String.valueOf(number_array[i])) * (int)Math.pow(2, power);
	            power++;
	        }
	        
	        return decimal;
	    }
	 
	    
	    public void permute(String str, LinkedHashSet<String> all_binary_permutes, int left, int right) { 
	        if (left == right) {
	            all_binary_permutes.add(str);     
	        }
	      
	        else { 
	            for (int i = left; i <= right; i++) { 
	                str = swap(str, left, i); 
	                permute(str, all_binary_permutes, left+1, right); 
	                str = swap(str,left,i); 
	            } 
	        } 
	    } 
	 
	 
	    public String swap(String data, int i, int j) { 
	        char temp; 
	        char[] charArray = data.toCharArray(); 
	        temp = charArray[i] ; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp; 
	        return String.valueOf(charArray); 
	    } 
	    
	    public String convertToString(LinkedList<Integer> number) {
	        String converted = new String("");
	        for(int i=0; i<number.size(); i++) {
	            converted += number.get(i);
	        }
	        return converted;
	    }
	 
	}





