package com.chaokongtech.protocol808.fields;

import com.chaokongtech.protocol808.utils.Utils;

public class BCDn extends FIELD{
	private String value;
	public BCDn(int offset,int size) {
		super(offset,size);
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		if (value == null) {
			decode(bs);
		}
		return value;
	}
	@Override
	public byte[] encode() {
		return Utils.intStr2BCD(value, size);
	}
	@Override
	public void decode(byte[] bytes) {
		value = Utils.bcd2intStr(bytes);
	}

}
