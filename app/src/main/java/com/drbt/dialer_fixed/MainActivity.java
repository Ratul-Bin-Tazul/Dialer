package com.drbt.dialer_fixed;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.drbt.dialer_fixed.R;

public class MainActivity extends AppCompatActivity {
    EditText number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        ImageButton dltInput = (ImageButton)findViewById(R.id.dltBtn);

        final Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnStar,btnHash;
        number = (EditText) findViewById(R.id.number);
        btn0 = (Button)findViewById(R.id.zero);
        btn1 = (Button)findViewById(R.id.one);
        btn2 = (Button)findViewById(R.id.two);
        btn3 = (Button)findViewById(R.id.three);
        btn4 = (Button)findViewById(R.id.four);
        btn5 = (Button)findViewById(R.id.five);
        btn6 = (Button)findViewById(R.id.six);
        btn7 = (Button)findViewById(R.id.seven);
        btn8 = (Button)findViewById(R.id.eight);
        btn9 = (Button)findViewById(R.id.nine);
        btnStar = (Button)findViewById(R.id.star);
        btnHash = (Button)findViewById(R.id.hash);

        btn0.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"0");
                        //changeColor(btn0);
                    }
                }
        );

        btn1.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"1");
                    }
                }
        );

        btn2.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"2");
                    }
                }
        );


        btn3.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"3");
                    }
                }
        );


        btn4.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"4");
                    }
                }
        );


        btn5.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"5");
                    }
                }
        );


        btn6.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"6");
                    }
                }
        );


        btn7.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"7");
                    }
                }
        );


        btn8.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"8");
                    }
                }
        );


        btn9.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"9");
                    }
                }
        );


        btnStar.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"*");
                    }
                }
        );


        btnHash.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"#");
                    }
                }
        );



        //delete button function
        dltInput.setOnClickListener(
                new ImageButton.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = number.getText().toString();
                        if(!s.equals("")) {
                            number.setText(s.substring(0, s.length() - 1));
                        }
                    }
                }
        );

        dltInput.setOnLongClickListener(
                new ImageButton.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        number.setText("");
                        return true;
                    }
                }
        );



    }

    public void changeColor(View view) {
        Drawable d = view.getBackground();
        view.setBackgroundColor(Color.BLUE);

        //wait(500);




    }

    public void call(View view) {

        ImageButton b = (ImageButton) findViewById(R.id.callButton);
        //b.setBackgroundColor(Color.GREEN);
       // b.setBackground(getDrawable(R.drawable.ic_menu_call));


        number = (EditText) findViewById(R.id.number);
        String numberString = number.getText().toString();
        if(!numberString.equals("")) {

            if (numberString.charAt(numberString.length() - 1) == '#') {
                numberString=numberString.substring(0,numberString.length()-1)+Uri.encode("#");
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numberString));

                startActivity(i);
            }else{
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numberString));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(i);
        }
        }else {
            Toast.makeText(this,"Please input a numbr",Toast.LENGTH_SHORT).show();
        }
    }

    public void showNumber(View view) {
        Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnStar,btnHash;
        LinearLayout numLayout = (LinearLayout)findViewById(R.id.numLayout);
        number = (EditText) findViewById(R.id.number);
        int i = numLayout.getFocusedChild().getId();
        Toast.makeText(this,""+i,Toast.LENGTH_SHORT).show();

        btn0 = (Button)findViewById(R.id.zero);
        btn1 = (Button)findViewById(R.id.one);
        btn2 = (Button)findViewById(R.id.two);
        btn3 = (Button)findViewById(R.id.three);
        btn4 = (Button)findViewById(R.id.four);
        btn5 = (Button)findViewById(R.id.five);
        btn6 = (Button)findViewById(R.id.six);
        btn7 = (Button)findViewById(R.id.seven);
        btn8 = (Button)findViewById(R.id.eight);
        btn9 = (Button)findViewById(R.id.nine);
        btnStar = (Button)findViewById(R.id.star);
        btnHash = (Button)findViewById(R.id.hash);

        btn0.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number.setText(number.getText().toString()+"0");
                    }
                }
        );

    }




}
