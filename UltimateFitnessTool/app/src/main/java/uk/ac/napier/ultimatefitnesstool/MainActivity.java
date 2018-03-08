package uk.ac.napier.ultimatefitnesstool;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.content.DialogInterface.*;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText age;
    private EditText email;
    private EditText pass;

    private String myHeight, myAge, myWeight, myEmail, myPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {
                EditText email = (EditText) findViewById(R.id.editTextEmail);
                EditText pass = (EditText) findViewById(R.id.editTextPass);
                EditText height = (EditText) findViewById(R.id.editTextHeight);
                EditText weight = (EditText) findViewById(R.id.editTextWeight);
                EditText age = (EditText) findViewById(R.id.editTextAge);
                //RadioButton radiobutton = (RadioButton)group.findViewById (checkedId);

                //store the obtained text in a string
                myEmail = email.getText().toString();
                myPass = pass.getText().toString();
                myHeight = height.getText().toString();
                myWeight = weight.getText().toString();
                myAge = age.getText().toString();

                email.setText("");
                pass.setText("");
                height.setText("");
                weight.setText("");
                age.setText("");


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }

        });
    }
}
