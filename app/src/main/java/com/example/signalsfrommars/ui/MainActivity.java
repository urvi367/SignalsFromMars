package com.example.signalsfrommars.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.signalsfrommars.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.startButton);
        nameEditText = (EditText) findViewById(R.id.nameEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                if(name==null || name.equals(""))
                    name="Friend";

                intent = new Intent(MainActivity.this , StoryActivity.class);
                intent.putExtra(getString(R.string.key_name), name);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameEditText.setText("");
    }
}
