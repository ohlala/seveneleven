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

    //3、查询商品
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

            if (rs.next()){
                exist = true;
                System.out.println("商品名称\t商品价格\t商品数量");
                System.out.println(rs.getString("gname")+"\t\t\t"+rs.getDouble("gprice")
                        + "\t"+rs.getInt("gnum"));
                while (rs.next())
                    System.out.println(rs.getString("gname")+"\t\t\t"+rs.getDouble("gprice")
                    + "\t"+rs.getInt("gnum"));
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
                    ps.setObject(1, ScannerChoice.ScannerString());
                    break;
                case 2:
                    sql = "UPDATE goods SET gprice = ? WHERE  gname = ?";
                    System.out.println("请输入修改后的价格：");
                    ps.setObject(1, ScannerChoice.ScannerInfo());
                    break;
                case 3:
                    sql = "UPDATE goods SET gnum = ? WHERE  gname = ?";
                    System.out.println("请输入修改后的数量：");
                    ps.setObject(1, ScannerChoice.ScannerInt());
                    break;
            }
            ps = conn.prepareStatement(sql);
            ps.setObject(2, gname);
            if (ps.executeUpdate()>0)
                System.out.println("修改数据库成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(ps, conn);
        }
    }
}

