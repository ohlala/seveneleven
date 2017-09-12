package kun.entity;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class Goods {
    private int gid;
    private String gname;
    private double gprice;
    private int gnumber;

    public Goods(String gname, double gprice, int gnumber) {
        this.gname = gname;
        this.gprice = gprice;
        this.gnumber = gnumber;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGnumber() {
        return gnumber;
    }

    public void setGnumber(int gnumber) {
        this.gnumber = gnumber;
    }
}
