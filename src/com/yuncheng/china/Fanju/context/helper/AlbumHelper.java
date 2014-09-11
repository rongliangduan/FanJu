package com.yuncheng.china.Fanju.context.helper;

import android.content.ContentResolver;

import com.yuncheng.china.Fanju.context.AppContext;
import com.yuncheng.china.Fanju.ui.common.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agonyice on 14-9-10.
 */
public class AlbumHelper {
	private static final AlbumHelper INSTANCE = new AlbumHelper();
	private static AppContext AppContext;
	private static ContentResolver ContentResolver;
	private static List<Album> albumList = new ArrayList<Album>();
	private AlbumHelper(){
		//AppContext= AppContext.getA
	}


}
