package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity{

    private EditText usernameInput, passwordInput;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                boolean check = validateinfo(name, password);

                if(check == true) {
                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, HomePage.class);
                    intent.putExtra("USERNAME", name);
                    startActivity(intent);
                }
            }
        });

    }

    private Boolean validateinfo(String name, String password) {
        if(name.length() == 0){
            usernameInput.requestFocus();
            usernameInput.setError("Username must be filled in");
            return false;
        }

        else if(password.length() == 0){
            passwordInput.requestFocus();
            passwordInput.setError("Password must be filled in");
            return false;
        } else if (password.length() < 8) {
            passwordInput.requestFocus();
            passwordInput.setError("Password length must be at least 8 characters");
            return false;
        } else{
            return true;
        }
    }
}