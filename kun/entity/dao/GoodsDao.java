package kun.entity.dao;

import kun.entity.Goods;
import kun.tools.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class GoodsDao
{
    public boolean addGoods(Goods good){
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
            System.out.println("插入一行记录");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(ps, conn);
        }
        if (count>0){
            return true;
        }
        return false;

    }
}
