package com.alexvo.codingandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferenceActivity extends AppCompatActivity {

    @BindView(R.id.edittext1)
    EditText edittext1;
    @BindView(R.id.edittext2)
    EditText edittext2;
    @BindView(R.id.edittext3)
    EditText edittext3;
    @BindView(R.id.edittext4)
    EditText edittext4;
    @BindView(R.id.load)
    Button load;
    @BindView(R.id.save)
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.load)
    public void onLoadClicked() {
    }

    @OnClick(R.id.save)
    public void onSaveClicked() {
    }
}
