package eu.long1.spacetablayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void signup(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}
