package com.gibson.a.fakebutton.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.gibson.a.fakebutton.FakeButtonApi;
import com.gibson.a.fakebutton.R;
import com.gibson.a.fakebutton.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;

    public static int MAIN_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);
        button = findViewById(R.id.create_user_button);

        //Will open new Activity to Add new user credentials
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateNewUserActivity.class);
                startActivity(intent);
            }
        });

         retrofitCall();
    }

    //Retrieve New user information from Create Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == MAIN_RESULT) {
            if (resultCode == RESULT_OK) {
               User userResult = new User(data.getStringExtra(CreateNewUserActivity.USER_NAME),
                       data.getStringExtra(CreateNewUserActivity.USER_EMAIL),
                               data.getStringExtra(CreateNewUserActivity.CANDIDATE));
                    //TODO connect Result to be POSTED
            }
        }
    }


    //Retrofit call
    private void retrofitCall() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FakeButtonApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        FakeButtonApi api = retrofit.create(FakeButtonApi.class);

        Call<List<User>> call = api.getUser("candidate");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {


                List<User> userList = response.body();


                String[] users = new String[userList.size()];

                //To show each name of each user in list
                for (int i = 0; i < userList.size(); i++) {
                    users[i] = userList.get(i).getName();

                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, users));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
