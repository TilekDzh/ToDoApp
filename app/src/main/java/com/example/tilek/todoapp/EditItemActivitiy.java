package com.example.tilek.todoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivitiy extends AppCompatActivity {

    private EditText etItemBody;

    private int itemPosition;
    private String itemBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemPosition = getIntent().getIntExtra("position", 0);
        itemBody = getIntent().getStringExtra("body");

        setContentView(R.layout.activity_edit_item_activitiy);
        etItemBody = (EditText)findViewById(R.id.etItemBody);

        etItemBody.setText(itemBody);
        etItemBody.setSelection(itemBody.length());
        etItemBody.requestFocus();
    }

    public void onSave(View view) {
        itemBody = ((EditText) findViewById(R.id.etItemBody)).getText().toString();

        Intent data = new Intent();
        data.putExtra("body", itemBody);
        data.putExtra("position", itemPosition);

        setResult(RESULT_OK, data);

        this.finish();
    }
}
