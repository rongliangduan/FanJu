package com.yuncheng.china.Fanju.ui.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agonyice on 14-9-10.
 */
public class Album {
	private String bucketName;
	private List<String>imagePathList=new ArrayList<String>();
	private List<String>selectedImagePathList=new ArrayList<String>();
	public  Album (String bucketName){
		this.bucketName=bucketName;
	}
	public Album(String bucketName,List<String>imagePathList){
		this.bucketName=bucketName;
		this.imagePathList=imagePathList;
	}
	/*public void add(String imagePathList){
		imagePathList.add(imagePathList);
	}*/
}
