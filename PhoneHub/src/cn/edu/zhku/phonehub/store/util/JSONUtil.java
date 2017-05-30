package cn.edu.zhku.phonehub.store.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	
	/**
	 * 
	 * @param obj
	 * @return String,JSON�����String����
	 */
	public static String ObjectToJsonString(Object obj){
		JSONObject json = JSONObject.fromObject(obj);
		String str = json.toString();
		return str;
	}
	/**
	 * 
	 * @param ls
	 * @return String,JSONArray��String����
	 */
	public static String ArrayToJsonString(List ls){
		JSONArray json = JSONArray.fromObject(ls);
		String str = json.toString();
		return str;
	}

}
