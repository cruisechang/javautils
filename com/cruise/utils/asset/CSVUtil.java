package com.cruise.utils.asset;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * @author cruisechang
 * @description
 * CSV utils.
 */
public class CSVUtil {

	/**
	 * 
	 * @param cvsReader  A file reader. E.g. Reader in = new FileReader("restaurantTowerData//tgb_restaurant_tag.csv");
	 * @param headerMapping A csv header mapping array. E.g. String [] headerMapping = {"restaurant_id","category","string_id"};
	 * @return
	 */
	public static Iterable<CSVRecord> getCSVRecords(Reader cvsReader,String[] headerMapping)
	{
		try{
			return  CSVFormat.DEFAULT.withHeader(headerMapping).parse(cvsReader);
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		/*
		for (CSVRecord record : records) {
			
			String lastName = record.get("restaurant_tag_id");
			String firstName = record.get("category");
			System.out.format("%s %s", lastName, firstName);
		}
		*/
	}
	
	/**
	 * 從targetHeader 找targetValue，然後找同一record的wantHeader的value.
	 * @param records  Target records.
	 * @param targetHeader Target header.
	 * @param targetId     Target id base on target header.根據header對照的那個值。
	 * @param wantHeader 要取的header. 
	 * @return
	 */
	public static String getStringValue(Iterable<CSVRecord> records,String targetHeader,String targetValue,String wantHeader)
	{
		for (CSVRecord record : records) {
			
			if(record.get(targetHeader).equals(targetValue)){
				return record.get(wantHeader);
			}
		}
		return "";
	}
	public static int getIntValue(Iterable<CSVRecord> records,String targetHeader,String targetValue,String wantHeader)
	{
		for (CSVRecord record : records) {
			
			if(record.get(targetHeader).equals(targetValue)){
				return Integer.parseInt(record.get(wantHeader));
			}
		}
		return 1;
	}

}
