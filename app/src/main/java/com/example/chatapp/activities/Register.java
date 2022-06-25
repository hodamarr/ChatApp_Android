package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.MyApplication;
import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityRegisterBinding;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.objects.tokenData;
import com.example.chatapp.room.User;
import com.example.chatapp.webServiceAPI.WebServiceAPI;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private LoggedInUsr usr;
    private Retrofit retrofit;
    private WebServiceAPI webServiceAPI;
    private List<User> lu;
    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);



        Call<List<User>> call = webServiceAPI.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                lu = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d(t.toString(), "connection failed!\n");
            }
        });

        EditText name = findViewById(R.id.etRegisterUsername);
        EditText nick = findViewById(R.id.etRegisterNick);
        EditText pass = findViewById(R.id.etRegisterPassword);


        //regist button
        binding.btnRegsiterNow.setOnClickListener(v -> {

            Log.d("name-----", name.getText().toString());
            /// check if exist
            Boolean isExist = false;
            for (User u : lu){

                if (u.getName().equals(name.getText().toString())){
                    isExist = true;
                    break;
                }
            }

            Log.d("isExist", isExist.toString());

            if(isExist == false) {
                FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(Register.this, p->{
                    token = p.getToken();
                });
                Call<Void> call1 = webServiceAPI.createUser(new User(name.getText().toString(), nick.getText().toString(),
                        pass.getText().toString(), usr.getServer(), token));
                call1.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        new Thread( () -> {
                            Call<Void> call2 = webServiceAPI.createToken(new tokenData(name.getText().toString(), token));
                            call2.enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {}
                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {}
                            });
                        }).start();

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
                usr = LoggedInUsr.create(name.getText().toString());

                Intent i = new Intent(this, Chats.class);
                startActivity(i);
            }
            else{
                CharSequence text = "Username already exist";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();

                Intent j = new Intent(this, Register.class);
                startActivity(j);
            }
        });

        //login button
        binding.btnRegisterLogin.setOnClickListener(v -> {
            Intent iMainActivity = new Intent(this, MainActivity.class);
            startActivity(iMainActivity);
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