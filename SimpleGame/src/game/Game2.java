package game;

public class Game2 {
	
	int seconds;
	
	public Game2(int seconds) {
		this.seconds=seconds;

   }
	
	public String digitSum(int seconds) {
		String str= String.valueOf(seconds);
		int sum=0;
		StringBuilder result = new StringBuilder();
		
		for(int i=0 ; i<str.length();i++) {
			   
			int digit = Character.getNumericValue(str.charAt(i));
			sum=sum+digit;
			result.append(digit);
	        if (i < str.length() - 1) {
	            result.append(" + ");
	        }
	    }

	    result.append(" = ").append(sum);
	    return result.toString();
	}

    
}

	
