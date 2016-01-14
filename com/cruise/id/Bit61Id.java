package com.cruise.id;

import com.cruise.utils.BitUtil;

public class Bit61Id {

	private long id=0;

	public Bit61Id(int autoIncrement)
	{
		init(autoIncrement);
	}
	
	private void init(int autoIncrement)
	{
		//總共61bit
		//41+10+10
		
		//section 1,currentTimeMillis=41bit
		//最左保留正負號只<<20
		this.id=System.currentTimeMillis()<<20;		
		
		  //section 2,auto increment %1024=0-1023=10bit,
		  //<<64-41-13=<<10
		  // 1341位移 10bit 然後和id 做 or運算
		  this.id|=(autoIncrement%1024)<<10;

		  //section 3, data sharding 用auto increment%100，放　10bit
		  this.id|=(autoIncrement%100);
		  
	}
	public long getId()
	{
		return this.id;
	}
	
	public long getIdDatetime()
	{
		String binaryStr=BitUtil.decimalToBinaryString(this.id);
		binaryStr=binaryStr.substring(0, 41);						//取id section 1的bit
		return BitUtil.longBinaryStringToLong(binaryStr);
	}
}
