package net.december1900.rxjava2samples_android.model;

/**
 * Created by december on 2017/8/17.
 */

public class Student {

    public String name;
    public Course mCourse;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        mCourse = course;
    }

    public Student(String name, Course cno) {
        this.name = name;
        this.mCourse = cno;
    }


}
