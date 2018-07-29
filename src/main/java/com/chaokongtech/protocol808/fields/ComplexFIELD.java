package com.chaokongtech.protocol808.fields;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaokongtech.protocol808.Body;

public abstract class ComplexFIELD extends FIELD {
	private static Logger logger = LogManager.getLogger(ComplexFIELD.class);
	
	protected ArrayList<FIELD> FIELDs = null;
	
	
	protected void reflectFields() {
		if (FIELDs != null) {
			return;
		}
		FIELDs = new ArrayList<FIELD>();
		logger.debug("reflectFields:" + this);
		
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field:fields){
			field.setAccessible(true);
			Object mField;
			try {
				logger.debug("field:" + field.getName());
				mField = field.get(this);
				if (mField != null) {
					if (mField.getClass().equals(FIELD.class) ||
							mField.getClass().getSuperclass().equals(FIELD.class) || 
							mField.getClass().getSuperclass().equals(ComplexFIELD.class)||
							mField.getClass().getSuperclass().equals(Body.class)) {
						FIELD myField = (FIELD)mField;
						FIELDs.add(myField);
						size += myField.size;
						logger.debug("find FIELD,size:" + myField.size);
					}
				}else {
					logger.debug("field null");
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void decode(byte[] bytes) {
		bs = bytes;
		reflectFields();
		for(FIELD field:FIELDs){
			byte[] tmp = new byte[field.size];
			for(int i=0;i<field.size;i++){
				tmp[i] = bytes[i + field.offset];
			}
			field.decode(tmp);
		}
	}
	@Override
	public byte[] encode() {
		reflectFields();
		logger.debug("size:" + size);
		bs = new byte[size];
		for(FIELD field:FIELDs){
			logger.debug("field:" + field.getClass());
			byte[] tmp = field.encode();
			for(int i=0;i<field.size;i++){
				
				bs[i + field.offset] = tmp[i];
			}
		}
		return bs;
	}
	

}
