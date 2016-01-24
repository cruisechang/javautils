package com.cruise.utils.asset;

import java.io.FileReader;
import java.io.IOException;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtils {

	public static JSON JSONLoader(String url) {
		net.sf.json.groovy.JsonSlurper jp = new net.sf.json.groovy.JsonSlurper();

		try {

			JSON js = (JSON) jp.parse(new FileReader(url));
			return js;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * JSONArray to JSONObject using number as keys (begin with '0').
	 * 
	 * @param ary
	 *            JSONArray
	 * @return
	 */
	public static JSONObject JSONArrayToJSONObject(JSONArray ary) {

		int s = ary.size();
		if (s == 0) {
			return new JSONObject();
		}
		JSONArray keyAry = new JSONArray();

		for (int i = 0; i < s; i++) {
			keyAry.add(String.valueOf(i));
		}
		return ary.toJSONObject(keyAry);

	}

	/**
	 * JSONArray to JSONObject using assigned key's value as JSONObject key
	 * 用指定的key的值，當新JSONObject的key
	 * 要每個JSONArray裡的JSONObject都轉才行，JSONArray和轉出的JSONObject數目要相同
	 * 
	 * @param ary
	 * @param assignedKeyString
	 * @return
	 */
	public static JSONObject JSONArrayToJSONObjectWithAssignedKey(JSONArray ary, String assignedKeyStr) {

		int i, s = ary.size();
		if (s == 0) {
			return new JSONObject();
		}
		String id;
		JSONArray keyAry = new JSONArray();

		try {
			for (i = 0; i < s; i++) {
				Object obj = ary.get(i);
				if (obj instanceof JSONObject) {
					id = ((JSONObject) obj).getString(assignedKeyStr);
					if (id instanceof String && id.length() > 0) {
						keyAry.add(id);
					} else {
						return new JSONObject();
					}
				}
			}

			return ary.toJSONObject(keyAry);

		} catch (Exception e) {
			return new JSONObject();
		}
	}

}
