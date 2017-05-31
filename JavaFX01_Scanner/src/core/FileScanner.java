package core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class FileScanner {
	
	static Logger logger = Logger.getLogger(FileScanner.class);
	
	public static String DIRECTORY = "directory";
	public static String FILE = "file";
	public static String FILE_TXT = "txt";
	public static String [] LOG_FILE_NAME = {"PullLog","HttpLog"};
	private HashMap<String, Integer> mapCounter = new HashMap<String, Integer>();
	
	
	static public String typeOf( File file ){
		String type = null;
		
		if( file.isDirectory() ){
			logger.info( file.getAbsolutePath() + " is directory" );
			type = DIRECTORY;
		}else if( file.isFile() ){
			logger.info( file.getName() + " is file" );
			type = FILE;
		}else{
			logger.warn( "this object is neither directory nor file" );
		}
		
		return type;
	}
	
	public void scanDir( String fileSourceDir , String [] keyWords ){
				
		File sourcefiles = new File( fileSourceDir );
		File [] files = sourcefiles.listFiles();
		
		for( int idx = 0 ; idx < files.length ; idx++ ){
			
			try{
				File file = files[idx];
				
				if( file.isDirectory() ){
					//logger.info( file.getAbsolutePath() + " is directory" );

					logger.info("directory scan >> " + file.getAbsolutePath());
					scanDir( (String)file.getAbsolutePath() , keyWords );	//recursive
				}else if( file.isFile() ){
					//logger.info( file.getName() + " is file" );
					
					String fileName = file.getName();
					String ext = fileName.substring( fileName.lastIndexOf(".") + 1 , fileName.length() );
					
					if( FILE_TXT.equals( ext ) ){
						
						FileReader fileReader;
						//data check
						for( int idy = 0 ; idy<LOG_FILE_NAME.length ; idy++ ){
							if( fileName.matches( LOG_FILE_NAME[idy] + ".*" )){
								logger.debug(">>> " + LOG_FILE_NAME[idy] + " : " + file.getAbsolutePath() + " scan start" + idx);
								
								fileReader = new FileReader();
								fileReader.readFile( file, "ArrayList<String>" );
								
								contextScan( fileReader.getContentList(), file.getAbsolutePath(), keyWords );
								
								logger.debug("<<< " + LOG_FILE_NAME[idy] + " : " + file.getAbsolutePath() + " scan end");
							}
							
						}//end for
					}
					
					
				}else{
					logger.warn( "this object is neither directory nor file" );
				}
				
			}catch( Exception fe ){
				logger.error( fe.getMessage() );
			}
		}//end for
		
	}
	
	private void contextScan( ArrayList<String> list, String filePath, String findWords[] ){
				
		
		for( int idx = 0 ; idx < list.size() ; idx++ ){
			String line = list.get(idx).toLowerCase();
			
			for( int idy = 0 ; idy < findWords.length ; idy++ ){
				
				if( line.matches( ".*" + findWords[idy].toLowerCase() + ".*" ) ){
					
					String fileKey = filePath + " -f " + findWords[idy];
					
					
					logger.info( "[" + idx + "] match : " + findWords[idy] + "_" + line );
					
					if( mapCounter.containsKey( fileKey ) ){
						int count = mapCounter.get( fileKey );
						mapCounter.remove( fileKey );
						mapCounter.put(  fileKey , count+1 );
						
					}else{						
						mapCounter.put(  fileKey , 1 );
					}
					
				}
				
			}//end for
			
		}//for
		
		//logger.debug( mapCounter.toString() );
	}
	
	public HashMap<String, Integer> getMapCounter(){
		return this.mapCounter;
	}
	
	public String toStringMapCounter(){
		
		StringBuilder builder = new StringBuilder();
		
		Set<String> set = mapCounter.keySet();
		Iterator<String> itr = set.iterator();
		while( itr.hasNext() ){
			String key = itr.next();
			int count = this.mapCounter.get(key);
			
			builder.append( "[" + key + "] count : " + count +"\n");
		}
		
		return builder.toString();
	}
	
	
}
