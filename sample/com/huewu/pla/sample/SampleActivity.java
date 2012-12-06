package com.huewu.pla.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.smaple.R;
import com.lurencun.android.adapter.AbstractAdapter;
import com.lurencun.android.adapter.CommonAdapter;
import com.lurencun.android.adapter.ViewBuilder;

public class SampleActivity extends Activity {

	private MultiColumnListView mAdapterView = null;
	private AbstractAdapter<Integer> mAdapter = null;
	private Random RND = new Random();
	
	int[] imageResource = {
			R.drawable.image_1,
			R.drawable.image_2,
			R.drawable.image_3,
			R.drawable.image_4,
			R.drawable.image_5,
			R.drawable.image_6,
			R.drawable.image_7,
			R.drawable.image_8,
			R.drawable.image_9,
			R.drawable.image_10,
			R.drawable.image_11,
			R.drawable.image_12,
			R.drawable.image_13,
			R.drawable.image_14,
			R.drawable.image_15,
			R.drawable.image_16,
			R.drawable.image_17,
			R.drawable.image_18,
			R.drawable.image_19,
			R.drawable.image_20,
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_sample);
		mAdapterView = (MultiColumnListView) findViewById(R.id.list);
		initAdapter();
		mAdapterView.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, 1001, 0, "Load More Contents");
		menu.add(Menu.NONE, 1002, 0, "Launch Pull-To-Refresh Activity");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()){
		case 1001:
		{
			int count = imageResource.length/2 + RND.nextInt(imageResource.length/2);
			List<Integer> data = new ArrayList<Integer>();
			for(int i=0;i<count;i++){
				data.add(imageResource[i]);
			}
			
			mAdapter.add(data);
		}
		break;
		case 1002:
		{
			Intent intent = new Intent(this, PullToRefreshSampleActivity.class);
			startActivity(intent);
		}
		break;
		}
		return true;
	}

	
	private void initAdapter() {
		mAdapter = new CommonAdapter<Integer>(getLayoutInflater(), new ViewBuilder<Integer>(){

			@Override
			public View createView(LayoutInflater inflater, int position,
					Integer data) {
				View view = inflater.inflate(R.layout.item_sample, null);
				updateView(view, position, data);
				return view;
			}

			@Override
			public void updateView(View view, int position, Integer data) {
				ImageView image = (ImageView) view.findViewById(R.id.thumbnail);
//				image.setAdjustViewBounds(true);
				image.setImageResource(data);
			}
			
		});
		
		int count = imageResource.length/2 + RND.nextInt(imageResource.length/2);
		List<Integer> data = new ArrayList<Integer>();
		for(int i=0;i<count;i++){
			data.add(imageResource[i]);
		}
		
		mAdapter.update(data);
	}

}//end of class
