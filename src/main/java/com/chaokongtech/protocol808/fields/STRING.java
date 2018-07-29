package com.chaokongtech.protocol808.fields;

import java.io.UnsupportedEncodingException;

public class STRING extends FIELD{
	private String  value;
	
	public STRING(int offset) {
		super(offset);
	}
	public STRING() {
	}
	
	public STRING setValue(String value) {
		this.value = value;
		size = value.getBytes().length;
		return this;
	}
	@Override
	public byte[] encode() {
		try {
			return value.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void decode(byte[] bytes) {
		try {
			value = new String(bytes, "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getValue() {
		return value;
	}
	public static void main(String[] args){
		STRING string = new STRING();
		string.setValue("hello 你好");
		byte[] tmp = string.encode();
		string.decode(tmp);
		System.out.println("string:" + string.getValue());
	}

}
