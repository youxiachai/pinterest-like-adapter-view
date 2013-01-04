package com.huewu.pla.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.MultiColumnListView.OnLoadMoreListener;
import com.huewu.pla.sample.internal.ImageWrapper;
import com.huewu.pla.sample.internal.ImgResource;
import com.huewu.pla.sample.internal.SimpleViewBuilder;
import com.lurencun.android.adapter.AbstractAdapter;
import com.lurencun.android.adapter.CommonAdapter;
import com.lurencun.android.system.ActivityUtil;

public class SampleActivity extends Activity {
	
	protected AbstractAdapter<ImageWrapper> mAdapter = null;
	public static final int PULL_TO_REFRESH_ID = 1008611;
	protected MultiColumnListView mWaterfallView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}
	
	protected void init(){
		setContentView(R.layout.act_sample);
		mWaterfallView = (MultiColumnListView) findViewById(R.id.list);
		initUIAction();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, PULL_TO_REFRESH_ID, 0, "启动<下拉刷新瀑布流>示例");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == PULL_TO_REFRESH_ID){
			Intent intent = new Intent(this, PullToRefreshSampleActivity.class);
			startActivity(intent);
		}
		return true;
	}

	protected void initUIAction() {
		mAdapter = new CommonAdapter<ImageWrapper>(getLayoutInflater(), new SimpleViewBuilder());
		mWaterfallView.setAdapter(mAdapter);
		mAdapter.update(ImgResource.genData());
		mWaterfallView.setOnLoadMoreListener(new OnLoadMoreListener() {
			@Override
			public void onLoadMore() {
				mAdapter.add(ImgResource.genData());
				mAdapter.notifyDataSetChanged();
				ActivityUtil.show(SampleActivity.this, "到List底部自动加载更多数据");
				//5秒后完成
				new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						mWaterfallView.onLoadMoreComplete();
					}
				}, 5000);
			}
		});
	}

}//end of class
