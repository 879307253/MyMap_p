package com.example.mymap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FrameActivity extends FragmentActivity {

    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtHome,rbtFunc,rbtSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment);
        mFragments = new Fragment[3];
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_main);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_func);
        mFragments[2] = fragmentManager.findFragmentById(R.id.fragment_setting);

        fragmentTransaction = fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();
        rbtHome = (RadioButton)findViewById(R.id.radioHome);
        rbtFunc = (RadioButton)findViewById(R.id.radioFunc);
        rbtSetting = (RadioButton)findViewById(R.id.radioSetting);
        rbtHome.setBackgroundResource(R.drawable.shape3);
        radioGroup = (RadioGroup)findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("radioGroup", "checkId=" + checkedId);
                fragmentTransaction = fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
                rbtHome.setBackgroundResource(R.drawable.shape2);
                rbtFunc.setBackgroundResource(R.drawable.shape2);
                rbtSetting.setBackgroundResource(R.drawable.shape2);
                switch(checkedId){
                    case R.id.radioHome:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtHome.setBackgroundResource(R.drawable.shape3);

                        break;
                    case R.id.radioFunc:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtFunc.setBackgroundResource(R.drawable.shape3);

                        break;
                    case R.id.radioSetting:
                        fragmentTransaction.show(mFragments[2]).commit();
                        rbtSetting.setBackgroundResource(R.drawable.shape3);

                        break;
                    default:
                        break;
                }
            }
        });
    }
    public void openOne(View btn){
        Intent hello = new Intent(FrameActivity.this, Main2Activity.class);
        startActivity(hello);
    }
    public void openTwo(View btn){
        Intent hello = new Intent(FrameActivity.this, HosListActivity.class);
        startActivity(hello);
    }
    public void openThree(View btn){
        Intent hello = new Intent(FrameActivity.this, MainActivity.class);
        startActivity(hello);
    }public void openFour(View btn){
        Intent hello = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:120"));
        startActivity(hello);
    }
    public void openFive(View btn){
        Intent hello = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:110"));
        startActivity(hello);
    }
    public void openSix(View btn){
        Intent hello = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"));
        startActivity(hello);
    }
    public void openSeven(View btn){
        Intent hello = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:158****9983"));
        startActivity(hello);
    }
    public void openEight(View btn){
        Intent hello = new Intent(Intent.ACTION_VIEW, Uri.parse("https://houqin.swufe.edu.cn/fwdh/ylfw.htm"));
        startActivity(hello);
    }

}