package com.google.developers.teapot.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.google.developers.teapot.R;
import com.google.developers.teapot.data.DataRepository;
import com.google.developers.teapot.data.TeaDao;
import com.google.developers.teapot.ui.SettingActivity;
import com.google.developers.teapot.ui.add.AddTeaActivity;
import com.google.developers.teapot.ui.list.TeaListActivity;
import com.google.developers.teapot.ui.timer.TimerActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TeaViewModel mViewModel;
//    private TeaViewModelFactory teaViewModelFactory;
//    private DataRepository dataRepository;
//    private TeaDao teaDao;


    private ImageView mTeaCardImage;
    private TextView mTeaName;
    private TextView mTeaDescription;
    private TextView mTeaType;
    private ImageView mFavorite;
    private Button mBtnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeaCardImage = findViewById(R.id.tea_card_image);
        mTeaName = findViewById(R.id.tea_name);
        mTeaDescription = findViewById(R.id.description);
        mTeaType = findViewById(R.id.tea_type);
        mFavorite = findViewById(R.id.favorite);
        mBtnMoreInfo = findViewById(R.id.btn_more_info);

        Glide.with(this).load(R.drawable.green_tea).into(mTeaCardImage);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_add:
                intent = new Intent(this, AddTeaActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_timer:
                intent = new Intent(this, TimerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_list:
                intent = new Intent(this, TeaListActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    private TeaViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        TeaViewModelFactory factory = TeaViewModelFactory.createFactory(MainActivity.this);
        return ViewModelProviders.of(activity, factory).get(TeaViewModel.class);
    }
}
