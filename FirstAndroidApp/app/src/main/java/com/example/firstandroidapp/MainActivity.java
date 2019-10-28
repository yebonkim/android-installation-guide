package com.example.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_NAME = "name";

    @BindView(R.id.edit_text)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private boolean isValid(String name) {
        if(name.length() != 2) {
            return false;
        }

        if(StringUtil.isKorean(name) == false) {
            return false;
        }

        return true;
    }

    @OnClick(R.id.button_result)
    public void onSeeResultBtnClicked() {
        String nameStr = editText.getText().toString();

        if(nameStr.equals("")) {
            Toast.makeText(this, getString(R.string.msg_input_name), Toast.LENGTH_SHORT).show();
        } else if(isValid(nameStr) == false) {
            Toast.makeText(this, getString(R.string.error_invalid_name), Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, ResultActivity.class).putExtra(EXTRA_NAME, nameStr));
        }
    }
}
