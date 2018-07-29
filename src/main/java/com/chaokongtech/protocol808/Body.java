package com.chaokongtech.protocol808;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaokongtech.protocol808.fields.ComplexFIELD;
import com.chaokongtech.protocol808.fields.FIELD;

public class Body extends ComplexFIELD{
	private static Logger logger = LogManager.getLogger(Body.class);
	protected int msgId;
	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
		
	public Body(int msgId) {
		this.msgId = msgId;
		offset = 12;
	}
	@Deprecated
	public Body(int msgId,byte[] bytes){
		this.msgId = msgId;
		this.bs = bytes;
	}
	public Body() {
	}
	@Override
	public int getSize() {
		logger.debug("getSize");
		reflectFields();
		return super.getSize();
	}
	
}
