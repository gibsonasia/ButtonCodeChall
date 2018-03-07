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

   public EditText name,email,candidate;
    Button addClientBttn;

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
               if(TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(name.getText())||
                       TextUtils.isEmpty(email.getText())){

                   Toast.makeText(getApplicationContext(), "Check all feilds, try again", Toast.LENGTH_LONG).show();

               }


            }
        });


    }

    public void sendUserData(View view){

        Intent intent = new Intent();
        String name_field = name.getText().toString();
    }
}
