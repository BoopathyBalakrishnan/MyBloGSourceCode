
public class PalindromChecker {

	public boolean isPalindrome(String string) {
		
		
		/*if(string.equals("Junit"))
			
			return false;
		return true;*/
		
		/**
		 * StringBuffer reverseString =new StringBuffer(string);
		reverseString.reverse();
		 */
		String reverseString ; 


		/*if(string.equalsIgnoreCase(reverseString))
		return true;
		return false;*/
		
		return string.equalsIgnoreCase(getReversedString(string));
			}

	private String getReversedString(String string) {
		StringBuffer reverseString =new StringBuffer(string);
		reverseString.reverse();
		return reverseString.toString();
	}

}
