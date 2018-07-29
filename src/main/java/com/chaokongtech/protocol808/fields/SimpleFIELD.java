package com.chaokongtech.protocol808.fields;

public class SimpleFIELD extends FIELD {
	
	public SimpleFIELD(int offset) {
		super(offset);
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
