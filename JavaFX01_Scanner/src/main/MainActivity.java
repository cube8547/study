package main;
import java.io.File;

import org.apache.log4j.*;

import core.FileScanner;
import core.StringUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class MainActivity extends Application{
	
	static Logger logger = Logger.getLogger(MainActivity.class);
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Label lb_text_input01;
	Label lb_text_input02;
	Label lb_text_result01;
	TextField textField01;
	TextField textField02;
	Button btn_click01;
	Button btn_click02;
	
	
	private void initComponent( VBox root ){

		//text
		this.lb_text_result01 = new Label("result");
		this.lb_text_result01.getStyleClass().add("font-size-10px");
		
		//textField
		this.lb_text_input01 = new Label("directory path : ");
		this.textField01 = new TextField ();
		this.textField01.setPrefWidth(800);
		this.lb_text_input02 = new Label("key word : ");
		this.textField02 = new TextField ();
		this.textField02.setPrefWidth(800);
		this.textField02.setText( "error,Send OK,HttpReady" );
		
		HBox hb01 = new HBox();
		hb01.getChildren().addAll(this.lb_text_input01 , this.textField01);
		hb01.setSpacing(10);
		HBox hb02 = new HBox();
		hb02.getChildren().addAll(this.lb_text_input02 , this.textField02);
		hb02.setSpacing(10);
		
		//button
		this.btn_click01 = new Button("scan");
		this.btn_click02 = new Button("open");
		
		//add component
		root.getChildren().add(hb01);
		root.getChildren().add(hb02);
		root.getChildren().add(btn_click01);
		root.getChildren().add(btn_click02);
		root.getChildren().add(lb_text_result01);
	}
	
	private void initActionHandler(final Stage primaryStage ){
		
		this.btn_click01.setOnAction( new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent arg0){
				logger.info("scan button click");
	            fileScan();
			}
		});
		
		this.btn_click02.setOnAction( new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent arg0){
						
				DirectoryChooser dirChooser = new DirectoryChooser();
				File file = dirChooser.showDialog(primaryStage);
				
				if( file != null ){
				
			        String fileType = FileScanner.typeOf(file);
									
					if( FileScanner.DIRECTORY.equals(fileType) ){
						String filePath = file.getAbsolutePath();
						
						logger.info("logger : " + filePath );
						textField01.setText(filePath);
						lb_text_result01.setText(filePath);
						
					}else{
						lb_text_result01.setText("must insert " + FileScanner.DIRECTORY );
					}
				
				}
					
		        
			}
		});
		
		textField01.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent keyEvent) {
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		             logger.info("Enter key in");
		             fileScan();
		        }
		    }
		});
		
	}
	
	@Override
	public void start( Stage primaryStage ) throws Exception {
		VBox root = new VBox();
		
		
		initComponent( root );
		initActionHandler( primaryStage );
		
		
		
		Scene scene = new Scene(root, 1000, 500);
		primaryStage.setScene(scene);		
		
		scene.getStylesheets().add("basic_style.css");
		
		primaryStage.show();
		
	}
	
	
	protected void fileScan(){
		
		String filePath = textField01.getText();
		String keyWords [] = StringUtil.splitAndTrim( textField02.getText() , "," );
		boolean status = true;
		
		//test argument
		if( textField02 == null || textField02.getText().isEmpty() ){
			lb_text_result01.setText("must insert key word" );
			status = false;
		}
		
		if( keyWords == null || keyWords.length <= 0 ){
			lb_text_result01.setText("keyWord error" );
			status = false;
		}
		
		if( status ){
			
			File file = new File( filePath );
			String fileType = FileScanner.typeOf(file);
			
			if( FileScanner.DIRECTORY.equals(fileType) ){
				logger.info("logger : " + filePath );
								
				//scan process
				FileScanner scan = new FileScanner();
				scan.scanDir( filePath , keyWords );
				
				lb_text_result01.setText( scan.toStringMapCounter() );
				
				
			}else{
				lb_text_result01.setText("must insert " + FileScanner.DIRECTORY );
			}
			
		}
	}
	
	
}
