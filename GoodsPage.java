import kun.entity.Goods;
import kun.entity.dao.GoodsDao;
import kun.tools.ScannerChoice;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public class GoodsPage {
    public static void addGoodsPage(){
        System.out.println("执行添加商品操作：");
        System.out.println("添加商品名称：");
        String goodName = ScannerChoice.ScannerString();
        System.out.println("添加商品价格：");
        double goodPrice = ScannerChoice.ScannerInfo();
        System.out.println("添加商品数量：");
        int goodNumber = ScannerChoice.ScannerInt();
        //加入数据库
        Goods goods = new Goods(goodName, goodPrice, goodNumber);
        new GoodsDao().addGoods(goods);

        System.out.println("是否继续（y/n）：");
        String flag = ScannerChoice.ScannerString();
        if ("y".equals(flag) ){
            addGoodsPage();
        }else{
            MainPage.maintenancePage();
        }
    }
    public static void deleteGoodsPage(){
        System.out.println("执行删除商品操作：");
        System.out.println("输入删除商品名称");
        String goodName = ScannerChoice.ScannerString();
        if (GoodsDao.query(goodName)){
            System.out.println("是否确定删除（y/n）：");
            String flag = ScannerChoice.ScannerString();
            if ("y".equals(flag) ){
                GoodsDao.delete(goodName);
            }
        }
        System.out.println("是否继续删除其他商品（y/n）：");
        String flag2 = ScannerChoice.ScannerString();
        if ("y".equals(flag2) ){
            deleteGoodsPage();
        }else{
            MainPage.maintenancePage();
        }
    }
    public static void updateGoodsPage(){
        System.out.println("执行修改商品操作：");
        System.out.println("请输入需要修改的商品名称：");
        String goodName = ScannerChoice.ScannerString();
        System.out.println("选择您要更改的内容：\n0、返回上一级界面；\n1、更改商品名称；\n2、更改商品价格；\n3.更改商品数量；");
        int info = ScannerChoice.ScannerInt();
        GoodsDao.updata(info);
        System.out.println("是否继续（y/n）：");
        String flag = ScannerChoice.ScannerString();
        if ("y".equals(flag) ){
            updateGoodsPage();
        }else{
            MainPage.maintenancePage();
        }
    }
    public static void queryGoodsPage(){
        System.out.println("执行查询商品操作：");
        System.out.println("0、返回上一级界面；");
        System.out.println("1、按商品数量升序查询");
        System.out.println("2、按商品价格升序查询");
        System.out.println("3、输入关键字查询商品");
        Scanner scanner = new Scanner(System.in);
        int info = Integer.parseInt(scanner.next());
        switch (info) {
            case 0:
                MainPage.maintenancePage();
                break;
            case 1:
                // .addGoodsPage();
                break;
            case 2:
                // GoodsPage.deleteGoodsPage();
                break;
            case 3:
                // GoodsPage.updateGoodsPage();
                break;
        }
        MainPage.maintenancePage();
    }
    public static void dispalyGoodsPage(){
        System.out.println("显示所有商品：");
        System.out.println("商品名称\t商品价格\t商品数量\t备注");
        //数据库操作
        System.out.println("按任意键返回上一层：");
        String flag = ScannerChoice.ScannerString();
        MainPage.maintenancePage();
        }

}
