package kun.entity.dao;

import kun.entity.Goods;
import kun.tools.JDBCUtil;
import kun.tools.ScannerChoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kun.MainPage;
/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class GoodsDao{

    //1、添加商品
    public void addGoods(Goods good){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getconn();
            String sql = "insert into goods (gname, gprice, gnum) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,good.getGname());
            ps.setObject(2,good.getGprice());
            ps.setObject(3,good.getGnumber());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(ps, conn);
        }
        if (count>0){
            System.out.println("插入数据成功");
        }else {
            System.out.println("插入数据失败");
        }
        return;
    }
    //2、删除商品
    public static void delete(String gname) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getconn();
            String sql = "DELETE FROM goods WHERE gname = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,gname);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(ps, conn);
        }
        if (count>0){
            System.out.println("删除数据成功");
        }else {
            System.out.println("删除数据失败");
        }
        return;
    }

    //3、查询单个商品
    public static boolean query(String gname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            conn = JDBCUtil.getconn();
            String sql = "SELECT * FROM goods WHERE gname = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,gname);
            rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
                System.out.println("商品名称\t\t商品价格\t商品数量");
                System.out.printf("%-15s %8.2f %8d\n", rs.getString("gname"), rs.getDouble("gprice"), rs.getInt("gnum"));
            }else {
                System.out.println("不存在该商品！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return exist;
    }

    //4、修改商品 0、返回上一级界面；1、更改商品名称 2、更改商品价格； 3.更改商品数量
    public static void updata(int info,String gname) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        String sql = new String();
        try {
            conn = JDBCUtil.getconn();
            switch (info) {
                case 0:
                    MainPage.maintenancePage();
                    break;
                case 1:
                    sql = "UPDATE goods SET gname = ? WHERE  gname = ?";
                    System.out.println("请输入修改后的名称：");
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1, ScannerChoice.ScannerString());
                    break;
                case 2:
                    sql = "UPDATE goods SET gprice = ? WHERE  gname = ?";
                    System.out.println("请输入修改后的价格：");
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1, ScannerChoice.ScannerInfo());
                    break;
                case 3:
                    sql = "UPDATE goods SET gnum = ? WHERE  gname = ?";
                    System.out.println("请输入修改后的数量：");
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1, ScannerChoice.ScannerInt());
                    break;
            }

            ps.setObject(2, gname);
            if (ps.executeUpdate()>0)
                System.out.println("修改数据库成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(ps, conn);
        }
    }
    //5.查询并排序
    public static void queryGoods(int info){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = new String();
        try {
            conn = JDBCUtil.getconn();
            switch (info){
                case 0:
                    MainPage.maintenancePage();
                    break;
                case 1:
                    sql = "SELECT * FROM goods ORDER BY gnum";
                    ps = conn.prepareStatement(sql);
                    break;
                case 2:
                    sql = "SELECT * FROM goods ORDER BY gprice";
                    ps = conn.prepareStatement(sql);
                    break;
                case 3:
                    sql = "SELECT * FROM goods WHERE gname LIKE '%'||?";  //！！！
                    System.out.printf("请输入想查询的关键字：");
                    String good = ScannerChoice.ScannerString();
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1,good);
                    break;
            }
            rs = ps.executeQuery();
            printrs(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
    }
    public static void dispaly(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = new String();
        try {
            conn = JDBCUtil.getconn();
            sql = "SELECT * FROM goods ORDER BY gname";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            printrs(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
    }


    public static void printrs(ResultSet rs) throws SQLException {
        if (rs.next()){
            System.out.println("商品名称\t\t商品价格\t商品数量\t  备注");
            System.out.printf("%-15s %8.2f %8d",rs.getString("gname"),rs.getDouble("gprice"),rs.getInt("gnum"));
            if(rs.getInt("gnum")<10){
                System.out.printf("\t\t该商品已经不足10件！");
            }
            System.out.println();
            while (rs.next()){
                System.out.printf("%-15s %8.2f %8d",rs.getString("gname"),rs.getDouble("gprice"),rs.getInt("gnum"));
                if(rs.getInt("gnum")<10){
                    System.out.printf("\t\t该商品已经不足10件！");
                }
                System.out.println();
            }
            System.out.printf("按任意键返回。");
            ScannerChoice.ScannerString();
        }else {
            System.out.println("不存在该商品！");
        }
    }

}

