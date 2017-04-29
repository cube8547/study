package com.alone.game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.CropImageFilter;
import java.util.Vector;
import java.awt.Point;


public class GMain extends GCanvas {
 
 public final static int Up_Key = 0x001;  // 16진수 - 2진수로 1
 public final static int Down_Key = 0x002; // 16진수 - 2진수로 10
 public final static int Left_Key = 0x004; // 16진수 - 2진수로 100
 public final static int Right_Key = 0x008; // 16진수 - 2진수로 1000
 public final static int Fire_Key = 0x010; // 16진수 - 2진수로 1 0000
 public final static int num1_Key = 0x020;// 16진수 - 2진수로 10 0000
 public final static int num2_Key = 0x040;// 16진수 - 2진수로 100 0000
 public final static int num3_Key = 0x080;// 16진수 - 2진수로 1000 0000
 
 Image playerImage;
 Image bulletImage;
 Image enemyImage;
 Image backGround_1;
 Image backGround_2;
 Image[] effectImage;
 
 Point playerPos; // 플레이어 좌표
 int pSpeed; // 플레이어 이동 속도
 int player_Hp; //플레이어 히트포인트
 int weaponType; //플레이어 무기 종류
 int bgSpeed; // 백그라운드 스크롤 속도
 
 int backGround_1y, backGround_2y;
 
 int keyBuff; // 키 입력 버퍼
 int fcnt; // 플레이어 미사일 카운터
 int efcnt; // 적 미사일 카운터
 
 boolean isFire;
 boolean pwChange;
 
 Vector bullets;
 Vector enemies;
 Vector effects;
 
 public GMain(GFrame GFrame){
  super(GFrame);
  GFrame.GCanvas = (GCanvas) this;
 }
 
 @Override
 public void systemInit(){
  cnt = 0;
  playerPos = new Point(100, 600);
  pSpeed = 7;
  player_Hp = 10;
  weaponType = 0;
  bgSpeed = 5;
  
  backGround_1y = GFrame.Screen_Height-backGround_1.getHeight(null);
  backGround_2y = GFrame.Screen_Height-(backGround_1.getHeight(null)*2)+50;
  
  keyBuff = 0;
  fcnt = 0;
  efcnt = 0;
  
  isFire = false;
  
  bullets = new Vector();
  bullets.clear();
  enemies = new Vector();
  enemies.clear();
  effects = new Vector();
  effects.clear();
  
  super.systemInit();
 }
 
 @Override
 public void baseImage(){
  playerImage = GFrame.makeImages("Ship.png");
  bulletImage = GFrame.makeImages("bullet.png");
  enemyImage = GFrame.makeImages("Enemy.png");
  backGround_1 = GFrame.makeImages("space.png");
  backGround_2 = GFrame.makeImages("space.png");
  effectImage = GFrame.cropImage("Effect.png", 1, 6, 40, 40);
 }
 
 @Override
 public void dbpaint(Graphics g) {
  g.fillRect(0, 0, GFrame.Screen_Width, GFrame.Screen_Height); // 배경 화면 예시
  g.drawImage(backGround_1, 0, backGround_2y, this);
  g.drawImage(backGround_1, 0, backGround_1y, this);
  g.drawImage(playerImage, playerPos.x, playerPos.y, this); // 플레이어 이미지 그리기
  
  Bullet bl;
  for (int i = 0 ; i < bullets.size(); i++){ // 미사일 이미지 그리기
   bl = (Bullet) bullets.elementAt(i);
   bl.bulletDraw(g, this);
  }
  
  Enemy em;
  for (int i = 0; i < enemies.size(); i++){ // 적 이미지 그리기
   em = (Enemy) enemies.elementAt(i);
   em.enemieDraw(g, this);
  }
  
  Effect ef;
  for (int i = 0; i < effects.size(); i++){ // 이펙트 그리기
   ef = (Effect) effects.elementAt(i);
   ef.effectDraw(g, this);
  }
  

  //테스트용 텍스트
  g.setColor(Color.white); // 텍스트 컬러
  g.drawString("Thread Count = " + cnt, 10, 40);
  g.drawString("Fire Count = " + fcnt, 10, 60);
  g.drawString("Enemy Fire Count = " + efcnt, 10, 80);
  g.drawString("Bullet Size = " + bullets.size(), 10, 100);
  g.drawString("Enemy Size = " + enemies.size(), 10, 120);
  g.drawString("Effect Size = " + effects.size(), 10, 140);
  g.drawString("FPS = " + (1000 / GFrame.GCanvas.newFps) , 10, 160);
  
  g.drawString("HP = " + player_Hp, 420, 40);
  
  g.drawString("WeaponType = " + weaponType, 250, 950);
  //테스트용 텍스트
  
 }

 @Override
 public void update() {
  kProcess();
  playerProcess();
  bulletProcess();
  enemyProcess();
  crashProcess();
  effectProcess();
  backgroundProcess();
 }
 

 
 @Override
 public void releaseImage(){
  playerImage = null;
  bulletImage = null;
  enemyImage = null;
  backGround_1 = null;
  backGround_2 = null;
 }
 
 public void backgroundProcess(){
  if(backGround_1y < GFrame.Screen_Height){
   backGround_1y += bgSpeed;
  }else{
   backGround_1y = -(backGround_1.getHeight(null) + 50);
  }
  if(backGround_2y < GFrame.Screen_Height){
   backGround_2y += bgSpeed;
  }else{
   backGround_2y = -(backGround_2.getHeight(null) + 50);
  }
  
 }
 
 public void bulletProcess(){
  Bullet bl;
  for(int i = 0 ; i < bullets.size(); i++){ // 미사일 이동 처리
   bl = (Bullet) bullets.elementAt(i);
   bl.bulletMove();
   if(bl.y < 0) {
    bullets.remove(i);
   }else if (bl.y > GFrame.Screen_Height) {
    bullets.remove(i);
   }
  }
 }
 
 public void enemyProcess(){
  Enemy em;
  
  if (cnt % 200 == 0){//적 케릭터 생성
   for (int i = 1; i < 6 ; i++){
    em = new Enemy(enemyImage, (GFrame.Screen_Width / 6) * i, 0, 3, 1);
    enemies.add(em);
   }
  }else if (cnt % 30 == 0){//적 케릭터 생성2
   em = new Enemy(enemyImage, GFrame.Screen_Width, 0, 3, 2);
   enemies.add(em);
   em = new Enemy(enemyImage, 0, 0, 3, 3);
   enemies.add(em);
  }
  
  
  for(int i = 0 ; i < enemies.size(); i++){ //적 케릭터 이동
   em = (Enemy) enemies.elementAt(i);
   em.enemyMove();
   
   Point _empos;
   _empos = GFrame.imageCoordinate(enemyImage, em.x, em.y);
   _empos.y += em.img.getHeight(null) / 2 ;
   
   if (efcnt%50 ==0){ // 적 케릭터 미사일 생성
    Bullet bl = new Bullet(bulletImage, _empos.x, _empos.y, 10, 2);
    bullets.add(bl);
   }
   
   if(em.y > GFrame.Screen_Height) enemies.remove(i);//적이 화면 밖으로 나가면 리무브
  }
  if(efcnt > 1000) efcnt = 0;
  efcnt ++;
 }

 public void crashProcess(){
  Bullet bl;
  Enemy em;
  Effect ef;
  
  for(int i = 0; i < enemies.size(); i++){
   em = (Enemy) enemies.elementAt(i);
   for(int j = 0; j < bullets.size(); j++){
    bl = (Bullet) bullets.elementAt(j);
    if(GFrame.crashCheck(bl.x, bl.y, em.x, em.y, bl.img, em.img)&&bl.type==1){
     //적과 플레이어 미사일 충돌
     enemies.remove(i);
     bullets.remove(j);
     ef = new Effect(effectImage, em.x,
       em.y + (enemyImage.getHeight(null)-effectImage[0].getHeight(null))/2, 7, 6, 1);
     effects.add(ef);
    }else if(GFrame.crashCheck(bl.x, bl.y, playerPos.x, playerPos.y, bl.img, playerImage)&&bl.type==2){
     //플레이어와 적 미사일 충돌
     bullets.remove(j);
     player_Hp --;
     ef = new Effect(effectImage, playerPos.x, 
       playerPos.y + (playerImage.getHeight(null)-effectImage[0].getHeight(null))/2, 7, 6, 0);
     effects.add(ef);
    }
   }
   if(GFrame.crashCheck(playerPos.x, playerPos.y, em.x, em.y, playerImage, em.img)){
    //플레이어와 적 충돌
    enemies.remove(i);
    player_Hp --;
    ef = new Effect(effectImage, playerPos.x, 
      playerPos.y + (playerImage.getHeight(null)-effectImage[0].getHeight(null))/2, 7, 6, 0);
    effects.add(ef);
    ef = new Effect(effectImage, em.x, 
      em.y +(enemyImage.getHeight(null)-effectImage[0].getHeight(null))/2, 7, 6, 1);
    effects.add(ef);
    
   }
  }
  
 }
 
 public void effectProcess(){
  Effect ef;
  for(int i = 0 ; i < effects.size(); i++){
   ef = (Effect) effects.elementAt(i);
   if(ef.type==0){
    ef.x = playerPos.x;
    ef.y = playerPos.y+(playerImage.getHeight(null)-effectImage[0].getHeight(null))/2;
   }
   if(!ef.running()){
    effects.remove(i);
   }
  }
 }
 
 public void playerProcess(){
  Bullet bl;
  if(isFire){
   switch(weaponType){
   case 0:
    if (fcnt % 10 == 0){ // 플레이어 미사일 생성
     bl = new Bullet(bulletImage, playerPos.x + (playerImage.getWidth(this) / 2), playerPos.y, 10, 1);
     bullets.add(bl);
     isFire = false;
    }
    break;
   case 1:
    if (fcnt % 10 == 0){ // 플레이어 미사일 생성
     bl = new Bullet(bulletImage, playerPos.x + 13, playerPos.y, 10, 1);
     bullets.add(bl);
     bl = new Bullet(bulletImage, playerPos.x + 25, playerPos.y, 10, 1);
     bullets.add(bl);
     isFire = false;
    }
    break;
   case 2:
    if (fcnt % 10 == 0){ // 플레이어 미사일 생성
     bl = new Bullet(bulletImage, playerPos.x + 10, playerPos.y, 10, 1);
     bullets.add(bl);
     bl = new Bullet(bulletImage, playerPos.x + 19, playerPos.y, 10, 1);
     bullets.add(bl);
     bl = new Bullet(bulletImage, playerPos.x + 28, playerPos.y, 10, 1);
     bullets.add(bl);
     isFire = false;
    }
    break;
   }
   fcnt ++;
   if (fcnt > 1000) fcnt = 0;
  }
 }
 
 public void kProcess(){
  
  if((keyBuff&Up_Key) == Up_Key)  playerPos.y -= pSpeed;
  if((keyBuff&Down_Key) == Down_Key) playerPos.y += pSpeed;
  if((keyBuff&Left_Key) == Left_Key) playerPos.x -= pSpeed;
  if((keyBuff&Right_Key) == Right_Key) playerPos.x += pSpeed;
  if((keyBuff&Fire_Key) == Fire_Key) isFire = true;
  if((keyBuff&num1_Key) == num1_Key) weaponType = 0;
  if((keyBuff&num2_Key) == num2_Key) weaponType = 1;
  if((keyBuff&num3_Key) == num3_Key) weaponType = 2;
  
  /*
  switch(keyBuff){
  case Up_Key:
   playerPos.y -= pSpeed;;
   break;
  case Down_Key:
   playerPos.y += pSpeed;
   break;
  case Left_Key:
   playerPos.x -= pSpeed;
   break;
  case Right_Key:
   playerPos.x += pSpeed;
   break;
  case Right_Key|Up_Key: // 대각선 이동
   playerPos.x += pSpeed;
   playerPos.y -= pSpeed;
   break;
  case Right_Key|Down_Key:
   playerPos.x += pSpeed;
   playerPos.y += pSpeed;
   break;
  case Left_Key|Up_Key:
   playerPos.x -= pSpeed;
   playerPos.y -= pSpeed;
   break;
  case Left_Key|Down_Key:
   playerPos.x -= pSpeed;
   playerPos.y += pSpeed;
   break;
  case Fire_Key:
   isFire = true;
   break;
  case Fire_Key|Up_Key:
   playerPos.y -= pSpeed;;
   isFire = true;
   break;
  case Fire_Key|Down_Key:
   playerPos.y += pSpeed;
   isFire = true;
   break;
  case Fire_Key|Left_Key:
   playerPos.x -= pSpeed;
   isFire = true;
   break;
  case Fire_Key|Right_Key:
   playerPos.x += pSpeed;
   isFire = true;
   break;
  case Fire_Key|Right_Key|Up_Key:
   playerPos.x += pSpeed;
   playerPos.y -= pSpeed;
   isFire = true;
   break;
  case Fire_Key|Right_Key|Down_Key:
   playerPos.x += pSpeed;
   playerPos.y += pSpeed;
   isFire = true;
   break;
  case Fire_Key|Left_Key|Up_Key:
   playerPos.x -= pSpeed;
   playerPos.y -= pSpeed;
   isFire = true;
   break;
  case Fire_Key|Left_Key|Down_Key:
   playerPos.x -= pSpeed;
   playerPos.y += pSpeed;
   isFire = true;
   break;
  }
  */
 }
 
 @Override
 public void keyPressed(KeyEvent e){
  switch(e.getKeyCode()){
  case KeyEvent.VK_UP:
   keyBuff |= Up_Key;
   break;
  case KeyEvent.VK_DOWN:
   keyBuff |= Down_Key;
   break;
  case KeyEvent.VK_LEFT:
   keyBuff |= Left_Key;
   break;
  case KeyEvent.VK_RIGHT:
   keyBuff |= Right_Key;
   break;
  case KeyEvent.VK_S:
   keyBuff |= Fire_Key;
   break;
  case KeyEvent.VK_1:
   keyBuff |= num1_Key;
   break;
  case KeyEvent.VK_2:
   keyBuff |= num2_Key;
   break;
  case KeyEvent.VK_3:
   keyBuff |= num3_Key;
   break;
  default :
   break;
  }
 }
 
 @Override
 public void keyReleased(KeyEvent e){
  switch(e.getKeyCode()){
  case KeyEvent.VK_UP:
   keyBuff &= ~Up_Key;
   break;
  case KeyEvent.VK_DOWN:
   keyBuff &= ~Down_Key;
   break;
  case KeyEvent.VK_LEFT:
   keyBuff &= ~Left_Key;
   break;
  case KeyEvent.VK_RIGHT:
   keyBuff &= ~Right_Key;
   break;
  case KeyEvent.VK_S:
   keyBuff &= ~Fire_Key;
   break;
  case KeyEvent.VK_1:
   keyBuff &= ~num1_Key;
  case KeyEvent.VK_2:
   keyBuff &= ~num2_Key;
   break;
  case KeyEvent.VK_3:
   keyBuff &= ~num3_Key;
   break;
  }
 }
 
}

