import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("***********************");
        System.out.println("\t1.商品维护");
        System.out.println("\t2.前台收银");
        System.out.println("\t3.商品管理");
        System.out.println("***********************");

        System.out.println("\n请输入选项或者按0退出.");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        do {
            String regex = "[0-3]";
            if(!choice.matches(regex)){
                System.err.println("????");
                System.out.println("请重新选择或按0退出");
            }
            int info = Integer.parseInt(choice);
            switch (info){
                case 0:
                    System.out.println("--------------------");
                    System.out.println("您已经退出系统！");
                    System.exit(1);
                    break;
                case 1:
                    maintenancePage();
                    break;
                case 2:
                    checkstandPage();
                    break;
                case 3:
                    commodityManagementPage();
                    break;
            }
        }while (true);
    }

    public static void maintenancePage(){
        System.out.println("显示商品管理界面\n");
        System.out.println("***********************");
        System.out.println("\t1.添加商品");
        System.out.println("\t2.删除商品");
        System.out.println("\t3.更改商品");
        System.out.println("\t4.查询商品");
        System.out.println("\t5.显示所有商品");
        System.out.println("***********************");
        System.out.println("\n请输入选项或者按0退出.");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        do {
            String regex = "[0-5]";
            if(!choice.matches(regex)){
                System.err.println("????");
                System.out.println("请重新选择或按0退出");
            }
            int info = Integer.parseInt(choice);
            switch (info){
                case 0:
                    System.out.println("--------------------");
                    System.out.println("您已经退出系统！");
                    System.exit(1);
                    break;
                case 1:
                    GoodsPage.addGoodsPage();
                    break;
                case 2:
                    GoodsPage.deleteGoodsPage();
                    break;
                case 3:
                    GoodsPage.updateGoodsPage();
                    break;
                case 4:
                    GoodsPage.queryGoodsPage();
                    break;
                case 5:
                    GoodsPage.dispalyGoodsPage();
                    break;
            }
        }while (true);


    }
    public static void checkstandPage(){
        System.out.println("***********************");
        System.out.println("\t1.登陆\n");
        System.out.println("\t2.退出\n");
        System.out.println("***********************");
    }

    public static void commodityManagementPage(){
        System.out.println("***********************");
        System.out.println("\t1.当日售出商品记录\n");
        System.out.println("\t2.收银员管理\n");
        System.out.println("***********************");
    }
}
