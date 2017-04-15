package esi.dz.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void addStudent_test() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Student student = new Student();
        student.setFirstName("first name 1");
        student.setLastName("last name 1");
        DataBaseHandler dataBaseHandler = new DataBaseHandler(appContext);
        assertTrue(dataBaseHandler.addStudent(student));
    }

    @Test
    public void getStudents_test() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        List<Student> listStudent = new ArrayList<>();
        DataBaseHandler dataBaseHandler = new DataBaseHandler(appContext);
        listStudent = dataBaseHandler.getStudents();
        assertEquals(listStudent.size(),1);
        assertEquals(listStudent.get(0).getId(),1);
        assertEquals(listStudent.get(0).getFirstName(),"first name 1");
        assertEquals(listStudent.get(0).getLastName(),"last name 1");
    }

}




