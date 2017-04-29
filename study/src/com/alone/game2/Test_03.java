package com.alone.game2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

public class Test_03 {
public static void main(String[] ar) {
Test_03_Frame t3f = new Test_03_Frame();
}
}

class Test_03_Frame extends JFrame implements MouseListener,
MouseMotionListener, MouseWheelListener, Runnable {

int x, y; // 마우스의현재좌표
int select_width, select_height;//선택된칩의넓이값
int scroll_y; //좌측칩셋이미지가스크롤될좌표
int rx, ry; //칩셋이미지상에서칩의실제좌표
int f_Width, f_Height; // 프레임크기
int mouse_x, mouse_y; //마우스포인터의현재좌표값
int drag_x, drag_y; // 마우스드래그좌표값

Vector vt = new Vector();
//맵타일데이터

boolean mouse_Click = false;
boolean mouse_Drag = false;
//마우스행동판정

Image img;
BufferedImage bimg;
//이미지불러오기

Image buffImage;
Graphics buffgc;
//더블버퍼링

Thread th;
//스레드

ImageLoad iload;
MapTile mt;
//클래스접근키

Test_03_Frame() {
SystemIinit();
init();
start();
setTitle("테스트");
setSize(f_Width, f_Height);
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
setLocation(xpos, ypos);
setResizable(false);
setVisible(true);
}

public void init() {
Container con = this.getContentPane();
}

public void start() {
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.addMouseListener(this);
this.addMouseMotionListener(this);
this.addMouseWheelListener(this);
th = new Thread (this);
th.start();
}

public void SystemIinit() {
//기본적인설정

f_Width = 1024;
f_Height = 768;
scroll_y = 32;
x = 0;
y = 0;

img = new ImageIcon("chip.png").getImage();
//칩셋이미지를가져옵니다.

iload = new ImageLoad(img);
//잘라내기위한칩셋이미지를미리불러옵니다.

}

public void run(){
while(true){
try{
repaint();
Thread.sleep(20);
}catch(Exception e){}
}
}

public void paint(Graphics g) {

buffImage = createImage(f_Width, f_Height);
buffgc = buffImage.getGraphics();
//더블버퍼링용공간생성

update(g);
}

public void update(Graphics g) {

Draw_Panel();
Draw_Status();
//이미지그리기

g.drawImage(buffImage, 0, 0, f_Width, f_Height, this);
//버퍼에그려진거화면에뿌리기

}
public void Draw_Status(){
//상태정보표시용

buffgc.drawString("x = " + x + ", y = " + y, 700, 50);
buffgc.drawString("ry = " + ry + ", scroll_y = " + scroll_y, 670, 70);

if ( mouse_x > 250 )buffgc.drawImage(bimg, mouse_x / 32 * 32, mouse_y / 32 * 32, select_width, select_height, this);
//마우스포인터따라다니는이미지

}
public void Draw_Panel(){
//이미지그리기

buffgc.drawImage(img, 0, scroll_y, img.getWidth(null),img.getHeight(null), this);
//좌측칩셋이미지그리기

if (mouse_Click) {
//마우스클릭시선택표시용사각형박스그리기

if ( x <= 256 ) buffgc.drawRect(x, y, select_width, select_height);
if ( x > 256 ) buffgc.drawRect(x, y, select_width, select_height);

}

for ( int i = 0 ; i < vt.size() ; ++i){

mt = (MapTile) vt.elementAt(i);
buffgc.drawImage(mt.bimg, mt.x, mt.y, mt.width, mt.height, this);
//객체화된칩셋의이미지를가져와붙여넣습니다.

}

}

public void mouseClicked(MouseEvent e) {
System.out.println("vt size = " + vt.size());
}

public void mousePressed(MouseEvent e) {

x = e.getX() / 32 * 32;
y = e.getY() / 32 * 32;
//마우스버튼이눌려졌을때좌표값을받아냅니다.

if (e.getX() <= 256) {
mouse_Click = true;
}

}

public void mouseReleased(MouseEvent e) {

if (x <= 256) {

ry = Math.abs(scroll_y - y) / 32 * 32;
//칩셋이미지상의실제y좌표 값을계산합니다.

bimg = iload.ImageCrop(x, ry, select_width, select_height);
//선택된칩셋을잘라냅니다.

mouse_Click = false;

} else if ( x > 256 && bimg != null ) {

mt = new MapTile (bimg, x, y, select_width, select_height);
vt.add(mt);
//잘라낸칩셋을객체화시켜그립니다.

}
repaint();

}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseDragged(MouseEvent e) {

mouse_Drag = true;

drag_x = ( e.getX() - x ) / 32 ;
drag_y = ( e.getY() - y ) / 32 ;

if (e.getX() <= 256) {
select_width = ( ( e.getX() - x ) / 32 + 1 ) * 32;
select_height = ( ( e.getY() - y ) / 32 + 1 ) * 32;
}

}
public void mouseMoved(MouseEvent e) {
mouse_x = e.getX();
mouse_y = e.getY();
}
public void mouseWheelMoved(MouseWheelEvent e) {
//칩셋이미지에서휠마우스로이미지스크롤

if (e.getX() <= 256) {
if (scroll_y <= 32) {
scroll_y -= (e.getWheelRotation() * 5) % 32 * 32;
repaint();
}
if (scroll_y > 32) {
scroll_y = 32;
}
}

}
}
class ImageLoad{
//칩셋이미지관리클래스

Image img;
BufferedImage bimg;
BufferedImage cimg;
Graphics gg;

int x, y;
int width, height;

ImageLoad(Image img){
//칩셋이미지를불러와버퍼이미지로변환하여저장

this.img = img;
if ( bimg == null){
bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
gg = bimg.createGraphics();
gg.drawImage(img, 0, 0, null);
gg.dispose();
}
}

public BufferedImage ImageCrop(int x, int y, int width, int height){
//선택된좌표, 넓이를받아와해당하는이미지잘라내서리턴
this.x = x;
this.y = y;
this.width = width;
this.height = height;

if ( width > 0 && height > 0){
cimg = bimg.getSubimage(this.x, this.y, width, height);
} else{
cimg = null;
}

return cimg;

}
}

class MapTile {
//그려질칩셋의정보를객체화하여저장하기위한용도

int x;
int y;
int width;
int height;

BufferedImage bimg;

MapTile(BufferedImage img, int x, int y, int width, int height) {
this.x = x / 32 * 32;
this.y = y / 32 * 32;
this.width = width;
this.height = height;
this.bimg = img;
}

}