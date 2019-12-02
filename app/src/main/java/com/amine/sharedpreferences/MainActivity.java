package com.amine.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName,mPassword;
    private Button btnLogin;
    private CheckBox mCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName=(EditText)findViewById(R.id.editText);
        mPassword=(EditText)findViewById(R.id.editText2);
        btnLogin=(Button) findViewById(R.id.button);
        mCheckbox=(CheckBox)findViewById(R.id.checkBox);


        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);

        mEditor=mPreferences.edit();
       /* mEditor.putString("key","mitch");
        mEditor.commit();

        String name=mPreferences.getString("key","default");
        Log.d(TAG,"onCreate:name"+name);*/
       checkSharedPreferences();
       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mCheckbox.isChecked()){
                   mEditor.putString(getString(R.string.checkbox),"true");
                   mEditor.commit();

                   String name=mName.getText().toString();
                   mEditor.putString(getString(R.string.name),name);
                   mEditor.commit();

                   String password=mPassword.getText().toString();
                   mEditor.putString(getString(R.string.password),password);
                   mEditor.commit();
               }else{
                   mEditor.putString(getString(R.string.checkbox),"false");
                   mEditor.commit();

                   String name=mName.getText().toString();
                   mEditor.putString(getString(R.string.name),"");
                   mEditor.commit();

                   String password=mPassword.getText().toString();
                   mEditor.putString(getString(R.string.password),"");
                   mEditor.commit();


               }
           }
       });

    }
    private void checkSharedPreferences(){
        String checkbox=mPreferences.getString(getString(R.string.checkbox),"false");
        String name=mPreferences.getString(getString(R.string.name),"");
        String password=mPreferences.getString(getString(R.string.password),"");


        mName.setText(name);
        mPassword.setText(password);

        if (checkbox.equals("true")){
            mCheckbox.setChecked(true);
        }else{
            mCheckbox.setChecked(false);
        }
    }
}
