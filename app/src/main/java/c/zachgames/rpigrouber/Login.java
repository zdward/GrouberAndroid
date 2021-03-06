package c.zachgames.rpigrouber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Login extends AppCompatActivity
{

    private EditText Email;
    private EditText Password;
    private Button Login;
    private int incorrect = 5;
    private Button Register;
    //private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Register = (Button)findViewById(R.id.btnRegister);
        //title.setText("RPI GroUber");


        //Login Button
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Converts user input email and password into strings, then checks if user and password are correct
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

        //Register Button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goes to the registration page
                Intent intent = new Intent(c.zachgames.rpigrouber.Login.this, Registration.class);
                startActivity(intent);

            }
        });
    }

    private void validate(String userEmail, String userPassword)
    {
        if( (userEmail.equals("Admin")) && (userPassword.equals("yeet")) )
        {
            Intent intent = new Intent(c.zachgames.rpigrouber.Login.this, MainActivity.class);        //Go to some second activity
            startActivity(intent);      //Move to next page
        }
        else        //IF password is incorrect
        {
            incorrect--;
            if(incorrect == 0)
            {
                Login.setEnabled(false);        //Disable login after 5 tries
            }
        }

    }
}


