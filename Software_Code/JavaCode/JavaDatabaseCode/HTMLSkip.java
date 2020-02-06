package JavaDatabaseCode;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class HTMLSkip 
{
	String passedInfo;
	
	public String getPassedInfo()
	{
		return passedInfo;
	}
	public void setPassedInfo(String passedInfo) 
	{
		this.passedInfo = passedInfo;
	}
	
	 public static String forHTML(String aText){
	     StringBuilder result = new StringBuilder();
	     StringCharacterIterator iterator = new StringCharacterIterator(aText);
	     char character =  iterator.current();
	     while (character != CharacterIterator.DONE ){
	       if (character == '<') {
	         result.append("&lt;");
	       }
	       else if (character == '>') {
	         result.append("&gt;");
	       }
	       else if (character == '&') {
	         result.append("&amp;");
	      }
	       else if (character == '\"') {
	         result.append("&quot;");
	       }
	       else {
	         //the char is not a special one
	         //add it to the result as is
	         result.append(character);
	       }
	       character = iterator.next();
	     }
	     System.out.println(result.toString());
	     return result.toString();
	  }

