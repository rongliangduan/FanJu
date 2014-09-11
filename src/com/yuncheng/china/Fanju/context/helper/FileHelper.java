package com.yuncheng.china.Fanju.context.helper;

import android.graphics.Bitmap;
import android.os.Environment;

import com.lidroid.xutils.bitmap.core.BitmapDecoder;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import com.yuncheng.china.Fanju.common.config.FileType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by agonyice on 14-9-10.
 */
public class FileHelper {
	private static final File FILE_SDCARD = Environment.getExternalStorageDirectory();
	private static final String APP_FOLDER_NAME = "FanJu";
	private static final File APP_FOLDER = new File(FILE_SDCARD, APP_FOLDER_NAME);
	private static final String IMAGE_FOLDER_NAME = "image";
	private static final File IMAGE_FOLDER = new File(APP_FOLDER, IMAGE_FOLDER_NAME);
	private static final String TEMP_IMAGE_FOLDER_NAME = "temp";
	private static final File TEMP_IMAGE_FOLDER = new File(IMAGE_FOLDER, TEMP_IMAGE_FOLDER_NAME);
	private static final String CACHE_IMAGE_FOLDER_NAME = "cache";
	private static final File CACHE_IMAGE_FOLDER = new File(IMAGE_FOLDER, CACHE_IMAGE_FOLDER_NAME);

	private static final FileHelper INSTANCE=new FileHelper();
	private FileHelper(){
		init();
	}

	public void  init(){
		initFolder(APP_FOLDER);
		initFolder(IMAGE_FOLDER);
		initFolder(TEMP_IMAGE_FOLDER);
		initFolder(CACHE_IMAGE_FOLDER);
	}

	public static File appFolder(){
		return APP_FOLDER;

	}
	public static File imageFolder(){
		return IMAGE_FOLDER;
	}
	public static File tempImageFolder(){
		return TEMP_IMAGE_FOLDER;
	}
	public static File cacheImageFolder(){
		return CACHE_IMAGE_FOLDER;
	}
	public static File createTempImageFile(FileType fileType){
		return new File(tempImageFolder(),System.currentTimeMillis()+fileType.getSuffix());

	}
	public static boolean save(Bitmap bitmap,String path,Bitmap.CompressFormat compressFormat,int quality) {
		FileOutputStream fileOutputStream=null;
		File file=new File(path);
		try {
		if(file.exists()){
			file.delete();
		}
		fileOutputStream=new FileOutputStream(file);
		bitmap.compress(compressFormat,quality,fileOutputStream);
		return  true;
		}catch (FileNotFoundException e) {
			LogUtils.w(e);
			return false;
		}finally {
			IOUtils.closeQuietly(fileOutputStream);
		}
	}
	public static Bitmap decodeFile(String path){
		FileOutputStream is=null;
		try{
			is=new FileOutputStream(path);
			return BitmapDecoder.decodeFileDescriptor(is.getFD());
		}catch (FileNotFoundException e){
			LogUtils.w(e);
		}catch(IOException e){
			LogUtils.w(e);
		}finally {
			IOUtils.closeQuietly(is);
		}
		return null;
	}
	private  static void initFolder(File file){
		if (!file.exists()){
			file.mkdirs();
		}
	}

}
