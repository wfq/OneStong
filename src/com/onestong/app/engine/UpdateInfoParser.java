package com.onestong.app.engine;

import java.io.BufferedReader;

import com.google.gson.Gson;
import com.onestong.app.domain.UpdateInfo;

/**
 * 解析XML数据
 * @author wangfangqi
 * 
 */
public class UpdateInfoParser {
	/**
	 * @param reader
	 *            读取到的json输入流
	 * @return updateinfo的对象
	 */
	public static UpdateInfo getUpdateInfo(BufferedReader reader) {
		Gson gson = new Gson();
		UpdateInfo info = gson.fromJson(reader, UpdateInfo.class);
		return info;
	}
}
