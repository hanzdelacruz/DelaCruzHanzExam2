package com.delacruz.hanz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class MainActivity extends AppCompatActivity {


    private EditText eFname, eLname, eEx1, eEx2;
    private TextView tAve;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFname = findViewById(R.id.eFirstName);
        eLname = findViewById(R.id.eLastName);
        eEx1 = findViewById(R.id.eExam1);
        eEx2 = findViewById(R.id.eExam2);
        tAve = findViewById(R.id.txtAverage);
        mButton = findViewById(R.id.button2);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                addRecord();
            }
        });
    }


    public void addRecord() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Grade");
        String fname = eFname.getText().toString().trim();
        String lname = eLname.getText().toString().trim();
        Long exam1 = Long.parseLong(eEx1.getText().toString().trim());
        Long exam2 = Long.parseLong(eEx2.getText().toString().trim());
        Long average = (exam1 + exam2) / 2;

        Grade sgrade = new Grade(fname, lname, average);
        String key = myRef.push().getKey();
        myRef.child(key).setValue(sgrade);

        tAve.setText("Your average is: " + average);
//        Toast.makeText(this,"Student Grade added to Firebase",Toast.LENGTH_LONG).show();
    }
}