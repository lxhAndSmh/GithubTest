package com.liuxuhui.githuptest.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.liuxuhui.githuptest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
* 项目名称：MainActivity
* 类描述：Material之NavigationView导航的使用
* 创建人：liuxuhui
* 创建时间：2017/2/9 18:45
* 修改人：liuxuhui
* 修改时间：2017/2/9 18:45
* 修改备注：
* @version
*/
public class MainActivity extends AppCompatActivity{

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //nothing
        initData();
    }

    public void initData(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.button1:
                        Intent intent = new Intent(MainActivity.this, BehaviorActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button2:
                        intent = new Intent(MainActivity.this, TableLayoutActivity.class);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                        } else {
                            startActivity(intent);
                        }
                        break;

                    case R.id.button3:
                        intent = new Intent(MainActivity.this, CollapsingToolbarActivity.class);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                        } else {
                            startActivity(intent);
                        }
                        break;
                    case R.id.button4:
                        Toast.makeText(MainActivity.this, "更多", Toast.LENGTH_SHORT).show();
                        textView.setText("更多");
                        break;
                    case R.id.button5:
                        Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
                        textView.setText("关于");
                        break;
                    case R.id.button6:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        textView.setText("设置");
                        break;
                }
                item.setChecked(true);//改变item的选中状态
                drawerLayout.closeDrawers();// 关闭导航菜单
                return true;
            }
        });
    }

}
