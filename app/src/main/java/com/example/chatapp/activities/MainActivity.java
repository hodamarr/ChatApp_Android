package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityMainBinding;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.repository.UserRepository;
import com.example.chatapp.room.User;
import com.example.chatapp.webServiceAPI.WebServiceAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    /// for navigation
    private ActivityMainBinding binding;
    private LoggedInUsr usr;
    private UserRepository userRepository;
    private User user;


    //// USE LOG.I for info and debug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        userRepository = new UserRepository();
         String s;

        setContentView(binding.getRoot());


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://10.0.2.2:7149/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        WebServiceAPI api = retrofit.create(WebServiceAPI.class);
        Call<List<User>> call = api.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    Log.d("on fail","worked but error");
                    return;
                }
                List<User> users = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d(t.getMessage(),"didn't worked agaim2");
            }
        });
        //List<User> users = userRepository.getAll();
        EditText username = findViewById(R.id.etLoginUsername);
        EditText password = findViewById(R.id.etLoginPassword);

        binding.btnLogin.setOnClickListener(v -> {
            Boolean isExist = false;
//            for (User u : users){
//                if(username.getText().toString().equals(u.getName())){
//                   user = u;
//                   isExist = true;
//                   break;
//                }
//            }

/// && user.getServer().equals(usr.getServer())
            if (isExist == true) {

                Log.d("passFromText", password.getText().toString());
                if (user.getPassword().equals(password.getText().toString())) {
                    Intent i = new Intent(this, Chats.class);
                    usr = LoggedInUsr.create(user.getName());
                    startActivity(i);
                }
            }
            else {
                CharSequence text = "Username or Password incorrect!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();

                Intent j = new Intent(this, MainActivity.class);
                startActivity(j);
            }
        });

        /// register button (On click Logic)
        binding.btnRegister.setOnClickListener(v -> {
            Intent iRegister = new Intent(this, Register.class);
            startActivity(iRegister);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}