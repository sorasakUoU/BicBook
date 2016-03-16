package kawinpart.sorasak.bicbook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText idCardEditText, passwordEditText;
    private String idCardString, passwordString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        bindwidget();



    } //Main Method

    private void bindwidget() {

        idCardEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);

    }

    public void clickSignUpSign(View view) {

        idCardString = idCardEditText.getText().toString().trim();
        passwordString = idCardEditText.getText().toString().trim();

        //Check Space
        if (idCardString.equals("") || passwordString.equals("")) {
            //Have Space
            myToast("กรุณากรอกให้ครบ ค่ะ");



        } else {
            //No Space
            //Log.d("test", "L = " + idCardString.length());
            checkIDcard();

        }

    } //clickSignUp

    private void checkIDcard() {
        if (idCardString.length() == 13) {
            //id card True
            confirmData(idCardString, passwordString);


        } else {
            //id card False
            myToast("รหัสบัตรไม่ถูกต้อง ค่ะ");

        }
    } //checkIdCard

    private void confirmData(String idCardString, String passwordString) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.icon_myaccount);
        builder.setTitle("โปรดตรวจสอบข้อมูล");
        builder.setMessage("รหัสบัตรประชาชน = " + idCardString + "\n" +
                "Password = " + passwordString);
        builder.setCancelable(false);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updataDataToServer();
            } // OnClick
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            } // OnClick
        });
        builder.show();
    } // confirmData

    private void updataDataToServer() {

    } // updataToServer

    private void myToast(String strToast) {
        Toast.makeText(SignUpActivity.this, strToast, Toast.LENGTH_SHORT).show();
    }

} //Main Class
