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
	//This method was inspired by http://www.javapractices.com/topic/TopicAction.do?Id=96 In which it is based off
	public static String forHTML(String aText)
	{
		//This will take in the text the system is trying to parse, this will take the input, and filter through the characters
	    StringBuilder r = new StringBuilder();
	    StringCharacterIterator iterator = new StringCharacterIterator(aText);
	    char c =  iterator.current();
		//While the character is not the last, check for any escapes required
	    while (c != CharacterIterator.DONE )
		{
	       	if (c == '<') {
	         	r.append("&lt;");
	       	}
	       	else if (c == '>') 
			{
	         	r.append("&gt;");
	       	}
	       	else if (c == '&') 
		   	{
	        	r.append("&amp;");
	      	}
	       	else if (c == '\"') 
			{
	        	r.append("&quot;");
	       	}
	       	else 
	       	{
	        //the char is not a special one
	        //add it to the result as is
	        	r.append(c);
	       	}
	       	c = iterator.next();
	    }
		//Method Check
	    System.out.println(r.toString());
	    return r.toString();
	}
}
