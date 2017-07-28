package com.example.fragmentexample2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.androidtown.ui.fragment.R;


public class ItemListFragment extends ListFragment {
	private OnListItemClickListener onListItemClickListener;
	private int index = -1;

	public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener) {
		this.onListItemClickListener = onListItemClickListener;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		if( context instanceof OnListItemClickListener == true ) {
			onListItemClickListener = (OnListItemClickListener)context;
		}
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter( ArrayAdapter.createFromResource(
						getActivity(),
						R.array.image_titles,
						android.R.layout.simple_list_item_1 )  );

		System.out.println( "onActivityCreated called:" + savedInstanceState );
		if( savedInstanceState != null ) {
			index = savedInstanceState.getInt( "index", 0 );
			if( onListItemClickListener != null ){
				onListItemClickListener.onListItemClick( index );
			}
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		index = position;
		if( onListItemClickListener != null ) {
			onListItemClickListener.onListItemClick( index );
		}
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		System.out.println( "=====> onSaveInstanceState called");
		outState.putInt( "index", index );
		super.onSaveInstanceState(outState);
	}

	public interface OnListItemClickListener {
		void onListItemClick(int index);
	}
}
