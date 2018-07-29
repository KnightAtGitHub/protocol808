package com.chaokongtech.protocol808.fields;

import com.chaokongtech.protocol808.utils.Utils;

public class BYTEn extends FIELD {
	public byte[] getBs() {
		return bs;
	}
	public BYTEn(int offset, int size) {
		super(offset, size);
	}
	public void setBytes(byte[] bytes){
		if (bytes.length == size) {
			this.bs = bytes;
		}else if (bytes.length > size) {
			bs = new byte[size];
			for(int i=0;i<size;i++){
				bs[i] = bytes[i];
			}
		}else {
			bs = Utils.bytesAdd0x00(bytes, size);
		}
	}
	@Override
	public byte[] encode() {
		return bs;
	}
	@Override
	public void decode(byte[] bytes) {
		bs = bytes;
	}

}
