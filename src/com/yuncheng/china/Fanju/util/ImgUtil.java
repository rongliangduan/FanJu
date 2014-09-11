package com.yuncheng.china.Fanju.util;

import com.yuncheng.china.Fanju.common.config.Service;
import com.yuncheng.china.Fanju.common.config.ImgQuality;

/**
 * Created by agonyice on 14-9-10.
 */
public class ImgUtil {
	public static final String getUrl(String id) {
		return String.format(Service.URL_LOAD_IMAGE, id, "");
	}

	public static final String getUrl(String id, int size) {
		return String.format(Service.URL_LOAD_IMAGE, id, size);
	}

	public static final String getUrl(String id, ImgQuality quality) {
		return String.format(Service.URL_LOAD_IMAGE, id, quality.getSize());
	}
}
