package kun.tools;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class ScannerChoice {
    //添加商品名称
    public static String ScannerString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        return scanner.next();

    }

    //添加商品价格（保留两位小数）
    public static double ScannerInfo(){
        double num = 0.00;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("保留两位小数，请输入：");
            String info = scanner.next();
            String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
            boolean flag = info.matches(regex);
            if (flag){
                num = Double.parseDouble(info);
                break;
            }else{
                System.out.println("输入格式有误，请重新输入！");
                continue;
            }
        }while (true);
        return num;
    }
    //添加商品数量
    public static int ScannerInt(){
        int num = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入：");
            String info = scanner.next();
            String regex = "(([1-9][0-9]*))";
            boolean flag = info.matches(regex);
            if (flag){
                num = Integer.parseInt(info);
                break;
            }else{
                System.out.println("输入格式有误，请重新输入！");
                continue;
            }
        }while (true);
        return num;
    }
}
