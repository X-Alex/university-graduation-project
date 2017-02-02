package com.exam.viewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private List<View> list;
	private ArrayList<View> arraylist;
	private View view1,view2,view3;
	private ViewPagerAdapter adapter;
	private ViewPager viewpager;
	private int oldItem=0;
	private int currentItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	@SuppressWarnings("deprecation")
	private void init() {
		// TODO Auto-generated method stub
		arraylist=new ArrayList<View>();
		arraylist.add(findViewById(R.id.view1));
		arraylist.add(findViewById(R.id.view2));
		arraylist.add(findViewById(R.id.view3));


		LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
		list=new ArrayList<View>();
		view1 = inflater.inflate(R.layout.view1, null);
		view2 = inflater.inflate(R.layout.view2, null);
		view3 = inflater.inflate(R.layout.view3, null);
		list.add(view1);
		list.add(view2);
		list.add(view3);
		
		adapter = new ViewPagerAdapter(MainActivity.this, list);
		viewpager = (ViewPager) findViewById(R.id.main_viewpager);
		viewpager.setAdapter(adapter);
		
		arraylist.get(oldItem).setBackgroundResource(R.drawable.viewcro2);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				currentItem=position;
				arraylist.get(oldItem).setBackgroundResource(R.drawable.viewcro);
				arraylist.get(currentItem).setBackgroundResource(R.drawable.viewcro2);
				oldItem=currentItem;
				switch (position) {
				case 0:
					ImageView imageview1=(ImageView) view1.findViewById(R.id.view1_image);
					Animation animation1=AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
					imageview1.startAnimation(animation1);
					
					break;
				case 1:
//					Toast.makeText(MainActivity.this, "dierye", 0).show();
					ImageView imageview=(ImageView) view2.findViewById(R.id.view2_image);
					Animation animation=AnimationUtils.loadAnimation(MainActivity.this, R.anim.tran);
					imageview.startAnimation(animation);
					imageview.setVisibility(View.VISIBLE);
					break;
				case 2:
					Toast.makeText(MainActivity.this, "disanye", 0).show();
					break;

				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
