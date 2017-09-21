package kun;

import kun.entity.Salesman;
import kun.entity.dao.GoodsDao;
import kun.entity.dao.SalesmanDao;
import kun.tools.ScannerChoice;

import java.util.Scanner;

import static kun.MainPage.commodityManagementPage;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public class SalesmanPage {
    public static void Salesman(){
        System.out.println("***********************");
        System.out.println("\t1.添加售货员");
        System.out.println("\t2.删除售货员");
        System.out.println("\t3.更改售货员");
        System.out.println("\t4.查询售货员");
        System.out.println("\t5.显示所有售货员");
        System.out.println("***********************");
        System.out.println("\n请输入选项或者按0返回.");
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
                    commodityManagementPage();
                    break;
                case 1:
                    addSalesmanPage();
                    break;
                case 2:
                    deleteSalesmanPage();
                    break;
                case 3:
                    updateSalesmanPage();
                    break;
                case 4:
                    querySalesmanPage();
                    break;
                case 5:
                    dispalySalesmanPage();
                    break;
            }
        }while (true);

    }
    public static void addSalesmanPage(){
        System.out.println("执行售货员操作：");
        System.out.println("添加售货员姓名：");
        String SalesmanName = ScannerChoice.ScannerString();
        System.out.println("添加售货员密码：");
        String SalesmanPwd = ScannerChoice.ScannerString();
        //加入数据库
        Salesman salesman = new Salesman(SalesmanName, SalesmanPwd);
        new SalesmanDao().addSalesman(salesman);

        System.out.println("是否继续（y/n）：");
        String flag = ScannerChoice.ScannerString();
        if ("y".equals(flag) ){
            addSalesmanPage();
        }else{
            SalesmanPage.Salesman();
        }
    }
    public static void deleteSalesmanPage(){
        System.out.println("执行删除售货员操作：");
        System.out.println("输入删除售货员名称");
        String salesmanName = ScannerChoice.ScannerString();
        if (SalesmanDao.query(salesmanName)){
            System.out.println("是否确定删除（y/n）：");
            String flag = ScannerChoice.ScannerString();
            if ("y".equals(flag) ){
                SalesmanDao.delete(salesmanName);
            }
        }
        System.out.println("是否继续删除其他商品（y/n）：");
        String flag2 = ScannerChoice.ScannerString();
        if ("y".equals(flag2) ){
            deleteSalesmanPage();
        }else{
            SalesmanPage.Salesman();
        }
    }
    public static void updateSalesmanPage(){
        System.out.println("执行修改售货员操作：");
        System.out.println("请输入需要修改的售货员：");
        String salesmanName = ScannerChoice.ScannerString();
        if (SalesmanDao.query(salesmanName)) {
            System.out.println("选择您要更改的内容：\n0、返回上一级界面；\n1、更改姓名；\n2、更改密码；");
            int info = ScannerChoice.ScannerInt();
            SalesmanDao.updata(info, salesmanName);
        }
        System.out.println("是否继续（y/n）：");
        String flag = ScannerChoice.ScannerString();
        if ("y".equals(flag) ){
            updateSalesmanPage();
        }else{
            SalesmanPage.Salesman();
        }
    }
    public static void querySalesmanPage(){
        System.out.println("执行查询商品操作：");
        System.out.println("输入关键字查询售货员");
        String info = ScannerChoice.ScannerString();
        SalesmanDao.querySalesman(info);
        SalesmanPage.Salesman();
    }
    public static void dispalySalesmanPage(){
        System.out.println("显示所有商品：");
        SalesmanDao.dispaly();
        SalesmanPage.Salesman();
    }

}
