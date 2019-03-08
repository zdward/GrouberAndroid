package c.zachgames.rpigrouber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailConfirmation extends AppCompatActivity {

    private Button Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_confirmation);

        Continue = (Button)findViewById(R.id.btnEmailContinue);

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goes to the login page
                Intent intent2 = new Intent(c.zachgames.rpigrouber.EmailConfirmation.this, Login.class);
                startActivity(intent2);

            }
        });

    }
}
