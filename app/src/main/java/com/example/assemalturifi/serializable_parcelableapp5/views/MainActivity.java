package com.example.assemalturifi.serializable_parcelableapp5.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.assemalturifi.serializable_parcelableapp5.R;
import com.example.assemalturifi.serializable_parcelableapp5.model.Person;
import com.example.assemalturifi.serializable_parcelableapp5.model.PersonParcel;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName()+"_TAG";
    private EditText etMain;
    private EditText etName;
    private EditText etAge;
    private EditText etGender;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starts");
        //step3
        bindViews();


        Log.d(TAG, "onCreate: ends");
    }
    //step2
    public void bindViews(){
        etMain = findViewById(R.id.etMain);
        etName = findViewById(R.id.etPersonName);
        etAge = findViewById(R.id.etPersonAge);
        etGender = findViewById(R.id.etPersonGender);

        tvMain = findViewById(R.id.tvMain);

    }

    //step4
    //firstBtn
    public void onUpdateTextView(View view) {
        Log.d(TAG, "onUpdateTextView: starts");
        String etText=etMain.getText().toString();
        tvMain.setText(etText);
        etMain.setText("");
        Log.d(TAG, "onUpdateTextView: ends");
    }


    //step8
    //3rd and 4th btn
    public void onSendingPerson(View view) {
        Log.d(TAG, "onSendingPerson: starts");

        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String gender = etGender.getText().toString();

        Intent intent = new Intent(getApplicationContext(), second_activity.class);
        intent.putExtra("isPerson", "true");

        switch (view.getId()) {
            case R.id.btnPersonSerializable:
                Person person = new Person(name, age, gender);
                intent.putExtra("personType", "serializable");
                intent.putExtra("person", person);
                break;
            case R.id.btnPersonParcelable:
                PersonParcel personParcel = new PersonParcel(name, age, gender);
                intent.putExtra("personType", "parcelable");
                intent.putExtra("person", personParcel);
                break;
        }
        startActivity(intent);

        Log.d(TAG, "onSendingPerson: ends");
    }
}
