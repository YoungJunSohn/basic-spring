package com.yj.sample;

//함수형 인터페이스를 구현하기 위한 샘플입니다.
public class FunctionalSample {


    public static void main(String[] args) {

        /*NameAge str = (String name,int age) -> {
            System.out.println("name: "+name+", age: "+age);
        };//추상 메서드 및 함수형 인터페이스 구현*/

        Identification str = (String name,int age)
                ->System.out.println("name: "+name+", age: "+age);//추상 메서드 구현

        str.msg("손영준", 28);//함수형 인터페이스 구현


        DoubleFunction doubleFunction = (int a) -> a*2;
        int a = 7;
        System.out.println( "multiple of "+a+" result : "+doubleFunction.calc(a));

    }//main





        /*(String name, int age) -> {
            System.out.println("name: " +name+", age:"+ age);
        }; //세미콜론 붙여줄 것.
        (String name, int age) ->
                System.out.println("name: " + name +", age:" + age)*/


}
