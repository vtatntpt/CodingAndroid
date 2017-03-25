package com.alexvo.codingandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    ArrayList<EditText> arrEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);

        arrEdittext = new ArrayList<>(Arrays.asList(edittext1, edittext2, edittext3, edittext4));

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPrefs.edit();
    }

    @OnClick(R.id.load)
    public void onLoadClicked() {
        Set<String> tasksSet = PreferenceManager.getDefaultSharedPreferences(this)
                .getStringSet("tasks_set", new HashSet<String>());

        List<String> tasksList = new ArrayList<String>(tasksSet);

        for(int i = 0; i < tasksList.size(); i++){
            arrEdittext.get(i).setText(tasksList.get(i));
        }
    }

    @OnClick(R.id.save)
    public void onSaveClicked() {

        ArrayList<String> Listtasks = new ArrayList<String>();

        for (EditText itemEdittext : arrEdittext){
            Listtasks.add(itemEdittext.getText().toString());
        }

        Set<String> tasksSet = new HashSet<String>(Listtasks);
        sharedPrefs.edit()
                .putStringSet("tasks_set", tasksSet)
                .commit();
    }
}
