package com.chaokongtech.protocol808.fields;

import com.chaokongtech.protocol808.utils.Utils;

public class Arg extends ComplexFIELD{
	public DWORD argId = new DWORD(0);
	public BYTE argLength = new BYTE(4);
	public FIELD field;
	
	public Arg(long vArgId) {
		argId.setValue(vArgId);
	}
	public Arg(long vArgId,FIELD field){
		this(vArgId);
		setFIELD(field);
	}
	public Arg setFIELD(FIELD field){
		this.field = field;
		argLength.setByte((byte) field.getSize());
		size = 5 + field.size;
		return this;
	}
	
	public static void main(String[] args){
		Arg arg = new Arg(0x0001).setFIELD(new DWORD().setValue(1000));
		System.out.println("bytes:" + Utils.bytesToString(arg.encode()));
	}
		

}
