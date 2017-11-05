package abd.askandr.mhmd.finallhayamuhammad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity
{

    private EditText etName, etPass,etRePass, etMail;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPass);
        etRePass = (EditText) findViewById(R.id.etRePass);
        etMail = (EditText) findViewById(R.id.etMail);
        btnSave = (Button) findViewById(R.id.btnSave);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();


    }

    private void dataHandler() {
        String stemail = etMail.getText().toString();
        String stpassword = etPass.getText().toString();
        String stname = etName.getText().toString();
        String phone = etRePass.getText().toString();
        boolean isOk = true;
        if (stemail.length() == 0 || stemail.indexOf('@') < 1) {
            etMail.setError("WRONG EMAIL");
            isOk = false;
        }
        if (stpassword.length() < 8) {
            etPass.setError("BAD PASSWORD");
            isOk = false;
        }
        if (isOk) {
            creatAcount(stemail, stpassword);

    }
