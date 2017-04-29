package com.alone.game1;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

abstract public class GCanvas extends Canvas implements Runnable{
 
 public GFrame GFrame;
 
 private boolean roof = true;
 public int fps = 17;
 public int cnt;
 long newFps;
 
 Image dbbuff;
 Graphics gContext;
 
 public GCanvas(GFrame Frame){
  this.GFrame = Frame;
  baseImage();
  systemInit();
 }
 
 public void systemInit(){ // 기본 세팅
  
  roof = true;
  
  Thread th = new Thread(this);
  th.start();
 }
 
 @Override
 public void run(){ // 스레드 런
  
  long sTime;
  long gapTime = fps;
  
  while(roof){
   
   sTime = System.currentTimeMillis();
   this.repaint();
   update();
   cnt++;
   
   gapTime = System.currentTimeMillis() - sTime;
   newFps = (fps-gapTime<0?0:fps-gapTime);
   try{
    Thread.sleep(newFps);
   }catch(Exception e){
   }
  }
 }
 
 public void paint(Graphics g){
  if(gContext==null){
   dbbuff = createImage(GFrame.Screen_Width, GFrame.Screen_Height);
   gContext = dbbuff.getGraphics();
   return;
  }
  update(g);
 }
 public void update(Graphics g){ // 더블 버퍼링
  if(gContext == null) return;
  dbpaint(gContext);
  g.drawImage(dbbuff, 0, 0, this);
  
 }
 
 abstract public void dbpaint(Graphics g);
 abstract public void update();
 
 public void roofStop(){ // 스레드 중지
  roof = false;
 }
 
 public void baseImage(){ }
 public void releaseImage() { }
 public void keyTyped(KeyEvent e){ }
 public void keyPressed(KeyEvent e){ }
 public void keyReleased(KeyEvent e){ }

 
}


