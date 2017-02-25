package eu.long1.spacetablayoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

public class Login extends Activity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText emaill;
    private EditText passwordd;
    private  Button button1;
    private TextView alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        emaill = (EditText) findViewById(R.id.emailT);
        passwordd = (EditText) findViewById(R.id.passwordT);
        alert=(TextView)findViewById(R.id.alert);




    }

public void signin(View v){
    String email = emaill.getText().toString();
    final String password = passwordd.getText().toString();

    if (TextUtils.isEmpty(email)) {
        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
        return;
    }

    if (TextUtils.isEmpty(password)) {
        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
        return;
    }

    //  progressBar.setVisibility(View.VISIBLE);

    //authenticate user
    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    //   progressBar.setVisibility(View.GONE);
                    if (!task.isSuccessful()) {
                        alert.setText("periksa kembali email dan password anda");

                    } else {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
}

    public void signup(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }



}
