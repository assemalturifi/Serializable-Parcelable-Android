package com.example.assemalturifi.serializable_parcelableapp5.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assemalturifi.serializable_parcelableapp5.R;
import com.example.assemalturifi.serializable_parcelableapp5.model.Person;
import com.example.assemalturifi.serializable_parcelableapp5.model.PersonParcel;

//step6

public class second_activity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName()+"_TAG";
    private TextView tvSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Log.d(TAG, "onCreate: SecondActivity starts");
        tvSecondActivity = findViewById(R.id.tvSecond);


        //step9
        if(getIntent().getStringExtra("isPerson").equals("true")){
            ///retrieve the value from the main intent

            String personType = getIntent().getStringExtra("personType");
            Toast.makeText(this, personType, Toast.LENGTH_SHORT).show();

            switch (personType) {
                case "serializable":
                    Person person = (Person)getIntent().getSerializableExtra("person");
                    tvSecondActivity.setText(person.toString());
                    break;
                case "parcelable":
                    PersonParcel personParcel = getIntent().getParcelableExtra("person");
                    tvSecondActivity.setText(personParcel.toString());
                    break;

            }

        }


        Log.d(TAG, "onCreate: Second Activity ends");
    }
}
