package com.wang.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.timetable.R;
import com.wang.service.ImgService;

public class TableActivity extends Activity {
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
	private final int FP = ViewGroup.LayoutParams.FILL_PARENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int screenWidth = (getWindowManager().getDefaultDisplay().getWidth() - 30);
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
		setContentView(R.layout.table_activity);
		TableLayout tableLayout = (TableLayout) findViewById(R.id.tableAc_table);
		RelativeLayout reLayout = (RelativeLayout) findViewById(R.id.tableAc_time);
		RelativeLayout midLayout = (RelativeLayout) findViewById(R.id.tableAc_middle);
		for (int row = 0; row < 13; row++) {
			int hgt = 0;
			TableRow tableRow = new TableRow(this);
			for (int col = 0; col < 7; col++) {
				TextView tv = new TextView(this);
				tv.setBackgroundResource(R.drawable.shapee);
				tv.setHeight(screenHeight / 13);
				tv.setWidth(screenWidth / 7);
				System.out.println(screenWidth/7);
				hgt = screenHeight / 13;
				tv.getBackground().setAlpha(200);
				tableRow.addView(tv);
			}
			tableLayout.addView(tableRow, new TableLayout.LayoutParams(FP, WC));
			if (row > 0 && row < 13) {
				TextView tv = new TextView(this);
				tv.setWidth(30);
				tv.setGravity(Gravity.CENTER);
				Integer txt = 8 + row;
				tv.setText(txt.toString());
				tv.setY(hgt * row - 10);
				System.out.println(hgt*row);
				reLayout.addView(tv);
			}
		}
		RelativeLayout course = new RelativeLayout(this);
		RelativeLayout.LayoutParams itemParam = new RelativeLayout.LayoutParams(
				41, 72);
		course.setLayoutParams(itemParam);
		course.setX(30);
		course.setY(36);
		
		Drawable btnDrawable = getBaseContext().getResources().getDrawable(R.drawable.pink_bg);
		BitmapDrawable bd = (BitmapDrawable) btnDrawable;
		Bitmap bm = bd.getBitmap();
		ImageView dd = new ImageView(this);
		dd.setPadding(1, 1, 1, 1);
		dd.setImageBitmap(ImgService.createFramedPhoto(41,72,bm,5));
		RelativeLayout.LayoutParams em =new RelativeLayout.LayoutParams(WC, WC);
		course.addView(dd,em);
		TextView tv= new TextView(this);
		tv.setText("高数");
		tv.setWidth(41);
		tv.setHeight(72);
		tv.setPadding(1, 1, 1, 1);
		tv.setTextColor(Color.WHITE);
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(10);
		course.addView(tv,em);
		
		midLayout.addView(course, new RelativeLayout.LayoutParams(WC, WC));
	}

}
