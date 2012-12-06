package com.huewu.pla.sample;

import android.os.Bundle;
import android.os.Handler;

import com.huewu.pla.lib.MultiColumnPullToRefreshListView;
import com.huewu.pla.lib.MultiColumnPullToRefreshListView.OnRefreshListener;
import com.huewu.pla.smaple.R;

public class PullToRefreshSampleActivity extends SampleActivity {

	private MultiColumnPullToRefreshListView mPulltoRefreshListView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_pull_to_refresh_sample);
		mPulltoRefreshListView = (MultiColumnPullToRefreshListView) findViewById(R.id.list);
		
		initAdapter();
		mPulltoRefreshListView.setAdapter(mAdapter);
		mPulltoRefreshListView.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				//5秒后完成
				new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						mPulltoRefreshListView.onRefreshComplete();
					}
				}, 5000);
			}
		});
	}

}//end of class
