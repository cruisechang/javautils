package com.cruise.id;

import com.cruise.id.IId;
import com.cruise.utils.BitUtil;

/**
 * Generate 64Bit id.
 * 
 * @author cruisechang
 *
 */
public class Bit64Id implements IId{

	private long id=0;

	public Bit64Id(int autoIncrement)
	{
		init(autoIncrement);
	}
	
	private void init(int autoIncrement)
	{
		//總共64bit
		//section 1,currentTimeMillis=41bit
		//<<64-41=<<23
		this.id=System.currentTimeMillis()<<23;		
		
		  //section 2,auto increment %8191=0-8190=13bit,
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
