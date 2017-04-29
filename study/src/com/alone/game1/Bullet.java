package com.alone.game1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public class Bullet {
 
 Image img;
 int x,  y, speed, type;
 
 public Bullet(Image img, int x, int y, int speed, int type){
  this.img = img;
  this.x = x - (img.getWidth(null) / 2);
  this.y = y - (img.getHeight(null) / 2);
  this.speed = speed;
  this.type = type;
 }
 
 public void bulletDraw(Graphics g, ImageObserver ob){
  g.drawImage(img, x, y, ob);
 }
 
 public void bulletMove(){
  switch(type){
  case 1:
   y -= speed;
   break;
  case 2:
   y += speed;
   break;
  }
 }
 
}

