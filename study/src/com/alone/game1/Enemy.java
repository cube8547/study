package com.alone.game1;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Enemy {
 
 Image img;
 int x, y;
 int speed, type;
 
 public Enemy(Image img, int x, int y, int speed, int type){
  this.img = img;
  this.x = x - (img.getWidth(null) / 2);
  this.y = y - (img.getHeight(null) / 2);
  this.speed = speed;
  this.type = type;
 }
 
 public void enemieDraw(Graphics g, ImageObserver ob){
  g.drawImage(img, x, y, ob);
 }
 
 public void enemyMove(){
  switch (type){
  case 1:
   y += speed;
   break;
  case 2:
   y += speed;
   x -= speed;
   break;
  case 3:
   y += speed;
   x += speed;
  }
  
 }
 
}
