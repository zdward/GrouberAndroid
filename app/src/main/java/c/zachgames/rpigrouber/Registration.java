package c.zachgames.rpigrouber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Registration extends AppCompatActivity{

    private Button Create;
    private EditText password;
    private EditText con_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        Create = (Button)findViewById(R.id.btnCreate);
        password = (EditText)findViewById(R.id.password);
        con_password = (EditText)findViewById(R.id.confirmPassword);


        //Create Button
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goes to the registration page
                if(password.getText().toString().equals(con_password.getText().toString())) {
                    Intent intent2 = new Intent(c.zachgames.rpigrouber.Registration.this, Login.class);
                    startActivity(intent2);
                }
            }
        });

    }
}
