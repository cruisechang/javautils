package com.cruise.finals;

public enum DateTime {

	HOUR_MILLI_SECOND(3600000),
	DAY_MILLI_SECOND(86400000),
	DAY_SECOND(864000);
	  
	 private long value;

	    
	 private DateTime(long value) {
		 this.value = value;
	    
	 }
	 public long getValue() {
		 return value;
	 }


	 
	   @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder();
	        sb.append("DateTime");
	        sb.append("{value=").append(value).append('\'');
	        sb.append('}');
	        return sb.toString();
	    }
}
