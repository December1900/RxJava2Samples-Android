package net.december1900.rxjava2samples_android.ui.operators;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.december1900.rxjava2samples_android.R;
import net.december1900.rxjava2samples_android.model.Course;
import net.december1900.rxjava2samples_android.model.Student;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by december on 2017/8/17.
 */

public class RxFlatMapActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, RxFlatMapActivity.class);
        context.startActivity(starter);
    }

    private static final String TAG = "RxFlatMapActivity";

    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples);

        tv = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething();
            }
        });

    }


    private void doSomething() {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("张华", new Course("212")));
        students.add(new Student("刘耳", new Course("123")));
        students.add(new Student("吉碗", new Course("322")));

        Observable.fromIterable(students)
                .flatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(@NonNull Student student) throws Exception {
                        return Observable.fromArray(student.getCourse());
                    }
                }).subscribe(new Consumer<Course>() {
            @Override
            public void accept(Course course) throws Exception {
                tv.append(course.getCname() + "\n");
                Log.d(TAG, course.getCname() + "\n");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d(TAG, "onError : " + throwable.getMessage());
            }
        });
    }


}
