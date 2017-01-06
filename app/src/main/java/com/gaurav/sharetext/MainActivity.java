package com.gaurav.sharetext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button shareButton,clearButton;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shareButton = (Button) findViewById(R.id.share_btn);
        clearButton = (Button) findViewById(R.id.clear_btn);
        text = (EditText) findViewById(R.id.editText);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = text.getText().toString();
                if(!message.equals(""))
                {
                    Intent messageSendIntent = new Intent();
                    messageSendIntent.setAction(Intent.ACTION_SEND);
                    messageSendIntent.putExtra(Intent.EXTRA_TEXT,message);
                    messageSendIntent.setType("text/plain");
                    startActivity(Intent.createChooser(messageSendIntent, "Choose your favourite...."));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please.Write somthing." ,Toast.LENGTH_SHORT).show();
                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });
    }
}
