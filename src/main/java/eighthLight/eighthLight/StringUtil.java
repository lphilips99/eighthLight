package eighthLight.eighthLight ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtil {

	/*Given an input string, return a new "cleaned-up" string with any non-numeric characters removed. For example:
		an input of: “7-623" should return: "7623"
		and an input of: ”..2965a" should return "2965"
	*/
	public static String cleanString(String str) {
		
		return str == null? "":str.replaceAll("[^0-9]", "");
	}
		
		
	/*
	Given a list of elements (where all elements are of the same type), return a new list with the same elements in
			the same order, but removing duplicates. Preserve the original input - do not mutate it, return a new list instead.
			For example, an input of:
			["a", "b", "c", "a", "b", "d"]
			should return: ["a", "b", "c", "d"]
			and an input of:
			[4, 4, 3, 2, 3, 1]
			should return: [4, 3, 2, 1]
	*/
		
	@SuppressWarnings("serial")
	public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		
	try {
		ArrayList<String> newList = new ArrayList<String>();
			  
		for (String str : list) {
		       if (!newList.contains(str)) {
		            newList.add(cleanString(str));
		        }
		}
		  	 
		 return new ArrayList<String>(newList.stream()
		          .distinct()
		          .collect(Collectors.toList()));
	}catch(Exception e) {
		// log error
		return null;
	}
		
	}
                   
		
/*Given a list of string IDs (possibly with duplicates) and a list of specialties with IDs, return a list of specialty
names, without duplicates, that are represented by the given IDs (after being "cleaned up” by the process from
step one).
For example, given this list of IDs:
["7-623", "8235", "8-235"]
and this list of specialties (the first item being a canonical ID):
[[1381, "front-end web development”],
[8235, "data engineering"],
[3434, "API design"],
[7623, "security"],
[9153, “UX"]]
your code should return:
["security", "data engineering"]
You can assume there are no duplicates in the list of specialties: no ID will appear for multiple specialty areas.
Note that this specialties list should have real numbers as the IDs, not just strings with numeric characters.
*/	
	

@SuppressWarnings("serial")
public static ArrayList<String> specialtyNames(ArrayList<String> ids, Map<Integer,String> specialtyNames ){
	
	ArrayList<String> newIds = removeDuplicates(ids);
	ArrayList<String> uniquespecialties = new ArrayList<String>();
	for(String id : newIds)
	{
		try {
		    if (specialtyNames.containsKey((Integer.parseInt(id)))) {
		    	uniquespecialties.add(specialtyNames.get(Integer.parseInt(id)));
		    	
		    }	
			}catch(NumberFormatException e) {
				// swallow for resultant empty string
			}
	}
	return uniquespecialties;

}
   
    
}
