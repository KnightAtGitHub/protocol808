package com.chaokongtech.protocol808.fields;

import java.text.DateFormat.Field;

public class BYTE extends FIELD{
	private byte b;
	public BYTE() {
		size = 1;
	}
	public BYTE(int offset) {
		super(offset, 1);
	}
	public void setByte(byte b){
		
		this.b = b;
	}
	@Override
	public byte[] encode() {
		return new byte[]{b};
	}
	@Override
	public void decode(byte[] bytes) {
		bs = bytes;
		b = bytes[0];
	}

}
