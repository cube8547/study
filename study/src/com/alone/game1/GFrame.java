package com.alone.game1;

import java.awt.Frame;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GFrame extends Frame implements KeyListener{
	public static int Screen_Width = 600; //프레임 넓이
	public static int Screen_Height = 1000; //프레임 높이
	
	GCanvas GCanvas;
	
	GFrame() {
	setTitle("Test"); //프레임 타이틀
	setSize(Screen_Width, Screen_Height); //프레임 크기
	
	 setResizable(false); //프레임 크기 조절 불가능
	  setLocationRelativeTo(null); //프레임을 화면 중간에 배치
	  setVisible(true); //프레임을 보이게 표시
	  addWindowListener(new WindowAdapter(){ //프레임 x버튼으로 닫으면 시스템 종료.
	   public void windowClosing(WindowEvent e){
	    Window wnd = e.getWindow();
	    wnd.setVisible(false);
	    wnd.dispose();
	    System.exit(0);
	   }
	  });
	  GFrameInit();
	 }
	 
	 public void GFrameInit(){ // 기본 구성 정의 메소드
	  GMain gm = new GMain(this);
	  gm.setBounds(0, 0, Screen_Width, Screen_Height);
	  add(gm);
	  
	  addKeyListener(this);
	 }
	 
	 public Image makeImages(String st){ // 이미지 생성 메소드
	  System.out.println("Image File name : " + st);
	  
	  Image img;
	  Toolkit tk = Toolkit.getDefaultToolkit();
	  img = tk.getImage(st);
	  try{
	   MediaTracker mt = new MediaTracker(this);
	   mt.addImage(img, 0);
	   mt.waitForID(0);
	  }catch(Exception ee){
	   ee.printStackTrace();
	   return null;
	  }
	  
	  return img;

	 }
	 
	 public boolean crashCheck(int object_x1, int object_y1, int object_x2, int object_y2, Image object_img1, Image object_img2){
	  // 충돌 판정
	  boolean crashcheck = false;
	  int check_x = Math.abs((object_x1 + object_img1.getWidth(null)/2) - (object_x2+object_img2.getWidth(null)/2));
	  int base_x = Math.abs(object_img1.getWidth(null)/2 + object_img2.getWidth(null)/2);
	  int check_y = Math.abs((object_y1 + object_img1.getHeight(null)/2) - (object_y2+object_img2.getHeight(null)/2));
	  int base_y = Math.abs(object_img1.getHeight(null)/2 + object_img2.getHeight(null)/2);
	  if( check_x < base_x && check_y < base_y ){
	   crashcheck = true;
	  }else{
	   crashcheck = false;
	  }
	  return crashcheck;
	 }
	 
	 public Point imageCoordinate(Image img, int x, int y){ // 이미지 중심좌표 계산
	  Point coordinatePos = new Point (x, y);
	  coordinatePos.x = coordinatePos.x + (img.getWidth(this) / 2);
	  coordinatePos.y = coordinatePos.y + (img.getHeight(this) / 2);
	  return coordinatePos;
	 }
	 
	 public BufferedImage[] cropImage(String str, int row, int column, int width, int height){
	  // 이미지 잘라내서 배열로 리턴
	  BufferedImage bimg = null;
	  try{
	   bimg = ImageIO.read(new File(str));
	  }catch(Exception e){
	   e.printStackTrace();
	  }
	  BufferedImage[] cropimg = new BufferedImage[row*column];
	  for(int i = 0; i < row; i ++){
	   for(int j = 0; j < column; j ++){
	    cropimg[i*column+j] = bimg.getSubimage(j*width, i*height, width, height);
	   }
	  }
	  return  cropimg;
	 }
	 
	 public void keyTyped(KeyEvent e){
	  GCanvas.keyTyped(e);
	 }
	 public void keyPressed(KeyEvent e){
	  GCanvas.keyPressed(e);
	  
	 }
	 public void keyReleased(KeyEvent e){
	  GCanvas.keyReleased(e);
	 }

	 
	}
