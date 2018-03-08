package com.gibson.a.fakebutton.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gibson.a.fakebutton.R;

public class CreateNewUserActivity extends AppCompatActivity {

    public EditText name, email, candidate;
    Button addClientBttn;

    public static String USER_NAME = "com.gibson.a.fakebutton.USER_NAME";
    public static String USER_EMAIL = "com.gibson.a.fakebutton.USER_EMAIL";
    public static String CANDIDATE = "com.gibson.a.fakebutton.CANDIDATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        name = findViewById(R.id.name_et);
        email = findViewById(R.id.email_et);
        candidate = findViewById(R.id.canditate_et);
        addClientBttn = findViewById(R.id.add_client_bttn);

        addClientBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(name.getText()) ||
                        TextUtils.isEmpty(email.getText())) {

                    Toast.makeText(getApplicationContext(), R.string.toast_check, Toast.LENGTH_LONG).show();

                } else {
                    sendUserData();
                    finish();
                }


            }
        });


    }

    //Method to collect data from fields to send to Main Activity
    public void sendUserData() {

        Intent intent = new Intent(this, MainActivity.class);
        String nameField = name.getText().toString();
        String emailField = name.getText().toString();
        String candidateField = name.getText().toString();
        intent.putExtra(USER_NAME, nameField);
        intent.putExtra(USER_EMAIL, emailField);
        intent.putExtra(CANDIDATE, candidateField);
        setResult(RESULT_OK, intent);
    }
}
