import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CreateRPNCalculator {
	
	private static boolean isInteger(String input)
	{
      boolean status = false;
      try {
      int num = Integer.parseInt(input);
      status = true;
      }catch(Exception e) {
    	  status = false;
      }
      return status;
	}
    
	private static boolean isFloat(String input) {
		boolean status = false;
		try {
		      float num = Float.parseFloat(input);
		      status = true;
		      }catch(Exception e) {
		    	  status = false;
		      }	
		      return status;
	}
	private static Stack isExpression(String input, Stack<Double> stack) throws IOException 
	{
		Double output = null;
		String[] temp = null ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if(input.contains(" "))
		{
		  temp = input.split(" ");
		  for(String x : temp)
		  {
			  if(isInteger(x) || isFloat(x) ) 
			  {
	    		   stack.push(Double.parseDouble(x));
	    	  }
			  else if(isOperator(x)) 
			  {
	    		 switch(x) 
	    		 {
	    		 case "*" : output = 1.0;
	    		            if(stack.size() == 1) 
	    		            {
	    		            	input = br.readLine();
			            		if(isInteger(input) || isFloat(input)) 
			             		   stack.push(Double.parseDouble(input));
			            		br.close();
			            	}
	    		            while(!stack.isEmpty()) 
	    		            {
	    		            	output *= (Double) stack.pop();
	    		            }
	    		            stack.push(output);
	    		            break;
	    		 case "-" : if(stack.size() == 1) {
			            		input = br.readLine();
			            		if(isInteger(input) || isFloat(input)) 
			             		   stack.push(Double.parseDouble(input));
			            	}
			            	Collections.reverse(stack);
			            	output = stack.pop();
				            while(!stack.isEmpty()) {
				            	output -= stack.pop();	
				            }
						    stack.push(output);
			                break;
				 case "+" : output = 0.0;
				 		   if(stack.size() == 1) {
			            		input = br.readLine();
			            		if(isInteger(input) || isFloat(input)) 
			             		   stack.push(Double.parseDouble(input));
			            	}
				            while(!stack.isEmpty()) {
				            	output += stack.pop();
				            }
						    stack.push(output);
				            break;
				 case "/" : if(stack.size() == 1) {
			            		input = br.readLine();
			            		if(isInteger(input) || isFloat(input)) 
			             		   stack.push(Double.parseDouble(input));
			            	}
			            	Collections.reverse(stack);
     		            	output = stack.pop();
				            while(!stack.isEmpty()) {
				            	output /= stack.pop();	
				            }
						    stack.push(output);
			                break;
	    	        }
			    }
		    }
		    return stack;
		  }
		  else { return stack;}
		
	}
	private static boolean isOperator(String input) {
		boolean status = false;
	    if(input.equalsIgnoreCase("*") || input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-") || input.equalsIgnoreCase("/"))	
	      status = true;
	   return status;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Stack<Double> stack = new Stack<Double>();
       System.out.println("*****************CLI RPN Calculator*******************************");
       String input = br.readLine();
       while(input != null)
       {
    	   if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("end")) {
    		   System.out.println("Recieved exit request, Hence exiting!");
    		   break;
    	   }
    	   if(isInteger(input) || isFloat(input)) {
    		   stack.push(Double.parseDouble(input));
    	   }
    	   else if(isOperator(input)) {
    		 Double output = 0.0;
    		 switch(input) {
    		 case "*" : output = 1.0;
    		            if(stack.size() == 1) {
		            		input = br.readLine();
		            		if(isInteger(input) || isFloat(input)) 
		             		   stack.push(Double.parseDouble(input));
		            	}
    		            while(!stack.isEmpty()) {
    		            	output *= stack.pop();
    		            }
    		            stack.push(output);
    		            System.out.println(stack.toString().replace("[", "").replace("]", ""));
    		            break;
    		 case "-" : output = 0.0;
		    		    if(stack.size() == 1) {
		            		input = br.readLine();
		            		if(isInteger(input) || isFloat(input)) 
		             		   stack.push(Double.parseDouble(input));
		            	}
		            	Collections.reverse(stack);
		            	output = stack.pop();
			            while(!stack.isEmpty()) {
			            	output -= stack.pop();	
			            }
					    stack.push(output);
					    System.out.println(stack.toString().replace("[", "").replace("]", ""));
    	                break;
    		 case "+" : output = 0.0;
			 		   if(stack.size() == 1) {
		            		input = br.readLine();
		            		if(isInteger(input) || isFloat(input)) 
		             		   stack.push(Double.parseDouble(input));
		            	}
			            while(!stack.isEmpty()) {
			            	output += stack.pop();
			            }
					    stack.push(output);
					    System.out.println(stack.toString().replace("[", "").replace("]", ""));
    		            break;
    		 case "/" : if(stack.size() == 1) {
		            		input = br.readLine();
		            		if(isInteger(input) || isFloat(input)) 
		             		   stack.push(Double.parseDouble(input));
		            	}
		            	Collections.reverse(stack);
		            	output = stack.pop();
			            while(!stack.isEmpty()) {
			            	output /= stack.pop();	
			            }
					    stack.push(output);
					    System.out.println(stack.toString().replace("[", "").replace("]", ""));
    	                break;
    		 }
    	   }
    	   else {
    		   isExpression(input, stack);
    		   System.out.println(stack.toString().replace("[", "").replace("]", ""));
    	   }
    	   input = br.readLine();
       }
       System.out.println(stack.toString().replace("[", "").replace("]", ""));
	}
	

}
