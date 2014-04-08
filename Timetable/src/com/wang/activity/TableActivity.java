package com.wang.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.timetable.R;

public class TableActivity extends Activity {
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
	private final int FP = ViewGroup.LayoutParams.FILL_PARENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int screenWidth = (getWindowManager().getDefaultDisplay().getWidth()-30);	
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();	
		setContentView(R.layout.table_activity);
		TableLayout tableLayout = (TableLayout) findViewById(R.id.tableAc_table);
		// 全部列自动填充空白处
		// 生成10行，8列的表格
		for (int row = 0; row < 13; row++) {
			TableRow tableRow = new TableRow(this);
			for (int col = 0; col < 7; col++) {
				TextView tv = new TextView(this);
				tv.setBackgroundResource(R.drawable.shapee);
				tv.setHeight(screenHeight/13);
				tv.setWidth(screenWidth/7);
				tv.getBackground().setAlpha(200);
				tableRow.addView(tv);
			}
			// 新建的TableRow添加到TableLayout
			tableLayout.addView(tableRow, new TableLayout.LayoutParams(FP, WC));
		}
		
		LinearLayout linearLayout =(LinearLayout)findViewById(R.id.tableAc_time);
		TextView tv = new TextView(this);
		tv.setGravity(Gravity.RIGHT);
		tv.setText("8");
		linearLayout.addView(tv);
	}

}
