package net.december1900.rxjava2samples_android.model;

/**
 * Created by december on 2017/8/17.
 */

public class Course {

    public String cno;
    public String cname;

    public Course(String cno) {
        this.cno = cno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        String cursor = cno.substring(0, 1);
        if (cursor.equals("1")) {
            return "CS : Art : Architecture";
        } else if (cursor.equals("2")) {
            return "Psychology : Chemistry : Art";
        } else {
            return "Geography : CS : Architecture";
        }
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
