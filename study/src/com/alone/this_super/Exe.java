package com.alone.this_super;


//오버로딩된 다른 생성자 호출하는 방법

/*
▼ this() 는 자기자신의 생성자를 호출함으로서 생성자의 초기화 과정을 반복하지 않아도 됩니다. 
this(x, y) 처럼 파라미터가 있으면 자기 자신의 클래스에 해당하는 동일한 파라미터 객체를 가진 함수를 호출하게 됩니다.
super() 는 상속받은 바로 위 클래스의 생성자를 호출하게 됩니다. 
super(x, y) 는 this 의 파라미터 넘기는 함수처럼 상속받은 클래스에서 동일한 파라미터 객체를 가진 함수를 호출합니다. 
이것이 this 와 super 의 차이점입니다. 주의 할점은 this() 와 super() 는 { 바로 다음에만 쓸 수 있습니다. 그래서 this(), super() 는 같이 쓸 수가 없는 것입니다.
*/

class UpperClass {
    int x;
    int y;
 
    public UpperClass() {
        x = 10;
        y = 20;
    }
 
    public UpperClass(int x) {
        this(); // 자신의 클래스 public UpperClass() 생성자 호출
        this.x = x;
    }
 
    public UpperClass(int x, int y) {
        this(x); // 자신의 클래스 public UpperClass(int x) 생성자 호출
        this.y = y;
    }
}
 
class LowerClass extends UpperClass {
    int r;
 
    public LowerClass() {
        super(); // 상위 클래스의 public UpperClass() 생성자 호출.
        r = 30;
    }
    public LowerClass(int x) {
        super(x); // 상위 클래스의 public UpperClass(int x) 생성자 호출
        r = 30;
    }
 
    public LowerClass(int x, int y) {
        super(x, y); // 상위 클래스의 public UpperClass(int x, int y) 호출
        r = 30;
    }
 
    public LowerClass(int x, int y, int r) {
        this(x, y); // 자신의 클래스 public LowerClass(int x, int y) 호출
        this.r = r;
    }
}


	
	public class Exe {
	public static void main(String[] args) {
		

		
		
	}

}
