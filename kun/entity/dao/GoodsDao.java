package kun.entity.dao;

import kun.entity.Goods;

import java.sql.*;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class GoodsDao
{
    public boolean addGoods(Goods good){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("sql://localhost:3306/seveneleven","root","wwww");
            String sql = "insert into goods (gid, gname, gprice, gnum) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,5);
            ps.setObject(2,"shi");
            ps.setObject(3,"0.5");
            ps.setObject(4,6);
            ps.execute();
            System.out.println("插入一行记录");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }
}
