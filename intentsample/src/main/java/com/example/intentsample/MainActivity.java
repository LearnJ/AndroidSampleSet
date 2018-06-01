package com.example.intentsample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open=findViewById(R.id.btn_open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                String title = getResources().getString(R.string.open);
                Intent chooseIntent=Intent.createChooser(intent,title);
                PackageManager pm=getPackageManager();
                List activities=pm.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
                Log.d("size", "onClick: "+activities.size());
               // startActivity(intent);
                if (activities.size()>0)
                    startActivity(chooseIntent);

                if(intent.resolveActivity(getPackageManager())!=null)
                    Log.d("intent", "onClick:resolveActivity "); ;

            }
        });
    }
}
