package eighthLight.eighthLight;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;




class StringUtilTest {
	
	StringUtil stringUtil;
	
	
	@Test
	void testcleanString() {
		
		String t1 = stringUtil.cleanString("-90-989-:87!47635");
		assertEquals(t1, "909898747635");
		
	}

	@Test
	void testcleanStringJustChar() {
		
		String t1 = stringUtil.cleanString("-!`'---");
		assertEquals(t1, "");
		
	}
	
	@Test
	void testcleanStringJustNumbers() {
		//StringUtil stringUtil = new StringUtil();
		String t1 = stringUtil.cleanString("878");
		assertEquals(t1, "878");
		
	}
	

	@Test
	void testcleanStringEmpty() {
		//StringUtil stringUtil = new StringUtil();
		String t1 = stringUtil.cleanString("");
		assertEquals(t1, "");
		
	}
	
	@Test
	void testRemoveDuplicates() {
		
		ArrayList<String> ids =new ArrayList<String>(){{
	        add("7-623");
	        add("8235");
	        add("8-235");
	        add("8-2-35");
	        add("8-235--");
	        add("-8235");
	        add("---^%^%$");
	    }};
		
		
	    ArrayList<String> newids = stringUtil.removeDuplicates(ids);
		assertEquals(newids.get(0), "7623");
		assertEquals(newids.size(), 3);
		
	}
	
	@Test
	void testspecialtyNames() {
		
		ArrayList<String> ids =new ArrayList<String>(){{
			add("7-623");
	        add("8235");
	        add("8-235");
	        add("8-2-35");
	        add("8-235--");
	        add("-8235");
	        add("---^%^%$");
	    }};
	    Map<Integer,String> specialtyNames = new HashMap<Integer, String>(){{
	    	put(1381, "front-end web development"); 
	    	put(8235, "data engineering"); 
	    	put(3434, "API design");
	    	put(7623, "security");
	    	put(3434, "UstringUtil");
	    }};
	    
	    ArrayList<String> y = stringUtil.specialtyNames(ids,  specialtyNames);
	    assertEquals(y.size(), 2 );
	}
	
}

