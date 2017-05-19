package com.alone.servertime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/*
서버와 클라이언트 네트워크 프로그램을 구현해 보겠습니다. 
서버는 ServerSocket 클래스를 이용하며 서버에서 정보를 가져오는 클라이언트는 Socket 을 사용하게 됩니다. 
아래 샘플은 서버에서 클라이언트의 접속을 기다리고 있다가 시간을 알려주는 기능을 합니다. 
 

*/

public class ServerSocket {
	
	 public final static int port = 13;

	public static void main(String[] args) {
		
		ServerSocket server;
        Socket socket = null;
        BufferedWriter writer;
        
        try {
        	/*
        	▼ 시간을 알려주는 서버 프로그램은 ServerSocket 을 사용하게 됩니다. 인수로 넘어간 정보는 포트 번호 입니다. 
			이렇게 서버 객체를 생성한후 while 문을 돌면서 클라이언트의 접속을 기다리게 되는데 server.accept() 함수로 이용합니다. 
			클라이언트 접속이 이루어 지면 accept() 함수는 클라이언트 Socket 을 리턴하게 됩니다. 
			이렇게 읽어들인 Socket 에서 스트림을 가져와 write() 함수로 데이터를 쓰고 flush() 로 보내면 됩니다.
        	*/
            server = new ServerSocket();
            System.out.println("서버 시작");
            while (true) {
                // 클라이언트 요청이 오면 받아들인다.
                socket = server.accept();
                 
                // 직렬화를 위한 바이트 스트림을 가져온다.
                OutputStream os = socket.getOutputStream();
                writer = new BufferedWriter(
                        new OutputStreamWriter(os));
                 
                // 시간을 쓴다.
                Date now = new Date();
                writer.write(now.toString() + "\r\n");
                writer.flush();
                 
                System.out.println(now.toString());
            }
 
        } catch (IOException e) {
            System.out.println(e);
 
        } finally {
            try {
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("서버 종료");
        }

	}

	private Socket accept() {
		
		return null;
	}

}
