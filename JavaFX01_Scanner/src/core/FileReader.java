package core;

import org.apache.log4j.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileReader {
	
	static Logger logger = Logger.getLogger(FileReader.class);
	
	private ArrayList<String> contentList = null;
	private String content = "";

	public FileReader(){
		this.contentList = new ArrayList<String>();
		this.content = "";
	}
	
	public boolean readFile( File file , String resultType ){
		boolean status = false;
		FileInputStream fis = null;
		BufferedReader br = null;
		        
        if( file.exists() ){
        	
			try{
				fis = new FileInputStream(file);
	            br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
	            
	            String temp = "";
	            
	            while( (temp = br.readLine()) != null) {
	            	
	            	if("String".equals(resultType)){
	            		content += temp;
	            	}else if("ArrayList<String>".equals(resultType)){
	            		contentList.add(temp);
	            	}
	            }
	            
	            status = true;
	            
			}catch(Exception e){
				logger.error( e.getMessage() );
				
			}finally {
				try{
					br.close();
				}catch( Exception fe){
					System.out.println( fe.getMessage() );
				}
			}
        }
        
        return status;
	}


	public String getContent() {
		return content;
	}

	public ArrayList<String> getContentList() {
		return contentList;
	}
	
}
