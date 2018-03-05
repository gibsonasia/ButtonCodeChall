package com.gibson.a.fakebutton.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.gibson.a.fakebutton.R;

public class CreateNewUserActivity extends AppCompatActivity {

    EditText name,email,candidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        name = findViewById(R.id.name_et);
        email = findViewById(R.id.email_et);
        candidate = findViewById(R.id.canditate_et);
    }
}
