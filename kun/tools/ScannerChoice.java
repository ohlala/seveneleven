package kun.tools;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class ScannerChoice {
    //添加商品名称

    //添加商品价格（保留两位小数）
    public static double ScannerInfo(){
        double num = 0.00;
        Scanner scanner = new Scanner(System.in);
        System.out.println("保留两位小数，请输入：");
        String info = scanner.next();
        String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
    }
    //添加商品数量

}
