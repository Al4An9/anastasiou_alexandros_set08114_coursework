package uk.ac.napier.ultimatefitnesstool.Activities;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.ac.napier.ultimatefitnesstool.Model.User;
import uk.ac.napier.ultimatefitnesstool.R;
import uk.ac.napier.ultimatefitnesstool.helper.InputValidation;
import uk.ac.napier.ultimatefitnesstool.sql.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollViewRegister;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;
    private TextInputLayout textInputLayoutHeight;
    private TextInputLayout textInputLayoutWeight;
    private TextInputLayout textInputLayoutAge;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;
    private TextInputEditText textInputEditTextHeight;
    private TextInputEditText textInputEditTextWeight;
    private TextInputEditText textInputEditTextAge;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView textViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();

    }
    private void initViews(){
        nestedScrollViewRegister = (NestedScrollView) findViewById(R.id.nestedScrollViewRegister);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);
        textInputLayoutHeight = (TextInputLayout) findViewById(R.id.textInputLayoutHeight);
        textInputLayoutWeight = (TextInputLayout) findViewById(R.id.textInputLayoutWeight);
        textInputLayoutAge = (TextInputLayout)findViewById(R.id.textInputLayoutAge);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);
        textInputEditTextHeight = (TextInputEditText) findViewById(R.id.textInputEditTextHeight);
        textInputEditTextWeight = (TextInputEditText) findViewById(R.id.textInputEditTextWeight);
        textInputEditTextAge = (TextInputEditText)findViewById(R.id.textInputEditTextAge);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCombatButtonRegister);
        textViewLoginLink = (AppCompatTextView) findViewById(R.id.textViewLoginLink);
    }

    private void initListeners(){
        appCompatButtonRegister.setOnClickListener(this);
        textViewLoginLink.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
        user = new User();
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.appCombatButtonRegister:
                postDataToSQLite();
                break;
            case R.id.textViewLoginLink:
                finish();
                break;
        }
    }

    //checks for validations in the registry form & if user already exists
    private void postDataToSQLite(){
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))){
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))){
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))){
            return;
        }

        if(databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())){

            user.setName(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());
            user.setHeight(textInputEditTextHeight.getText().toString().trim());
            user.setWeight(textInputEditTextWeight.getText().toString().trim());
            user.setAge(textInputEditTextAge.getText().toString().trim());

            databaseHelper.addUser(user);

            //Snackbar to show success message that record saved successfully
            Snackbar.make(nestedScrollViewRegister, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
        }else{
            //Snackbar to show error message that record already exists
            Snackbar.make(nestedScrollViewRegister, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText(){
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
        textInputEditTextHeight.setText(null);
        textInputEditTextWeight.setText(null);
        textInputEditTextAge.setText(null);
    }
}
