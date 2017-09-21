package kun;

import kun.entity.Salesman;
import kun.tools.ScannerChoice;
import java.util.Scanner;

public class MainPage {
    public static void main(String[] args){
       mainPage();
    }

    public static void mainPage(){
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

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        do {
            String regex = "[0-2]";
            if (!choice.matches(regex)) {
                System.err.println("????");
                System.out.println("请重新选择或按0返回上级界面");
            }
            int info = Integer.parseInt(choice);
            switch (info) {
                case 0:
                    mainPage();
                    break;
                case 1:
                    boolean flag = false;
                    for (int count = 3; count > 0; count--){
                        System.out.println("请输入用户名：");
                        String name = ScannerChoice.ScannerString();
                        System.out.println("请输入密码：");
                        String password = ScannerChoice.ScannerString();
                        if (flag = true){
                            GsalePage.shoppingSettlementPage();
                            break;
                        }else {
                            if (count>1)
                                System.out.println("用户名或密码输入错误！请重新输入！您还有"+(count-1)+"次机会");
                            else{
                                System.out.println("用户名或密码输入错误！");
                                System.out.println("--------------------");
                                System.out.println("您已经退出系统！");
                                System.exit(1);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("--------------------");
                    System.out.println("您已经退出系统！");
                    System.exit(1);
                    break;
            }
        }while(true);
    }

    public static void commodityManagementPage() {
        System.out.println("***********************");
        System.out.println("\t1.当日售出商品记录");
        System.out.println("\t2.收银员管理");
        System.out.println("***********************");
        System.out.println("\n请输入选项或者按0返回.");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        do {
            String regex = "[0-2]";
            if (!choice.matches(regex)) {
                System.err.println("????");
                System.out.println("请重新选择或按0返回上级界面");
            }
            int info = Integer.parseInt(choice);
            switch (info) {
                case 0:
                    mainPage();
                    break;
                case 1:

                case 2:
                    SalesmanPage.Salesman();
            }
        }while (true);
    }
}