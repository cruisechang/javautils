package com.cruise.id;

import com.cruise.id.IId;
import com.cruise.id.Bit64Id;

public class IdFactory {

	public enum IdType
	{
		BIT_64_ID;
	}
	
	public static IId createId(IdType idType,int autoIncrement)
	{
		switch(idType)
		{
		case BIT_64_ID:
			return new Bit64Id(autoIncrement);

			default:
				return null;
		}
	}
	
}
