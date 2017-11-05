package abd.askandr.mhmd.finallhayamuhammad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity
{

    private EditText etName, etPass,etRePass, etMail;
    private Button btnSave;
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
    }

}
