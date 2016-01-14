package com.cruise.id;

import java.util.UUID;

public class UUIDUtil {
	public static UUID createUUID()
	{
		return UUID.randomUUID();
	}
	public static String createUUIDString()
	{
		return UUID.randomUUID().toString();
	}
	
}
