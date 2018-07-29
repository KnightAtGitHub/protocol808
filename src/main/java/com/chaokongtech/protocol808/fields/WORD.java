package com.chaokongtech.protocol808.fields;

import com.chaokongtech.protocol808.utils.Utils;

public class WORD extends FIELD{
	private int value;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value){
		this.value = value;
	}
	
	public WORD(int offset) {
		super(offset, 2);
	}
	
	@Override
	public byte[] encode() {
		if (bs == null) {
			return Utils.integer2bytes(value, size);			
		}else {
			return bs;
		}
	}
	@Override
	public void decode(byte[] bytes) {
		this.bs = bytes;
		value = Utils.bytes2int(bytes);
	}
	
	
}
