package com.shiva.timetablemanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.shiva.timetablemanager.db.DB;
import com.shiva.timetablemanager.db.Periods;
import com.shiva.timetablemanager.db.Rooms;
import com.shiva.timetablemanager.db.Rotations;
import com.shiva.timetablemanager.db.Subjects;
import com.shiva.timetablemanager.db.Teachers;
import com.shiva.timetablemanager.db.Timetables;

import java.util.List;


public class DevDatabase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dev_database);

        DB db = new DB(getApplicationContext());
        db.open();

        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        t.setTitle("Dev Database");
        t.setTitleTextColor(getResources().getColor(R.color.white));
        t.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        /**
         * Print out all the information from all the tables in the database for the timetable feature
         * Exams and Homeworks and Reminders can be tested in their respective fragments.
         */


        // Print out all records for Room
        List<Rooms> roomsList = db.getAllRooms();
        String printoutRoom = "";
        for (int i = 0; i < roomsList.size(); i++) {
            printoutRoom += roomsList.get(i).toString() + "\n";
        }
        if (printoutRoom.equals(""))
            printoutRoom = "No records available";
        ((TextView) findViewById(R.id.roomLayout)).setText(printoutRoom);



        // Print out all records for Teacher
        List<Teachers> teachersList = db.getAllTeachers();
        String printoutTeacher = "";
        for (int i = 0; i < teachersList.size(); i++) {
            printoutTeacher += teachersList.get(i).toString() + "\n";
        }
        if (printoutTeacher.equals(""))
            printoutTeacher = "No records available";
        ((TextView) findViewById(R.id.teacherLayout)).setText(printoutTeacher);



        // Print out all records for Periods
        List<Periods> periodsList = db.getAllPeriods();
        String printoutPeriods = "";
        for (int i = 0; i < periodsList .size(); i++) {
            printoutPeriods += periodsList .get(i).toString() + "\n";
        }
        if (printoutPeriods.equals(""))
            printoutPeriods = "No records available";
        ((TextView) findViewById(R.id.periodLayout)).setText(printoutPeriods);



        // Print out all records for Subjects
        List<Subjects> subjectList = db.getAllSubjects();
        String printoutSubject = "";
        for (int i = 0; i < subjectList.size(); i++) {
            printoutSubject += subjectList.get(i).toString() + "\n";
        }
        if (printoutSubject.equals(""))
            printoutSubject = "No records available";
        ((TextView) findViewById(R.id.subjectLayout)).setText(printoutSubject);


        // Print out all records for Timetables
        List<Timetables> timetableList = db.getAllTimetables();
        String printoutTimetable = "";
        for (int i = 0; i < timetableList.size(); i++) {
            printoutTimetable += timetableList.get(i).toString() + "\n";
        }
        if (printoutTimetable.equals(""))
            printoutTimetable = "No records available";
        ((TextView) findViewById(R.id.timetableLayout)).setText(printoutTimetable);

        db.close();

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * Test scenario for the database
                 */


                DB newDB = new DB(getApplicationContext());
                newDB.open();


                Rooms R1 = new Rooms(DB.OP.CREATE, -1, "GA L01");
                Rooms R2 = new Rooms(DB.OP.CREATE, -1, "GA L02");
                Rooms R3 = new Rooms(DB.OP.CREATE, -1, "GA L03");
                Rooms R4 = new Rooms(DB.OP.CREATE, -1, "GB L01");
                Rooms R5 = new Rooms(DB.OP.CREATE, -1, "GB L02");
                Rooms R6 = new Rooms(DB.OP.CREATE, -1, "GB L03");
                Rooms R7 = new Rooms(DB.OP.CREATE, -1, "UA L01");
                Rooms R8 = new Rooms(DB.OP.CREATE, -1, "UA L02");
                Rooms R9 = new Rooms(DB.OP.CREATE, -1, "UA L03");
                Rooms R10 = new Rooms(DB.OP.CREATE, -1, "UA L04");
                Rooms R11 = new Rooms(DB.OP.CREATE, -1, "LAB");
                newDB.runRoom(R1);
                newDB.runRoom(R2);
                newDB.runRoom(R3);
                newDB.runRoom(R4);
                newDB.runRoom(R5);
                newDB.runRoom(R6);
                newDB.runRoom(R7);
                newDB.runRoom(R8);
                newDB.runRoom(R9);
                newDB.runRoom(R10);
                newDB.runRoom(R11);


                Teachers T1 = new Teachers(DB.OP.CREATE, -1, "Dr.Aruna Varanasi");
                Teachers T2 = new Teachers(DB.OP.CREATE, -1, "Mr. K Anup Kumar");
                Teachers T3 = new Teachers(DB.OP.CREATE, -1, "Mrs.P.Kavitha Reddy");
                Teachers T4 = new Teachers(DB.OP.CREATE, -1, "Prof T.V.Narayan Rao");
                Teachers T5 = new Teachers(DB.OP.CREATE, -1, "Mr. A.Chandu Naik");
                Teachers T6 = new Teachers(DB.OP.CREATE, -1, "Dr.Ramana Reddy");
                Teachers T7 = new Teachers(DB.OP.CREATE, -1, "Mr. A.Chandu Naik");


                newDB.runTeachers(T1);
                newDB.runTeachers(T2);
                newDB.runTeachers(T3);
                newDB.runTeachers(T4);
                newDB.runTeachers(T5);
                newDB.runTeachers(T6);
                newDB.runTeachers(T7);


                Periods P1 = new Periods(DB.OP.CREATE, 1, "09:30", "10:20");
                Periods P2 = new Periods(DB.OP.CREATE, 2, "10:30", "11:20");
                Periods P3 = new Periods(DB.OP.CREATE, 3, "11:30", "12:20");
                Periods P4 = new Periods(DB.OP.CREATE, 4, "12:30", "13:20");
                Periods P5 = new Periods(DB.OP.CREATE, 5, "13:30", "14:20");
                Periods P6 = new Periods(DB.OP.CREATE, 6, "14:30", "15:20");
                Periods P7 = new Periods(DB.OP.CREATE, 7, "15:30", "16:20");
                Periods P8 = new Periods(DB.OP.CREATE, 8, "16:30", "17:20");
                Periods P9 = new Periods(DB.OP.CREATE, 9, "09:30", "11:20");
                Periods P10 = new Periods(DB.OP.CREATE, 10, "11:30", "13:20");
                Periods P11 = new Periods(DB.OP.CREATE, 11, "15:30", "17:20");
                Periods P12 = new Periods(DB.OP.CREATE, 12, "14:30", "16:20");
                Periods P13 = new Periods(DB.OP.CREATE, 12, "13:30", "17:20");

                newDB.runPeriod(P1);
                newDB.runPeriod(P2);
                newDB.runPeriod(P3);
                newDB.runPeriod(P4);
                newDB.runPeriod(P5);
                newDB.runPeriod(P6);
                newDB.runPeriod(P7);
                newDB.runPeriod(P8);
                newDB.runPeriod(P9);
                newDB.runPeriod(P10);
                newDB.runPeriod(P11);
                newDB.runPeriod(P12);
                newDB.runPeriod(P13);


                Subjects S1 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Operating Systems", "OS", 0);
                Subjects S2 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Theory of Computation", "TOC", 8);
                Subjects S3 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Data Communications & Computer Networks", "CN", 10);
                Subjects S4 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Software Engineering", "SE", 6);
                Subjects S5 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Web Technologies", "WT", 5);
                Subjects S6 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Quantitaive Aptitude", "QA", 2);
                Subjects S7 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Group Project", "GP", 3);
                Subjects S8 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "TPWS", "TWPS", 7);
                Subjects S9 = new Subjects(getApplicationContext(), DB.OP.CREATE, -1, "Elective", "OR", 7);


                newDB.runSubjects(S1);
                newDB.runSubjects(S2);
                newDB.runSubjects(S3);
                newDB.runSubjects(S4);
                newDB.runSubjects(S5);
                newDB.runSubjects(S6);
                newDB.runSubjects(S7);
                newDB.runSubjects(S8);
                newDB.runSubjects(S9);


                Timetables tT1 = new Timetables(DB.OP.CREATE, 1, "Monday", 5, 4, 1, 4, 1);
                Timetables tT2 = new Timetables(DB.OP.CREATE, 1, "Monday", 4, 3, 3, 3, 1);
                Timetables tT3 = new Timetables(DB.OP.CREATE, 1, "Monday", 3, 1, 11, 1, 1);
                Timetables tT24 = new Timetables(DB.OP.CREATE, 1, "Monday", 3, 1, 11, 1, 1);
                Timetables tT23 = new Timetables(DB.OP.CREATE, 1, "Monday", 2, 8, 11, 2, 1);
                Timetables tT21 = new Timetables(DB.OP.CREATE, 1, "Monday", 1, 2, 2, 1, 1);
                Timetables tT22 = new Timetables(DB.OP.CREATE, 1, "Monday", 6, 5, 3, 1, 1);
                Timetables tT25 = new Timetables(DB.OP.CREATE, 1, "Monday", 8, 8, 11, 2, 1);

                Timetables tT4 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 1, 5, 11, 5, 1);
                Timetables tT26 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 2, 5, 11, 5, 1);
                Timetables tT27 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 3, 5, 11, 5, 1);
                Timetables tT28 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 4, 5, 11, 5, 1);
                Timetables tT5 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 5, 4, 1, 4, 1);
                Timetables tT6 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 6, 2, 3, 2, 1);
                Timetables tT7 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 7, 3, 3, 3, 1);
                Timetables tT8 = new Timetables(DB.OP.CREATE, 1, "Tuesday", 8, 5, 3, 5, 1);

                Timetables tT9 = new Timetables(DB.OP.CREATE, 1, "Wednesday", 1, 5, 3, 5, 1);
                Timetables tT10 = new Timetables(DB.OP.CREATE, 1, "Wednesday", 2, 4, 1, 4, 1);
                Timetables tT11 = new Timetables(DB.OP.CREATE, 1, "Wednesday", 3, 1, 11, 1, 1);
                Timetables tT12 =new Timetables(DB.OP.CREATE, 1, "Wednesday", 4, 2, 3, 2, 1);
                Timetables tT29 = new Timetables(DB.OP.CREATE, 1, "Wednesday", 5, 9, 11, 5, 1);

                Timetables tT30 = new Timetables(DB.OP.CREATE, 1, "Thursday", 1, 3, 3, 3, 1);
                Timetables tT13 = new Timetables(DB.OP.CREATE, 1, "Thursday", 2, 5, 3, 5, 1);
                Timetables tT14 = new Timetables(DB.OP.CREATE, 1, "Thursday", 3, 1, 11, 1, 1);
                Timetables tT15 =new Timetables(DB.OP.CREATE, 1, "Thursday", 4, 4, 1, 4, 1);
                Timetables tT16 = new Timetables(DB.OP.CREATE, 1, "Thursday", 5, 2, 3, 2, 1);
                Timetables tT31 = new Timetables(DB.OP.CREATE, 1, "Thursday", 6, 3, 3, 3, 1);
                Timetables tT32 = new Timetables(DB.OP.CREATE, 1, "Thursday", 7, 6, 3, 3, 1);

                Timetables tT17 = new Timetables(DB.OP.CREATE, 1, "Friday", 1, 9,4, 4, 1);
                Timetables tT18 =new Timetables(DB.OP.CREATE, 1, "Friday", 2, 5, 3, 5, 1);
                Timetables tT19 =  new Timetables(DB.OP.CREATE, 1, "Friday", 3, 2, 3, 2, 1);
                Timetables tT33 = new Timetables(DB.OP.CREATE, 1, "Friday", 4, 3, 3, 3, 1);
                Timetables tT34 = new Timetables(DB.OP.CREATE, 1, "Friday", 5, 3, 3, 3, 1);
                Timetables tT35 = new Timetables(DB.OP.CREATE, 1, "Friday", 6, 3, 3, 3, 1);










                newDB.runTimetable(tT1);
                newDB.runTimetable(tT2);
                newDB.runTimetable(tT3);
                newDB.runTimetable(tT4);
                newDB.runTimetable(tT5);
                newDB.runTimetable(tT6);
                newDB.runTimetable(tT7);
                newDB.runTimetable(tT8);
                newDB.runTimetable(tT9);
                newDB.runTimetable(tT10);
                newDB.runTimetable(tT11);
                newDB.runTimetable(tT12);
                newDB.runTimetable(tT13);
                newDB.runTimetable(tT14);
                newDB.runTimetable(tT15);
                newDB.runTimetable(tT16);
                newDB.runTimetable(tT17);
                newDB.runTimetable(tT18);
                newDB.runTimetable(tT19);
               // newDB.runTimetable(tT20);
                newDB.runTimetable(tT21);
                newDB.runTimetable(tT22);
                newDB.runTimetable(tT23);
                newDB.runTimetable(tT24);
                newDB.runTimetable(tT25);
                newDB.runTimetable(tT26);newDB.runTimetable(tT27);
                newDB.runTimetable(tT28);
                newDB.runTimetable(tT29);
                newDB.runTimetable(tT30);
                newDB.runTimetable(tT31);
                newDB.runTimetable(tT32);
                newDB.runTimetable(tT33);
                newDB.runTimetable(tT34);
                newDB.runTimetable(tT35);



                Rotations rR1 = new Rotations(DB.OP.CREATE, -1, "2016/05/05", 1);
                Rotations rR2 = new Rotations(DB.OP.CREATE, -1, "2016/05/12", 1);
                Rotations rR3 = new Rotations(DB.OP.CREATE, -1, "2016/05/19", 1);
                Rotations rR4 = new Rotations(DB.OP.CREATE, -1, "2016/05/26", 1);
                Rotations rR5 = new Rotations(DB.OP.CREATE, -1, "2016/06/02", 1);
                Rotations rR6 = new Rotations(DB.OP.CREATE, -1, "2016/06/09", 1);
                Rotations rR7 = new Rotations(DB.OP.CREATE, -1, "2016/06/16", 1);
                newDB.runRotation(rR1);
                newDB.runRotation(rR2);
                newDB.runRotation(rR3);
                newDB.runRotation(rR4);
                newDB.runRotation(rR5);
                newDB.runRotation(rR6);
                newDB.runRotation(rR7);


                newDB.close();
            }
        });

    }
}
