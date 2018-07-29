package com.chaokongtech.protocol808.fields;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaokongtech.protocol808.utils.Utils;

public abstract class FIELD {
	private static Logger logger = LogManager.getLogger(FIELD.class);
	
	protected int offset = 0;
	protected int size = 0;
	protected byte[] bs;
	
	public byte[] getBs() {
		return bs;
	}
	public void setBs(byte[] bs) {
		this.bs = bs;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size){
		this.size = size;
	}
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset){
		this.offset = offset;
	}
	public void setPropterty(int offset,int size){
		this.offset = offset;
		this.size = size;
	}
	
	
	public FIELD(int offset,int size) {
		this.offset = offset;
		this.size = size;
	}
	public FIELD(int offset){
		this.offset = offset;
	}
	public FIELD() {
	}
	
	public abstract byte[] encode();
	public void decode(byte[] bytes){
		bs = bytes;
	}
	
	
	
	/*protected byte[] getBytes(){
		Field[] fields = this.getClass().getDeclaredFields();
		ArrayList<FIELD> fIELDs = new ArrayList<FIELD>();
		int length = 0;
		for(Field field:fields){
			field.setAccessible(true);
			Object mField;
			try {
				logger.debug("field:" + field.getName());
				mField = field.get(this);
				if (mField != null) {
					if (mField.getClass().getSuperclass().equals(FIELD.class)) {
						logger.debug("find field");
						FIELD myField = (FIELD)mField;
						length += myField.size;
						fIELDs.add(myField);
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		byte[] dis = new byte[length];
		for(FIELD field:fIELDs){
			addField(field,dis);
		}
		return dis;
		
	}
	protected static void addField(FIELD field,byte[] dis){
		byte[] tmp = field.encode();
		int offset = field.getOffset();
		for(int i=0;i<tmp.length;i++){
			dis[offset+i] = tmp[i];
		}
	}*/
}
