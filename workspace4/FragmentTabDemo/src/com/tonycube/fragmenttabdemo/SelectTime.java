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
		((MainActivity) getActivity()).setActionBarTitle("��ܮɶ�");
		 v=inflater.inflate(R.layout.select_time, container, false);
		 Calendar c = Calendar.getInstance();
		 int year = c.get(Calendar.YEAR);                      //���X�~
		 int month = c.get(Calendar.MONTH) + 1;           //���X��A������s���O��0~11 �G+1
		 int day = c.get(Calendar.DAY_OF_MONTH);        //���X��
		 int weekday = c.get(Calendar.DAY_OF_WEEK);   //���X�P���X�A�s����Sunday(1)~Saturday(7)
		 Log.d("=====>", Integer.toString(year)+Integer.toString(month)+Integer.toString(day));
		 return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("=====>", "SelectTimeFragment onActivityCreated");
		
	}

}
