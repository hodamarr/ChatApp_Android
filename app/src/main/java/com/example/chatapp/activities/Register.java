package com.example.chatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.R;
import com.example.chatapp.databinding.ActivityRegisterBinding;
import com.example.chatapp.objects.LoggedInUsr;
import com.example.chatapp.repository.UserRepository;
import com.example.chatapp.room.User;

import java.util.List;

public class Register extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private LoggedInUsr usr;
    private UserRepository userRepository = new UserRepository();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        List<User> lu = userRepository.getAll();
        EditText name = findViewById(R.id.etRegisterUsername);
        EditText nick = findViewById(R.id.etRegisterNick);
        EditText pass = findViewById(R.id.etRegisterPassword);
        EditText passValid = findViewById(R.id.etRegisterPassValid);

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
                userRepository.addUser(new User(name.getText().toString(), nick.getText().toString(),
                        pass.getText().toString(), usr.getServer()));

                Intent i = new Intent(this, Chats.class);
                usr = LoggedInUsr.create(name.getText().toString());
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

        //image picker
        Button imagePicker = findViewById(R.id.image_picker);
        imagePicker.setOnClickListener(v -> {
            // Launches photo picker in single-select mode.
            // This means that the user can select one photo or video.
//            Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
//            startActivityForResult(intent, PHOTO_PICKER_REQUEST_CODE);
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