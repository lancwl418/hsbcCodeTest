package com.hsbc.currency;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeCenter {

	public static void main(String[] args) {
		System.out.println("**********************************************************************");
	    System.out.println("********************Welcome to the trade center!**********************");
	    System.out.println("**********************************************************************");
	    System.out.println("Do you want to read file for initialization? (yes/no)");
	    
	    Scanner inputScanner = new Scanner(System.in);
	    String inputFile = inputScanner.nextLine();
	    
	    
	    while(!inputFile.toLowerCase().equals("no") && !inputFile.toLowerCase().equals("yes")) {
	    	System.out.println("Please input correct value (yes/no)");
	    	inputFile = inputScanner.nextLine();
	    }
	    
	    
	    if(inputFile.toLowerCase().equals("yes")) {
	    	try {
	    		 File file = new File("trade.txt");
	    	     Scanner myReader = new Scanner(file);
	    	     
	    	     System.out.println("Initial payment inputs: ");
	    	     
	    	     while (myReader.hasNextLine()) {
	    	    	 
	    	        String data = myReader.nextLine();  
	    	        System.out.println(data);
	    	        
	    	        String currency = data.split(" ")[0];
	    	        int amount = Integer.parseInt(data.split(" ")[1]);
	    	        
	    	        Payment payment = new Payment(currency, amount);
	    	        Payments.addPayments(payment);
	    	      }
	    	     
	    	      myReader.close();
	    	    
	    	} catch (FileNotFoundException e) {
	    		System.out.println("An error occurred.");
	    	}
	    }
	    
	    String morePayment = "";
	    
	    String pattern = "^[a-zA-Z]{3}\\s\\-{0,1}\\d+$";

	      // Create a Pattern object
	    Pattern r = Pattern.compile(pattern);
	    
	    do { 
            System.out.println("Please input more payments if needed (Ex: USD 123), please enter no if you don't want to input more payments: ");	
		    
	    	morePayment = inputScanner.nextLine();
	    	Matcher matcher = r.matcher(morePayment);
	    	
	    	if (!morePayment.equalsIgnoreCase("no")) {
	    		
	    		if(!matcher.matches()) break;
	    		
	    		String currency = morePayment.split(" ")[0];
		        int amount = Integer.parseInt(morePayment.split(" ")[1]);
		         
		        Payment payment = new Payment(currency, amount);
		        Payments.addPayments(payment);
	    	}
	    	
	    } while (!morePayment.equalsIgnoreCase("no"));
	    
	    
	    Timer timer = new Timer();
	  
	    timer.schedule( new TimerTask() {
	        public void run() {
	        	System.out.println("Output: ");
	            Payments.printPayments();
	            
	            System.out.println("Type quit anytime if you want to quit the program");
	    	    
	            String quit = "";
	            
	            do { 	
	    		    
	    	    	quit = inputScanner.nextLine();
	    	    	
	    	    	if (quit.equalsIgnoreCase("quit")) {
	    	    		System.exit(0);
	    	    	}
	    	    	
	    	    } while (!quit.equalsIgnoreCase("quit"));
	        }
	     }, 0, 60*1000);
	    
	}
}
