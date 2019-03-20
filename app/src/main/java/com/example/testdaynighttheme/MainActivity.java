package com.example.testdaynighttheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView textView;
    private Button button;
    private Switch switchTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = this.findViewById(R.id.linear_background);
        textView = this.findViewById(R.id.tv);
        button = this.findViewById(R.id.btn);
        switchTheme = this.findViewById(R.id.switch_theme);

        switchTheme.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES);

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean isNightMode = isChecked;
                if (isNightMode) {
                    getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    recreate();
                } else {
                    getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    recreate();
                }
            }
        });
    }
}
