package core;

public class StringUtil {
	
	public static String[] splitAndTrim( String originalString, String delimiter ){
		
		String [] returnData = null;
		
		
		if( originalString != null && !originalString.isEmpty() ){
			
			returnData = originalString.split(delimiter);
			
			for( int idx = 0 ; idx < returnData.length ; idx++ ){
				returnData[idx] = returnData[idx].replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
			}
		}
		
		return returnData;
	}
}
