package com.chaokongtech.protocol808.fields;

import com.chaokongtech.protocol808.utils.Utils;

public class DWORD extends FIELD{
	private long value;
	public long getValue() {
		return value;
	}
	public DWORD setValue(long value){
		this.value = value;
		return this;
	}
	public DWORD() {
		size = 4;
	}
	public DWORD(int offset){
		super(offset,4);
	}
	public DWORD(int offset,long value) {
		super(offset, 4);
		this.value = value;
	}
	
	@Override
	public byte[] encode() {
		return Utils.integer2bytes(value, size);
	}
	@Override
	public void decode(byte[] bytes) {
		bs = bytes;
		value = Utils.bytes2int(bytes);
	}
	

}
