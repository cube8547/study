package com.alone.servertime;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
클라이언트에서는 서버에 접속해서 데이터를 가져 오기 위해 Socket 클래스를 사용합니다. 
Socket 객체를 만들 때 서버에 접속해야 하므로 IP 와 포트정보를 넘깁니다. 
이때 서버에서는 accpet() 함수가 동작하게 되는 것이죠. getInputStream() 을 이용해서 스트림을 가져온후 데이터를 읽어 들이면 됩니다.

*/
public class ClientSocket {
	
	 private Frame mainFrame;
	    public Label headerLabel;
	    public Label statusLabel;
	 
	    public ClientSocket() {
	        prepareGUI();
	    }
	

	public static void main(String[] args) {
		
		ClientSocket client = new ClientSocket();
		 
        // 서버로 부터 시간 가져오기
        Socket theSocket = null;
        String host = "localhost";
        int port = 13;
        InputStream is;
        BufferedReader reader;
 
        try {
            theSocket = new Socket(host, port);
            is = theSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String time = reader.readLine();
             
            // UI 값 셋팅
            client.statusLabel.setText(time);
 
        } catch (UnknownHostException e) {
            System.out.println(args[0] + "호스트를 찾을 수 없음");
 
        } catch (IOException e) {
            System.err.println(e);
             
        } finally {
            try {
                if (theSocket != null){
                    theSocket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
 
    }
	
	/*
▼ 클라이언트는 AWT 를 이용해서 화면을 구성
아래 함수는 Frame 에 제목과 서버에서 가져온 시간을 표현할 Label 을 추가한 소스 입니다. 
소켓에서 시간을 가져온후 statusLabel 라벨 객체에 값을 셋팅하시면 되겠죠.
 */
    private void prepareGUI() {
        // Frame 에 대한 셋팅
        mainFrame = new Frame("Java AWT Label 샘플");
        mainFrame.setSize(300, 150);
        mainFrame.setLayout(new GridLayout(2, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
 
        // 상단에 있는 라벨
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        headerLabel.setText("[ Server Time ]");
 
        statusLabel = new Label();
        statusLabel.setText("");
        statusLabel.setAlignment(Label.CENTER);
 
        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);		
		

	}

}
