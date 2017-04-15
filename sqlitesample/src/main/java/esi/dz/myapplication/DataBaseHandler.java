package esi.dz.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {

    private Context context;
    static final String DB_NAME ="studentdb";
    static final int DB_VERSION = 1;
    static final String studentCreation = "create table student (id integer primary key,firstname,lastname)";


    public DataBaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }
        @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(studentCreation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public boolean addStudent (Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",student.getFirstName());
        contentValues.put("lastname",student.getLastName());
        long rowId = db.insert("student", null, contentValues);
        return (rowId!=-1);
    }

    public List<Student> getStudents() {
        List<Student> listStudent = new ArrayList<>();
        String query ="select * from student";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            Student student = new Student();
            student.setId(cursor.getInt(0));
            student.setFirstName(cursor.getString(1));
            student.setLastName(cursor.getString(2));
            listStudent.add(student);
        }
        db.close();
        return listStudent;
    }

    public Student getStudentByLastName(String lastName) {
        Student student =null;
        String query ="select * from student where lower(lastname)=?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{student.getLastName().toLowerCase()});
        if (cursor.moveToFirst()) {
            student = new Student();
            student.setId(cursor.getInt(0));
            student.setFirstName(cursor.getString(1));
            student.setLastName(cursor.getString(2));
        }
        db.close();
        return student;
    }



}
