package kun.entity.dao;

import kun.entity.Goods;
import kun.tools.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public static void query(String gname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getconn();
            String sql = "SELECT * FROM goods WHERE gname = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,gname);
            rs = ps.executeQuery();

            if (rs != null){
                System.out.println("商品名称\t商品价格\t商品数量");
                while (rs.next())
                    System.out.println(rs.getString("gname")+"\t\t\t"+rs.getDouble("gprice")
                    + "\t"+rs.getInt("gnum"));
            }else {
                System.out.println("不存在该商品！");//////????????
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return;
    }
}
/*
    //4、修改商品
    public static int updata() {

    }
*/
