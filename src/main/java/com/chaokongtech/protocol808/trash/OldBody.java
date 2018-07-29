package com.chaokongtech.protocol808.trash;

import com.chaokongtech.protocol808.utils.Utils;

public abstract class OldBody {
	protected int msgId;
	protected byte[] bytes;
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public OldBody(int msgId) {
		this.msgId = msgId;
	}
	public abstract void newBytes();
	public abstract byte[] toBytes();
	protected void addData(long num,int offset,int length){
//		System.out.println("addData");
		if (bytes == null) {
			System.out.println("bytes is null");
			return;
		}
		byte[] tmp = Utils.integer2bytes(num, length);
		for(int i=0;i<length;i++){
			bytes[offset+i] = tmp[i];
		}
	}
	protected void addData(byte[] source,int offset) {
		for(int i=0;i<source.length;i++){
			bytes[offset + i] = source[i];
		}
	}

}
