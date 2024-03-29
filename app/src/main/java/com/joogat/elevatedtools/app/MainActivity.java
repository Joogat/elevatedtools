package com.joogat.elevatedtools.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.joogat.elevatedtools.ElevatedDock;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ElevatedDock menuDock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuDock = findViewById(R.id.menu_dock);
        Log.e("tag","=====");
        menuDock.setPopupRouter(new MenuPopupRouter());
        findViewById(R.id.text).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        menuDock.show(MainMenuPopup.ID);
    }

    @Override
    public void onBackPressed() {
        if(menuDock.isActive()){
            menuDock.dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
