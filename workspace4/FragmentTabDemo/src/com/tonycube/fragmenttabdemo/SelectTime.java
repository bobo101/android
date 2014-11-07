package com.tonycube.fragmenttabdemo;

import java.util.Calendar;
import java.util.Locale;

import com.tonycube.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SelectTime extends Fragment{
	private String value = "";
	private View v;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("=====>", "SelectTimeFragment onAttach");
		
		MainActivity mainActivity = (MainActivity)activity;
		value = mainActivity.getGoogleData();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d("=====>", "SelectTimeFragment onCreateView");
		((MainActivity) getActivity()).setActionBarTitle("選擇時間");
		 v=inflater.inflate(R.layout.select_time, container, false);
		 Calendar c = Calendar.getInstance();
		 int year = c.get(Calendar.YEAR);                      //取出年
		 int month = c.get(Calendar.MONTH) + 1;           //取出月，月份的編號是由0~11 故+1
		 int day = c.get(Calendar.DAY_OF_MONTH);        //取出日
		 int weekday = c.get(Calendar.DAY_OF_WEEK);   //取出星期幾，編號由Sunday(1)~Saturday(7)
		 Log.d("=====>", Integer.toString(year)+Integer.toString(month)+Integer.toString(day));
		 return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("=====>", "SelectTimeFragment onActivityCreated");
		
	}

}
