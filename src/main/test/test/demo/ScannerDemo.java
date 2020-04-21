package test.demo;

import java.util.Scanner;

/**
 * @author ghj
 * @Description
 * @date 2020/3/26 10:58
 */
public class ScannerDemo {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入");
            System.out.println("out:" + scanner.nextLine());
        }
    }
}
