import java.util.InputMismatchException;
import java.util.Scanner;


public class DNAAlignmentSystem { 
	private static Scanner input = new Scanner(System.in);
    private static String sequence_1, sequence_2; 
    private static double gap,match,mismatch;
    
	public static void sequenceInput(){
//		String sequence_1;
		while(true){
	    	   //try {
	 	          System.out.print("squence 1 -->");
	 	          //System.out.println("squence 1===="+sequence_1);

	 	          sequence_1 = input.nextLine();
	 	          if (isValidDNASeq(sequence_1) ){
	 	        	  break;
	 	           }else{
	 	 	          System.out.println("Enter a valid sequence");

	 		          continue;
	 	          }	 	          
	 	          
	 	       //}//catch(InputMismatchException e){
	 	    	
	 	       //}
	       }
      
	       while(true){
	    	  // try {
	 	          System.out.print("squence 2 -->");
	 	          sequence_2 = input.nextLine();
	 	          if (isValidDNASeq(sequence_2)){
	 	        	  break;
	 	           }else{
	 	 	          System.out.println("Enter a valid sequence");
	 		          continue;
	 	          }	 	          
	 	          
	 	       //}catch(InputMismatchException e){
	 	    	
	 	       //}
	       }
	}
    public static void parametersInput (){
	       
    	while(true){
	    	   try {
	 	          System.out.print("match score-->");
	 	          match = Double.parseDouble(input.next());
	 	        	 break;
	 	       }catch(NumberFormatException e){
		 	          System.out.println("Invalid input ");

	 	       }
	       }
	       while(true){
	    	   try {
	 	          System.out.print("missmatch score-->");
	 	           mismatch = Double.parseDouble(input.next());      
	 	           break;
	 	       }catch(NumberFormatException e){
	 	    	  System.out.println("Invalid input ");
	 	       }
	       }
	       
	       while(true){
	    	   try{
	    	   System.out.print("gap penalty-->");
	 	       gap = Double.parseDouble(input.next());   
	 	        break;
	 	       }catch ( NumberFormatException e){
		 	    	  System.out.println("Invalid input ");
	 	      }
	       }
	}
    public static int optionInput (){
    	int option;
  	   
  	   while(true){
  		   System.out.println("     1)Print both sequences");
  		   System.out.println("     2)Print initialized matrix");
  		   System.out.println("     3)Result of the Needleman-Wunsch (print entire matrix)");
  		   System.out.println("     4)Print one optimal alignment");
  		   System.out.println("     5)Print all optimal alignments ");
  		   System.out.println("     6)Enter two new sequences (return to part A)");
  		   System.out.println("     7)Exit");
      	   try {
   	          option = input.nextInt();
   	          if (option >0 && option <=7){
   	        	  break;
   	           }else{
   	 	          System.out.println("------Enter a valid option------");
   	 	 	      System.out.println();
   		          continue;
   	          }	 	          
   	          
   	       }catch(InputMismatchException e){
   	    	
   	       }
         }
  	   System.out.println("-------Great!-----");
  	   return option;
	}
	public static boolean isValidDNASeq(String seq){
		if(seq.isEmpty()){
			return false ;
		}
	   for(int i=0;i< seq.length();i++) {
		  switch (seq.charAt(i)) {
	        case 'A':  
	        	break;
	        case 'a':  
	        	break;

	        case 'T':  
	        	break;

	        case 't':  
	        	break;
	                
	        case 'C':  
	        	break;

	        case 'c':  
	        	break;
	       	      
	        case 'G': 
	        	break;
	        	
	        case 'g':      
	        	break;

	        default : 
	        	System.out.println("Invalid sequence ");
	        	return false;
	      }
	  }
	      return true;
	}
	/*When an option is obtained from the user , mapOptons method specifies 
	 * what must be done according to the option chosen . 
	 * 
	 */
    public static void mapOptions(DNA dna1, DNA dna2, int option){
           DPM matrix = new DPM(dna1,dna2,match,mismatch,gap);
    	 switch (option) {
         case 1:  
     	         System.out.println(dna1);
     	         System.out.println(dna2);

                  break;
         case 2:  
        	      matrix .initializeMatrix();
                  
                  break;
         case 3:  
        	      matrix.fillMarix();
                  break;
         case 4:  
        	    System.out.println("=====Optimal Alignment NOT yet implemnted ======");
                  break;
         case 5:  
    	        System.out.println("=====Optimal Alignment NOT yet implemnted ======");
                  break;
         case 6:  
        	      sequence_1 = null;
        	      sequence_2 = null;
        	      parseUserInput();
                  break;
         case 7:  
                 System.out.print("==== Exit Successful====");
        	     System.exit(0);
                 
         
       }
         System.out.println("");
    	 int opt =  optionInput();
    	 mapOptions(dna1,dna2,opt);
    }
	public static void parseUserInput(){

	    System.out.println("A) Input 2 valid DNA sequences and related parameters:");
	    //   
	    sequenceInput();
	    //
	    parametersInput();
	    //
	    DNA DNA_1 = new DNA(sequence_1.toUpperCase());
	    DNA_1.setSequence(sequence_1.toUpperCase());
		DNA DNA_2 = new DNA(sequence_2.toUpperCase());
	    DNA_2.setSequence(sequence_2.toUpperCase());

	    System.out.println();
		System.out.println(". . . sequences verified and DNA object constructed . . .");
		System.out.println();
		//  
   	    System.out.println("B)Choose an option:");

	    int opt= optionInput();

	   
	    //
	    mapOptions(DNA_1, DNA_2, opt);
	 }
	 public static void main (String args[]){
		 parseUserInput();
	 }
}
