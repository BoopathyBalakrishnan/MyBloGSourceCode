package com.learning.sqlite_from_assets.activities;


import com.learning.sqlite_from_assets.R;
import com.learning.sqlite_from_assets.adapters.StudentAdapter;
import com.learning.sqlite_from_assets.databasehelpers.DBAdapter;
import com.learning.sqlite_from_assets.databasehelpers.DataBaseHelper;
import com.learning.sqlite_from_assets.models.StudentsInformationModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;
/**
 * @author Boopathy Balakrishnan
 * 
 * @version 1.0
 */
public class StudentActivity extends Activity {

    EditText etName, etDept, etSearch;
    ListView lv;
    Button btnSave;
    DataBaseHelper mDBhelper;
    DBAdapter mDBAdapter;
    StudentAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        mDBhelper = new DataBaseHelper(getApplicationContext());
        mDBAdapter = new DBAdapter(getApplicationContext());
        copyMyDatabase();
        displayValuesFromDB();
    }

    /**
     * Method used to get the values and
     * 
     *      set the adapter into listview
     */
    private void displayValuesFromDB() {
        List<StudentsInformationModel> lists = mDBAdapter
                .getStudentInformation();

        mListAdapter = new StudentAdapter(getApplicationContext(), lists);

        lv.setAdapter(mListAdapter);
    }

    /**
     * initlizes all widgets
     */
    private void initWidgets() {
        etName = (EditText) findViewById(R.id.nameET);
        etDept = (EditText) findViewById(R.id.deptET);
        btnSave = (Button) findViewById(R.id.button1);
        lv = (ListView) findViewById(R.id.studentLV);
        btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String dept = etDept.getText().toString();
                mDBAdapter.open();
                StudentsInformationModel insertStudentInform = new StudentsInformationModel(
                        name, dept);
                mListAdapter.notifyDataSetChanged();
                mDBAdapter.insertStudentInformation(insertStudentInform);
                mDBAdapter.close();
            }
        });


    }

    /**
     * Method used to copy database from Assets
     */
    private void copyMyDatabase() {
        try {
            mDBhelper.createDataBase();
        } catch (Exception e) {
            throw new Error("Error in copy database");
        }

        try {
            mDBhelper.openDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mDBhelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
