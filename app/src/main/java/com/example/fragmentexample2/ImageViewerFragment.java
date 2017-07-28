package com.example.fragmentexample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidtown.ui.fragment.R;

public class ImageViewerFragment extends Fragment {

	String[] imageTitles = { "Dream 01", "Dream 02", "Dream 03" };
	int[] imageLocations = { R.drawable.dream01, R.drawable.dream02, R.drawable.dream03 };

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate( R.layout.fragment_imageviewer, null );
	}

	public void updateView( int index ) {
		TextView textView =
				(TextView)getView().findViewById( R.id.title );
		ImageView imageView =
				(ImageView)getView().findViewById( R.id.image );

		textView.setText( imageTitles[ index ] );
		imageView.setImageResource( imageLocations[ index ] );
	}
}