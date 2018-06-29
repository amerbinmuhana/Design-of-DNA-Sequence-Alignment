
public class DNA {
	private int ID =0;
	private String sequence ;
	public static int COUNT_ID =0;
	
	public DNA(String seq){
		this.sequence = seq;
		COUNT_ID +=1;
		ID +=COUNT_ID;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String toString() {
		return "DNA sequence with ID = "+ ID +" is:"+sequence;
	}
	
}
