package com.example.student.rabonefootbol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {
    private Button addButton;
    final static String KEY = "KEY";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        addButton = (Button) findViewById(R.id.button_add);
        editText = (EditText) findViewById(R.id.edit_post);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra(KEY, editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
