package kun.entity.dao;

import kun.MainPage;
import kun.SalesmanPage;
import kun.entity.Goods;
import kun.entity.Salesman;
import kun.tools.JDBCUtil;
import kun.tools.ScannerChoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/21 0018.
 */
public class SalesmanDao {

    //1、添加售货员
    public void addSalesman(Salesman salesman){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getconn();
            String sql = "insert into salesman (sname, spwd) values (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,salesman.getSname());
            ps.setObject(2,salesman.getSpwd());
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
    //2、删除售货员
    public static void delete(String sname) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getconn();
            String sql = "DELETE FROM salesman WHERE sname = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,sname);
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

    //3、查询单个售货员
    public static boolean query(String sname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            conn = JDBCUtil.getconn();
            String sql = "SELECT * FROM salesman WHERE sname = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,sname);
            rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
                System.out.println("姓名\t\t\t\t密码");
                System.out.printf("%-10s %15s\n", rs.getString("sname"), rs.getString("spwd"));
            }else {
                System.out.println("不存在该售货员！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return exist;
    }

    //4、修改售货员 0、返回上一级界面；1、更改姓名 2、更改密码
    public static void updata(int info,String sname) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        String sql = new String();
        try {
            conn = JDBCUtil.getconn();
            switch (info) {
                case 0:
                    SalesmanPage.Salesman();
                    break;
                case 1:
                    sql = "UPDATE salesman SET sname = ? WHERE  sname = ?";
                    System.out.println("请输入修改后的姓名：");
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1, ScannerChoice.ScannerString());
                    break;
                case 2:
                    sql = "UPDATE salesman SET spwd = ? WHERE  sname = ?";
                    System.out.println("请输入修改后的密码：");
                    ps = conn.prepareStatement(sql);
                    ps.setObject(1, ScannerChoice.ScannerString());
                    break;
            }

            ps.setObject(2, sname);
            if (ps.executeUpdate()>0)
                System.out.println("修改数据库成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(ps, conn);
        }
    }
    //5.查询并排序
    public static void querySalesman(String info){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = new String();
        try {
            conn = JDBCUtil.getconn();
            sql = "select * from salesman where username like ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,info);
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
            sql = "SELECT * FROM salesman ORDER BY sname";
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
            System.out.println("姓名\t\t\t\t密码");
            System.out.printf("%-10s %15s\n", rs.getString("sname"), rs.getString("spwd"));
            while (rs.next()){
                System.out.printf("%-10s %15s\n", rs.getString("sname"), rs.getString("spwd"));
            }
            System.out.printf("按任意键返回。");
            ScannerChoice.ScannerString();
        }else {
            System.out.println("不存在该售货员！");
        }
    }

}

