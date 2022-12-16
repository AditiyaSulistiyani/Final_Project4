package com.kampusmerdeka.finalproject4.Started;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kampusmerdeka.finalproject4.NavBarActivity;
import com.kampusmerdeka.finalproject4.R;

public class GetStartedActivity extends AppCompatActivity {
    private Button btnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        btnMainMenu = findViewById(R.id.btnMainMenu);

        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent(getApplicationContext(), NavBarActivity.class);
                startActivity(menu);

            }
        });
    }
}