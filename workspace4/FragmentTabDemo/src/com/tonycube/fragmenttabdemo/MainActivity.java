package com.tonycube.fragmenttabdemo;

import com.tonycube.demo.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
	
		FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		
		//1 add tab here
		tabHost.addTab(tabHost.newTabSpec("tab1")
			   				  .setIndicator("預約看診", this.getResources().getDrawable(R.drawable.ic_launcher)),			   				  
   					  AppleFragment.class, null);
	    //2
		tabHost.addTab(tabHost.newTabSpec("tab2")
				   			  .setIndicator("聯絡我們"), 
					  GoogleFragment.class, 
					  null);
	    //3
		tabHost.addTab(tabHost.newTabSpec("tab3")
				   			  .setIndicator("預約紀錄"), 
					  FacebookFragment.class, 
				      null);
	    //4
		tabHost.addTab(tabHost.newTabSpec("tab4")
			   				  .setIndicator("就診訊息"), 
					  TwitterFragment.class, 
					  null);
		//5
		tabHost.addTab(tabHost.newTabSpec("tab5")
 				  			  .setIndicator("設定"), 
 				  	 SettingFragment.class, 
 				  	  null);
		//ft.detach(mLastTab.fragment);
	}

	/**************************
	 * 
	 * 		給子頁籤呼叫用
	 * 
	 **************************/
	
	public String getAppleData(){
		return "預約看診";
	}

	public String getGoogleData(){
		return "聯絡我們";
	}
	
	public String getFacebookData(){
		return "Facebook 789";
	}
	
	public String getTwitterData(){
		return "Twitter abc";
	}
	public String getSettingData(){
		return "Setting def";
	}
	public void setActionBarTitle(String title) {
	    getActionBar().setTitle(title);
	}
	@Override
	protected void onSaveInstanceState(Bundle bundle) {
	    // Empty
	}
}
