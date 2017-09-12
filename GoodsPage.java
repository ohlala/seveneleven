import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public class GoodsPage {
    public static void addGoodsPage(){
        System.out.println("执行添加商品操作：");
        System.out.println("添加商品名称");
        System.out.println("添加商品价格");
        System.out.println("添加商品数量");
        System.out.println("是否继续（y/n）：");
    }
    public static void deleteGoodsPage(){
        System.out.println("执行删除商品操作：");
        System.out.println("输入删除商品名称");
        System.out.println("商品名称\t商品价格\t商品数量");
        System.out.println("是否确定删除（y/n）：");
        System.out.println("是否继续（y/n）：");
    }
    public static void updateGoodsPage(){
        System.out.println("执行修改商品操作：");
        System.out.println("请输入需要修改的商品名称：");
        System.out.println("选择您要更改的内容：\n1、更改商品名称；\n2、更改商品价格；\n3.更改商品数量；");


        System.out.println("添加商品数量");
        System.out.println("是否继续（y/n）：");
    }
    public static void queryGoodsPage(){
        System.out.println("执行查询商品操作：");
        System.out.println("1、按商品数量升序查询");
        System.out.println("2、按商品价格升序查询");
        System.out.println("3、输入关键字查询商品");
        System.out.println("\n请输入选项或者按0返回上级菜单.");
    }
    public static void dispalyGoodsPage(){
        System.out.println("显示所有商品：");
        System.out.println("商品名称\t商品价格\t商品数量\t备注");
        System.out.println("是否继续（y/n）：");
    }

}
