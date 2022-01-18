package org.opentutorials.javatutorials.abstractclass.example3;

abstract class Calculator{
    int left,right ;
    public void setOprands(int _left,int _right) {  // setOprands 는 경우에따라서 달라지지 않기때문에, 상위클래스인 Calculator 에서 기본적으로 정의해둔것.
        this.left = _left; // 10의 값을 가짐
        this.right = _right; // 20의 값을 가짐
    }

    int _sum() { // int 앞에 접근자가 없기때문에 default 제어접근자, 같은 패키지에서만 사용가능.
        return this.left+this.right;
    }

    public abstract void sum();  // 추상(abstract) 클래스
    public abstract void avg();  // 추상(abstract) 클래스
    public void run(){  // run 은 어떤 순서로 메소드를 호출하느냐의 로직.
        sum();
        avg(); // 부모클래스에서 abstract 클래스는 형식만 정의하고 , 경우에 따라 달라지는 직접적인 내용은 하위 클래스에 사용될때 직접 내용을 정의한다.
    }

}

class CalculatorDecoPlus extends Calculator { // 부모(Calculator) 상속
    public void sum(){
        System.out.println("+ sum :" + _sum()); // 하위클래스에서 abstract(추상) 클래스 내용 정의
                                                // 중복 제거를 위해 _sum 메소드 만들어서 사용.
    }
        public void avg(){
        System.out.println("+ avg :" + (this.left+this.right)/2 ); // 하위클래스에서 abstract(추상) 클래스 내용 정의
        }

}

class CalculatorDecoMinus extends Calculator { // 부모(Calculator) 상속
    public void sum(){
        System.out.println("- sum :" + _sum()); // 하위클래스에서 abstract(추상) 클래스 내용 정의
                                                // 중복 제거를 위해 _sum 메소드 만들어서 사용.
    }
    public void avg(){
        System.out.println("- avg :" + (this.left+this.right)/2 ); // 하위클래스에서 abstract(추상) 클래스 내용 정의
    }

}

public class CalculatorDemo {

    public static void main(String[] args) {
        CalculatorDecoPlus c1 = new CalculatorDecoPlus();
        c1.setOprands(10,20);
        c1.run();

        CalculatorDecoMinus c2 = new CalculatorDecoMinus();
        c2.setOprands(10,20);
        c2.run();

    }

}
