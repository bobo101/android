package com.tonycube.fragmenttabdemo;

import com.tonycube.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SelectDoctor extends Fragment{
	private String value = "";
	private ListView listView;
	private ArrayAdapter<String> listAdapter;
	private View v;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("=====>", "AppleFragment onAttach");
		MainActivity mainActivity = (MainActivity)activity;
		value = mainActivity.getAppleData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d("=====>", "AppleFragment onCreateView");
		// Set title bar
	    ((MainActivity) getActivity()).setActionBarTitle("選擇醫師");
		v = inflater.inflate(R.layout.frg_apple, container, false);
        listView = (ListView)v.findViewById(R.id.listView1);
        final String[] arr = new String[]{
        		"黃醫生","張醫生"
        };
        ArrayAdapter<String> adapter = 
            new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener()
        {

            public void onItemClick(AdapterView<?> parent, View view, int position,long id) 
            {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "你按下"+arr[position], Toast.LENGTH_SHORT).show();
                
            }
       
        });
        return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Log.d("=====>", "AppleFragment onActivityCreated");
	}

}
