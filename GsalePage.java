import kun.tools.ScannerChoice;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public class GsalePage {
    public static void shoppingSettlementPage(){
        System.out.println("\t1.购物结算");
        double count = 0.0;
        do {
            do {
                System.out.println("输入商品关键字：");
                String temp = ScannerChoice.ScannerString();
                System.out.println("请选择商品：");
                System.out.println("商品名称\t商品价格\t商品数量\t备注");
                //模糊搜索
                String goods = ScannerChoice.ScannerString();
                System.out.println("请输入购买数量：");
                int goodsNum = ScannerChoice.ScannerInt();
                //数据库操作（减去商品数量 不足报错）
                count += goodsNum * 1;
                System.out.println("是否继续（y/n）");
                String flag = ScannerChoice.ScannerString();
                if (flag.equals("n")){
                    break;
                }
            }while (true);
            System.out.println("共计："+count+"元");
            System.out.println("请输入实际金额：");
            //?/
            System.out.println("找零：");
            System.out.println("是否继续收银？（y/n）");
            String flag = ScannerChoice.ScannerString();
            if (flag.equals("n")){
                //break;
                //回到？/？
            }
        }while (true);
    }
}
