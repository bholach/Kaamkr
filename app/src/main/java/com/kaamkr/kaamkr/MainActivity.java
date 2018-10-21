package com.kaamkr.kaamkr;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kaamkr.kaamkr.controller.LoginRegisterAdapter;

public class MainActivity extends AppCompatActivity {

    ImageView dots;
    Button loginbtn,regbtn;
    private int dots_id[] = {R.drawable.login_dot,R.drawable.register_dot};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login Page");

        dots = findViewById(R.id.dots);


        ViewPager viewPager = findViewById(R.id.login_register_pager);
        viewPager.setAdapter(new LoginRegisterAdapter(MainActivity.this));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if(position==1){
                    getSupportActionBar().setTitle("Signup Page");
                }
                else{
                    getSupportActionBar().setTitle("Login Page");
                }
                    dots.setImageResource(dots_id[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void loginUser(View v){
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }
    public void regUser(View v){
        Toast.makeText(this, "Register btn", Toast.LENGTH_SHORT).show();
    }
    public void gotoWorkerReg(View v){
        startActivity(new Intent(this,WorkerRegActivity.class));
    }
}
