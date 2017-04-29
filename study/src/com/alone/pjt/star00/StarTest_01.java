package com.alone.pjt.star00;

/*첫번째, 그림과 같이 별의 다섯 꼭지점은 원에 내접한다.
두번째, 각 꼭지점 간격은 동일하다.
이 두가지를 통해 중요한 정보를 하나 얻을수 있습니다.
원은 360도 이며, 각 꼭지점간은 72도씩 입니다.
그럼 x,y좌표선과 꼭지점이 이루는 각을 알 수 있습니다.
직각은 90도 이므로, 각 꼭지점은 72도씩 이므로 뺄셈만 해보면 나머지를 알 수 있습니다.
그럼 이 계산된 각도가 중요합니다. 이각도를 가지고 삼각함수를 통해 코사인, 사인값을 구해내야 합니다.
사인,코사인 구하는 메서드는 자바 Math 클래스에서 제공하므로 계산하실 필요는 없고, 구하는 공식만 생각하시면 됩니다.
사용되는 메서드는

Math.sin()
Math.cos()
Math.toRadians()

마지막 toRadians() 메서드는 일반 각(0~360도)을 라디안 값으로 변환해주는데, sin(), cos() 메서드는 라디안 값을 인자로 입력받습니다.
따라서 각을 그대로 사용하지 말고 라디안값으로 변환한후 사용하도록 합니다.
삼각함수는 수학공부라 여기서는 이정도만 이야기 하구요^^ 나머지도 삼각함수를 통해 좌표값을 구하도록 합니다.
그런데 여기에서 주의할 점이 있습니다. 삼각함수를 구할때 사용한 기준점과 실제 화면에서 출력해야할 좌표기준이 다르다는 점입니다.
위에서 구한 좌표값은 위 그림에서와 같이 x,y좌표상의 원점이 기준이지만 화면에 출력하고자 하는 경우에는 좌상단이 0,0 기준점이 됩니다.
따라서 이관계를 잘 따져서 x,y 좌표값을 구하도록 햐며, 저 원점 기준으로 구하게 되면 양수와 음수가 나오게 됩니다.
이부분을 스크린에 0,0 부터 출력이 되게 하도록 하기 위하여 translate() 메서드를 통해 원점위치값을 변경하였습니다.
말로 설명하려니 너무 어렵네요.
아래 소스 참고하시고, 직접 좌표값을 변경해가면서 테스트 해보는게 가장 좋을듯 합니다*/

/*import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class StarTest_01 extends JComponent{
	
	int r = 100;
	int[] x = new int[5];
	int[] y = new int[5];
	
	public StarTest_01(){
		
		x[0] = 0;
		y[0] = -r;
		
		x[1] = (int)( Math.cos(Math.toRadians(54)) * r);
		y[1] = (int)( Math.sin(Math.toRadians(54)) * r);
		
		x[2] = (int)( Math.cos(Math.toRadians(18)) * r) * -1;
		x[2] = (int)( Math.sin(Math.toRadians(18)) * r) * -1;
		
		x[3] = x[2] * -1;
		y[3] = y[2];
		
		x[4] = x[1] * -1;
		y[4] = y[1];
	
	}	
	
	public void paintComponent(Graphics g){
		g.translate(r, r);
		g.setColor(Color.red);
		g.drawPolygon(x, y, x.length);
		
		g.setColor(Color.blue);
		g.drawOval(-r, -r, r*2, r*2);
		
	}
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("http://star.pe.kr/tc");
		f.setBounds(0, 0, 250, 260);
		f.add(new StarTest_01());
		f.setVisible(true);


	}

}
*/

import java.util.*;
import java.awt.*;
import javax.swing.*;

class StarTest_01 extends  JComponent
{
	int r = 100;
	int[] x = new int[5];
	int[] y = new int[5];

	public StarTest_01(){
		
		x[0] = 0;
		y[0] = -r;
		
		x[1] = (int)( Math.cos(Math.toRadians(54)) * r );
		y[1] = (int)( Math.sin(Math.toRadians(54)) * r ) ;

		x[2] = (int)( Math.cos(Math.toRadians(18)) * r ) * -1;  //
		y[2] = (int)( Math.sin(Math.toRadians(18)) * r )* -1;

		
		x[3] = x[2] * -1;
		y[3] = y[2];

		x[4] = x[1] * -1;
		y[4] = y[1];


	
	}
	public void paintComponent(Graphics g){
		g.translate(r,r);	
		g.setColor(Color.red);
		g.drawPolygon(x,y,x.length);

		g.setColor(Color.blue);
		g.drawOval(-r,-r,r*2,r*2);
	}

	public static void main(String[] args){

		JFrame f = new JFrame("http://star.pe.kr/tc");
		f.setBounds(0,0,250,260);
		f.add(new StarTest_01());
		f.setVisible(true);
	}
}