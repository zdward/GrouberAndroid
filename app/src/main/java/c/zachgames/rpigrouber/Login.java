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
    //private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        //title.setText("RPI GroUber");



        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Converts user input email and password into strings, then checks if user and password are correct
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userEmail, String userPassword)
    {
        if( (userEmail.equals("Admin")) && (userPassword.equals("yeet")) )
        {
            Intent intent = new Intent(c.zachgames.rpigrouber.Login.this, SecondActivity.class);        //Go to some second activity
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


