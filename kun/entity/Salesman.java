package kun.entity;

/**
 * Created by Administrator on 2017/9/21 0012.
 */
public class Salesman {
    private int sid;
    private String sname;
    private String spwd;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public Salesman(int gid, String sname, String spwd) {
        this.sid = gid;
        this.sname = sname;
        this.spwd = spwd;
    }

    public Salesman(String sname, String spwd) {
        this.sname = sname;
        this.spwd = spwd;
    }
}
