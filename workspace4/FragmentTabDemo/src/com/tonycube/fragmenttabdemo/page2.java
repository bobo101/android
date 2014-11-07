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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class page2 extends Fragment {
	private String value = "";
	private ListView listView;
	
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
		((MainActivity) getActivity()).setActionBarTitle("牙科初診");
		v = inflater.inflate(R.layout.page2, container, false);
        listView = (ListView)v.findViewById(R.id.listView1);
        final String[] arr = new String[]{
        		"選擇醫師","選擇時間"
        };
        ArrayAdapter<String> adapter = 
            new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "你按下"+arr[position], Toast.LENGTH_SHORT).show();
                if(position==0){
                	Fragment newFragment = new SelectDoctor();
                	FragmentTransaction transaction = getFragmentManager().beginTransaction();

                	// Replace whatever is in the fragment_container view with this fragment,
                	// and add the transaction to the back stack
                	transaction.replace(R.id.realtabcontent, newFragment);
                	transaction.addToBackStack(null);

                	// Commit the transaction
                	transaction.commit();
                }
                else if(position==1){ 
                	// Create new fragment and transaction
                	Fragment newFragment = new SelectTime();
                	FragmentTransaction transaction = getFragmentManager().beginTransaction();

                	// Replace whatever is in the fragment_container view with this fragment,
                	// and add the transaction to the back stack
                	transaction.replace(R.id.realtabcontent, newFragment);
                	transaction.addToBackStack(null);

                	// Commit the transaction
                	transaction.commit();
                }
                
            }
       
        });
        return v;
        }
}
