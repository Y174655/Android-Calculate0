package com.example.calculator0;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.calculator0.FragmentOrdinary;
import com.example.calculator0.FragmentTranslate;

public class MainActivity extends Activity implements OnItemClickListener {
    private ListView lv_selection;
    private String[] str_selection={"普通计算","进制转换","矩阵运算"};
    private ArrayAdapter<String> adapter;
    private DrawerLayout drawer_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        drawer_layout=(DrawerLayout) findViewById(R.id.drawer_layout);
        getFragmentManager().beginTransaction().replace(R.id.ly_content,new FragmentOrdinary())
                .commit();//初始界面
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_selection);
        lv_selection=(ListView) findViewById(R.id.list_left_drawer);
        lv_selection.setAdapter(adapter);
        lv_selection.setOnItemClickListener(this);

        drawer_layout.openDrawer(Gravity.LEFT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        switch(position){
            case 0:
                getFragmentManager().beginTransaction().replace(R.id.ly_content,new FragmentOrdinary()).commit();
                drawer_layout.closeDrawer(lv_selection);
                break;
            case 1:
                getFragmentManager().beginTransaction().replace(R.id.ly_content,new FragmentTranslate()).commit();
                drawer_layout.closeDrawer(lv_selection);
                break;

        }




    }
}
