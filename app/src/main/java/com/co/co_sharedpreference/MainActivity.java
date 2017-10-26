package com.co.co_sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button saveInfo, displayInfo;
    TextView display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        display = (TextView) findViewById(R.id.dsiplayText);
        saveInfo = (Button) findViewById(R.id.btnSave);
        displayInfo = (Button) findViewById(R.id.btnDisplay);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("User", username.getText().toString());
        editor.putString("Password", password.getText().toString());
        editor.commit();
        Log.i("Sample Log", "NAGAWA YUNG ACT");
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void loadInfo(View view){
        String user = preferences.getString("User", "");
        String pass = preferences.getString("Password", "");
        display.setText("The username is: " + user + " and the password is: " + pass);
    }
}
