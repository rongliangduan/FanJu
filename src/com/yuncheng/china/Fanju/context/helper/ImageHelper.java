package com.yuncheng.china.Fanju.context.helper;

import android.graphics.Bitmap;
import android.view.View;

import com.china.yuncheng.fanju.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.yuncheng.china.Fanju.common.config.ImgQuality;
import com.yuncheng.china.Fanju.context.AppContext;
import com.yuncheng.china.Fanju.util.ImgUtil;

/**
 * Created by agonyice on 14-9-10.
 */
public class ImageHelper {
	public final static int MEMORY_CACHE_SIZE = 1024 * 1024 * 10; //10M
	public static final int DISK_CACHE_SIZE = 1024 * 1024 * 500;//500M
	private static final ImageHelper INSTANCE = new ImageHelper();
	private static final int BITMAP_THREAD_POOL_SIZE = 10;
	private static final long BITMAP_EXPIRY = Long.MAX_VALUE;
	private static AppContext appContext;
	private static BitmapUtils avatarUtils;
	private static BitmapUtils imgUtils;

	public void ImgHelper() {
		appContext = AppContext.getAppContext();
		init();
	}

	public static void displayAvatar(View view, String id, int size) {
		avatarUtils.display(view, ImgUtil.getUrl(id, size));
	}

	public static void displayAvatar(View View, String id, ImgQuality quality) {
		avatarUtils.display(View, ImgUtil.getUrl(id, quality));
	}

	public static void displayImg(View View, String id, int size) {
		imgUtils.display(View, ImgUtil.getUrl(id, size));
	}

	public static void displayImg(View View, String id, ImgQuality quality) {
		imgUtils.display(View, ImgUtil.getUrl(id, quality));
	}

	public static Bitmap getBitmapFromCache(String id, ImgQuality quality) {
		return imgUtils.getBitmapFromMemCache(ImgUtil.getUrl(id, quality), null);
	}

	public static void displayImg(View View, String uri) {
		imgUtils.display(View, uri);
	}

	public static void displayImg(View View, String uri, boolean showOriginal) {
		BitmapDisplayConfig BitmapDisplayConfig = new BitmapDisplayConfig();
		BitmapDisplayConfig.setShowOriginal(showOriginal);
		imgUtils.display(View, uri, BitmapDisplayConfig);
	}

	public static void displayImg(View view, String uri, int width, int height) {
		BitmapDisplayConfig bitmapDisplayConfig = new BitmapDisplayConfig();
		bitmapDisplayConfig.setShowOriginal(false);
		bitmapDisplayConfig.setBitmapMaxSize(new BitmapSize(width, height));
		imgUtils.display(view, uri, bitmapDisplayConfig);
	}

	public static <T extends View> void displayImg(T view, String id, ImgQuality quality, BitmapLoadCallBack<T> callBack) {
		imgUtils.display(view, ImgUtil.getUrl(id, quality), callBack);
	}

	private void init() {
		avatarUtils = createBitmapUtils(R.drawable.ic_launcher);
		imgUtils = createBitmapUtils(R.drawable.ic_launcher);
	}

	private BitmapUtils createBitmapUtils(int defaultLoadFailedImagResId) {
		BitmapUtils bitmapUtils = new BitmapUtils(appContext, FileHelper.cacheImageFolder().getPath(), MEMORY_CACHE_SIZE, DISK_CACHE_SIZE);
		bitmapUtils.configThreadPoolSize(BITMAP_THREAD_POOL_SIZE);
		bitmapUtils.configDiskCacheEnabled(true);
		bitmapUtils.configMemoryCacheEnabled(true);
		bitmapUtils.configDefaultShowOriginal(true);
		bitmapUtils.configDefaultLoadFailedImage(defaultLoadFailedImagResId);
		return bitmapUtils;
	}
}
