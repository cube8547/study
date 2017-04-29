package com.alone.game1;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Graphics;

public class Effect {
 Image[] img;
 int x, y, speed, endframe,type;
 int frame,cnt;
 public Effect(Image[] img, int x, int y, int speed, int endframe, int type){
  this.img = img;
  this.x = x;
  this.y = y;
  this.speed = speed;
  this.endframe = endframe;
  this.type = type;
  frame = 1;
  cnt = 0;
 }
 public void effectDraw(Graphics g, ImageObserver ob){
  g.drawImage(img[frame], x, y, ob);
 }
 public boolean running(){
  cnt++;
  if(cnt%speed==0){
   frame++;
   if(frame==endframe){
    frame = 0;
    return false;
   }
  }
  return true;
 }
 
}


