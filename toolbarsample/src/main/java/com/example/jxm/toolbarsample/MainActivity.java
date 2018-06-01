package com.example.jxm.toolbarsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast t=Toast.makeText(MainActivity.this,"id="+item.getItemId(),Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER,0,0);
                        t.show();

                        CustomPopWindow.showPop(MainActivity.this);
              //item.setChecked(true);
                if(item.isChecked()){//更改菜单项的选中状态
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.setGroupCheckable(R.id.group2, true, true);//实现代码
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(MainActivity.this,"点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
