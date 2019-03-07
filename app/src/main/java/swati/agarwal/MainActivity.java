package swati.agarwal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    Button button;
    String s1,s2,s3,s4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s3=editText.getText().toString().trim();
                s4=editText2.getText().toString().trim();

                if (s1.equals(s3) && s2.equals(s4)) {
                    openActivity2();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("swati.agarwal",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username","swati.agarwal_mca18@gla.ac.in");
        editor.putString("password","123456");
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("swati.agarwal",MODE_PRIVATE);
        s1 = sharedPreferences.getString("username","swati.agarwal_mca18@gla.ac.in");
        s2 = sharedPreferences.getString("password","123456");
        editText.setText(s1);

    }



    public void openActivity2()
    {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}