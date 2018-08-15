package com.battcn;

import java.util.Scanner;


public class BattcnFeignHelloApplicationTests {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//创建输入流
        String strs[] = new String[5];//定义一个长度为5的字符串数组
        //List<String> list = new ArrayList<>();//定义接收集合
        String list[] = new String[strs.length];
        System.out.println("请输入5位学生姓名");
        for (int i = 0; i < strs.length; i++) {//循环输入5个姓名。
            //list.add(input.next());
            list[i] = input.next();
        }
        System.out.print("请输入需要检查的学生：");
        String studentName = input.next();
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(studentName)) {//检查数组中是否有这个人的姓名
                System.out.println(studentName + "的坐标：" + i);//输出下标
            }
        }
    }

}
