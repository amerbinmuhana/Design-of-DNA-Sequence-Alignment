
public class DPM {
	private double matrix[][];
    private DNA DNA_1,DNA_2;
    private int rows, cols;
    private double match, mismatch, gap;
    private String matrixChar[][]; 
    private String seqStr1,seqStr2;
    private char [] seq1,seq2;
	public DPM (DNA DNA_1, DNA DNA_2,double match, double mismatch,double gap){
		this.DNA_1=DNA_1;
		this.DNA_2=DNA_2;
		this.match = match;
		this.mismatch = mismatch;
		this.gap = gap;
		seqStr1= "-"+DNA_1.getSequence();
		seqStr2= "-"+DNA_2.getSequence();
        
        seq1 = seqStr1.toCharArray();
        seq2 = seqStr2.toCharArray();
        
        cols = seq1.length;
		rows = seq2.length;
		
		matrix = new double[cols][rows];
		matrixChar = new String[cols][rows];

       
	}
	
	/* createCharmatrix() is a helper method to get the score of tow characters. 
	 * for example matrixChar[1][1] = GG. The cellValue() method uses this 
	 * information to decide on match or mismatch between characters. 
	 * below is an example of how the character matrix looks like  
	 *     G    C   A     T    G    C   G
	 * 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
	 *G 0 | GG | CG | AG | TG | GG | CG | GG |
	 *A 0 | GA | CA | AA | TA | GA | CA | GA |
	 *T 0 | GT | CT | AT | TT | GT | CT | GT |
	 *T 0 | GT | CT | AT | TT | GT | CT | GT |
	 *A 0 | GA | CA | AA | TA | GA | CA | GA |
	 *C 0 | GC | CC | AC | TC | GC | CC | GC |
	 *A 0 | GA | CA | AA | TA | GA | CA | GA |
	 
	 */
	public void createCharmatrix(){
		String s="";
		for (int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(i==0 || j==0){
            		matrixChar[j][i]= "0";
        		 }else{
             		matrixChar[j][i]= ""+seq1[j]+seq2[i];

        		}
			}

		} 
	}
	/*cellValue(int i, int j) uses the character matrix that the 
	 * createCharmatrix() creates. The cellValue(int i, int j) uses the character 
	 * matrix to decide the match and mismatch between tow chars and compute the cell value 
	 * @param : i : is the row numbers anf j: is the column number 
	 * @return : The value of call at 1 and j
	 * 
	 */
	public double cellValue(int i, int j){
		double aboveCell,leftCell,diagnolCell,score;
		createCharmatrix();
		char [] c = matrixChar[i][j].toCharArray();
		
		if (c[0]==c[1]){
			score = match;
		}else{
			score =mismatch;
		}

	    aboveCell = matrix[i-1][j];
	    leftCell = matrix[i][j-1];
	    diagnolCell = matrix[i-1][j-1];

	    double max = Math.max(aboveCell+gap,leftCell+gap);
	    //diagnolCell = matrix[i-1][j-1];
        
		return Math.max(diagnolCell+score, max); 
	}
	/*
	 * fillMarix () fills the scoring matrix according to 
	 * the match, mismatch and gap values supplied by the user 
	 * 
	 */
	public void fillMarix (){
        printRow(seqStr1);		
		for(int i=0; i<rows;i++){
       		System.out.print(seq2[i]+" ");
			for(int j=0;j<cols;j++){
				if(i==0){
            		matrix[j][i]= gap*j;
           		    System.out.print(" "+matrix[j][i]+" |");
        		} else if (j==0){
            		matrix[j][i]= gap*i;

           		    System.out.print(" "+matrix[j][i]+" |");

        		 }else{
        			 matrix[j][i]= cellValue(j,i);
            		 System.out.print(" "+matrix[j][i]+" |");

        		}
			}
			
			System.out.println();
			for(int j=0; j< cols; j++){
	              System.out.print("------");
	  		}
	   		System.out.println();
	        

			
		}
	}
	/* initializeMatrix () fills he top most row and left must row of the matrix using 
	 * thee following formula matrix[i][0] = gap*j and  matrix[0][j] = gap*i
	 * This is provides the initial conditions for the needleman wunsch algorthem to work 
	 * 
	 */
	public void initializeMatrix (){
        printRow(seqStr1);		
		String str ="";
        for(int i= 0; i<rows; i++){
        	str=" ";
        	str=seq2[i]+str;
       		System.out.print(seq2[i]+" ");

        	for(int j=0; j< cols; j++){

        		if(i==0){
            		matrix[j][i]= gap*j;
            		str = str+" "+matrix[j][i];
           		    System.out.print(" "+matrix[j][i]+" |");
        		} else if (j==0){
       		 	    str = str+" "+matrix[j][i];
            		matrix[j][i]= gap*i;

           		    System.out.print(" "+matrix[j][i]+" |");

        		 }else{
        		 	str = str+" "+matrix[j][i];
               		System.out.print("    "+" |");

        		}
        		
        	}
           // printRow(str);

    		System.out.println();
 		for(int j=0; j< cols; j++){
              System.out.print("------");
  		}
   		System.out.println();
        }
	}
	/* Takes a string prints its characters in row with a specific format 
	 * @param : String value . 
	 */
	public void printRow(String row){
		//String [] s = row.split(" ");
		System.out.print(" - ");
		for (int i =0; i<row.length(); i++) {
			System.out.print("  ");
            System.out.print(row.charAt(i));
            System.out.print("   ");
        }
        System.out.println();
	}

}
