package eduhsahay.wpi.signupform;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    private static final String TAG = "LoginActivity";

    Button mSubmitButton;
    EditText mUserName;
    EditText mPasswordInput;
    EditText mConfirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mUserName = (EditText) findViewById(R.id.username_input);
        mPasswordInput = (EditText) findViewById(R.id.password_input);
        mConfirmInput = (EditText) findViewById(R.id.confirm_input);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserName.getText().toString();
                String password = mPasswordInput.getText().toString();
                String confirmation = mConfirmInput.getText().toString();

                if(password.equals(confirmation)) {
                    User newUser = new User(username, password);
                    // Create new user after password success during account creation

                    // Used to move between activities
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    //Instead of LoginActivity.this, could also have used this.super
                    //Intent is envelope for sending message between activities
                    i.putExtra(HomeActivity.EXTRA, newUser); //key, value pair
                    startActivity(i);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
