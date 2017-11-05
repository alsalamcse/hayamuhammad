package abd.askandr.mhmd.finallhayamuhammad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    private EditText etName, etPassword;
    private Button btnLogin, btnSignup, btnForget;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnForget = (Button) findViewById(R.id.btnForget);
        auth=FirebaseAuth.getInstance();
        firebaseUser=auth.getCurrentUser();


    }
    private  void dataHandler() {
        String stName = etName.getText().toString();
        String stPass = etPassword.getText().toString();
        signIn(stName,stPass);

    }

    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LogInActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LogInActivity.this,MainListActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LogInActivity.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
    }
    }